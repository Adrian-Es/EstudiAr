package com.estudiar.mapper;

import java.util.ArrayList;
import java.util.List;

import com.estudiar.dto.CategoryAll;
import com.estudiar.dto.CategoryInfo;
import com.estudiar.dto.CategoryRegister;
import com.estudiar.model.Category;

public class CategoryMapper {

	//toEntity
	public static Category CategoryRegisterToCategory(CategoryRegister categoryRegister) {
		return new Category(categoryRegister.getName());
	}
	
	//toDto
	public static CategoryInfo categorytoCategoryInfo(Category category) {
		if(category==null) return null;
		
		return new CategoryInfo(category.getId(), category.getName());
	}
	
	public static CategoryAll categoryToCategoryAll(Category category) {
		if(category==null) return null;
		return new CategoryAll(
				category.getId(),
				category.getName(),
				ItemMapper.toItemInfoSet(category.getItems()));
	}
	
	//EntityList to DtoList
	public static List<CategoryInfo> toCategoryInfoList(List<Category> categories){
		if(categories==null) return null;
		List<CategoryInfo> categoriesInfo = new ArrayList<CategoryInfo>();
		
		categories.forEach(t -> {
			categoriesInfo.add(categorytoCategoryInfo(t));
		});
		
		return categoriesInfo;
	}
	
}
