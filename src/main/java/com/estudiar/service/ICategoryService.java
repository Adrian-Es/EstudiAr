package com.estudiar.service;

import java.util.List;

import com.estudiar.model.Category;

public interface ICategoryService {

	Category create(Category category);
	
	Category update(Category category);
	
	Category findById(Integer id);
	
	List<Category> findAll();
	
	void deleteById(Integer id);
	
}
