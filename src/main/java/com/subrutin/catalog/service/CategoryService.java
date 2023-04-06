package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.Category;
import com.subrutin.catalog.dto.CategoryCreateUpdateRecordDTO;
import com.subrutin.catalog.dto.CategoryListResponseDTO;
import com.subrutin.catalog.dto.ResultPageResponseDTO;

import java.util.List;
import java.util.Map;

public interface CategoryService {
	
	public void createAndUpdateCategory(CategoryCreateUpdateRecordDTO dto);
	
	public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, 
			Integer limit, String sortBy, String direction, String categoryName);
	
	public List<Category> findCategories(List<String> categoryCodeList);
	
	public List<CategoryListResponseDTO> constructDTO(List<Category> categories);
	
	public Map<Long, List<String>> findCategoriesMap(List<Long> bookIdList);
	
}
