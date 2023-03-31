package com.estudiar.service;

import java.util.List;

import com.estudiar.model.Item;

public interface IItemService {
	Item create(Item item);
	
	Item update(Item item);
	
	Item findById(Integer id);
	
	List<Item> findAll();
	
	List<Item> findByCategoryId(Integer id);
	
	void deleteById(Integer id);
	
	void deleteByCategoryId(Integer id);
	
}
