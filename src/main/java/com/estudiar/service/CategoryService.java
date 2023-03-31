package com.estudiar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudiar.model.Category;
import com.estudiar.repository.ICategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{

	private ICategoryRepository iCategoryRepository;

	@Override
	public Category create(Category category) {
		return iCategoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return iCategoryRepository.save(category);
	}

	@Override
	public Category findById(Integer id) {
		Optional<Category> optional = iCategoryRepository.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<Category> findAll() {
		return iCategoryRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		iCategoryRepository.deleteById(id);
	}
	
}
