package com.estudiar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudiar.model.Item;
import com.estudiar.repository.IItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemService implements IItemService {

	private IItemRepository iItemRepository;

	@Override
	public Item create(Item item) {
		return iItemRepository.save(item);
	}

	@Override
	public Item update(Item item) {
		return iItemRepository.save(item);
	}

	@Override
	public Item findById(Integer id) {
		Optional<Item> optional = iItemRepository.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<Item> findAll() {
		return iItemRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		iItemRepository.deleteById(id);
	}

	@Override
	public List<Item> findByCategoryId(Integer id) {
		return iItemRepository.getItemsWithCategoryId(id);
	}

	@Override
	public void deleteByCategoryId(Integer id) {
		iItemRepository.deleteItemsByCategoryId(id);
		
	}

}
