package com.subrutin.catalog.web;

import com.subrutin.catalog.dto.CategoryCreateUpdateRecordDTO;
import com.subrutin.catalog.dto.CategoryListResponseDTO;
import com.subrutin.catalog.dto.ResultPageResponseDTO;
import com.subrutin.catalog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class CategoryResource {

	private final CategoryService categoryService;
	
	@PostMapping("/v1/category")
	public ResponseEntity<Void> createAndUpdateCategory(@RequestBody @Valid CategoryCreateUpdateRecordDTO dto){
		categoryService.createAndUpdateCategory(dto);
		return ResponseEntity.created(URI.create("/v1/category")).build();
		
	}
	
	@GetMapping("/v1/category")
	public ResponseEntity<ResultPageResponseDTO<CategoryListResponseDTO>> findCategoryList(
			@RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages, 
			@RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
			@RequestParam(name="sortBy", required = true, defaultValue = "name") String sortBy,
			@RequestParam(name="direction", required = true, defaultValue = "asc") String direction,
			@RequestParam(name="categoryName", required = false) String categoryName){
		return ResponseEntity.ok().body(categoryService.findCategoryList(pages, limit, sortBy, direction, categoryName));
	}
}
