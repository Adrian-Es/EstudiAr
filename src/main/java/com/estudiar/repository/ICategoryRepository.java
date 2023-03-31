package com.estudiar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudiar.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{

}
