package com.estudiar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudiar.model.Item;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IItemRepository extends JpaRepository<Item, Integer>{
	
	@Query(nativeQuery = true,
			value = "Select * from items i where i.category_id = :category_id")
	List<Item> getItemsWithCategoryId(@Param("category_id") Integer id);
	
	@Modifying
	@Query(nativeQuery = true,
			value = "Delete from items i where i.category_id = :category_id")
	void deleteItemsByCategoryId(@Param("category_id") Integer id);
}
