package com.subrutin.catalog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.subrutin.catalog.domain.Category;
import com.subrutin.catalog.dto.CategoryCreateUpdateRecordDTO;
import com.subrutin.catalog.dto.CategoryCreateUpdateRequestDTO;
import com.subrutin.catalog.dto.CategoryListResponseDTO;
import com.subrutin.catalog.dto.CategoryQueryDTO;
import com.subrutin.catalog.dto.ResultPageResponseDTO;
import com.subrutin.catalog.exception.BadRequestException;
import com.subrutin.catalog.repository.CategoryRepository;
import com.subrutin.catalog.service.CategoryService;
import com.subrutin.catalog.util.PaginationUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	@Override
	public void createAndUpdateCategory(CategoryCreateUpdateRecordDTO dto) {
		 Category category =  categoryRepository.findByCode(dto.code().toLowerCase()).orElse(new Category());
		 if(category.getCode()==null) {
			 category.setCode(dto.code().toLowerCase()); //new 
		 }
		 category.setName(dto.name());
		 category.setDescription(dto.description());
		 
		 categoryRepository.save(category);
	}

	@Override
	public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy,
			String direction, String categoryName) {
		categoryName =  StringUtils.isEmpty(categoryName) ? "%":categoryName+"%";
		Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
		Pageable pageable = PageRequest.of(pages, limit, sort);
		Page<Category> pageResult =  categoryRepository.findByNameLikeIgnoreCase(categoryName, pageable);
		List<CategoryListResponseDTO> dtos =  pageResult.stream().map((c)->{
			CategoryListResponseDTO dto = new CategoryListResponseDTO();
			dto.setCode(c.getCode());
			dto.setName(c.getName());
			dto.setDescription(c.getDescription());
			return dto;
		}).collect(Collectors.toList());
		return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
	}

	@Override
	public List<Category> findCategories(List<String> categoryCodeList) {
		List<Category> categories= categoryRepository.findByCodeIn(categoryCodeList);
		if(categories.isEmpty()) throw new BadRequestException("category cant empty");
		return categories;
	}

	@Override
	public List<CategoryListResponseDTO> constructDTO(List<Category> categories) {
		return categories.stream().map((c)->{
			CategoryListResponseDTO dto = new CategoryListResponseDTO();
			dto.setCode(c.getCode());
			dto.setName(c.getName());
			dto.setDescription(c.getDescription());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public Map<Long, List<String>> findCategoriesMap(List<Long> bookIdList) {
		List<CategoryQueryDTO> queryList =  categoryRepository.findCategoryByBookIdList(bookIdList);
		Map<Long, List<String>> categoryMaps = new HashMap<>();
		List<String> categoryCodeList = null;
		for(CategoryQueryDTO q:queryList) {
			if(!categoryMaps.containsKey(q.getBookId())) {
				categoryCodeList = new ArrayList<>();
			}else {
				categoryCodeList = categoryMaps.get(q.getBookId());
			}
			categoryCodeList.add(q.getCategoryCode());
			categoryMaps.put(q.getBookId(), categoryCodeList);
		}
		return categoryMaps;
	}

}
