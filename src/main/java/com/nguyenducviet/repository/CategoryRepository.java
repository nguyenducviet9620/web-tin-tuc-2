package com.nguyenducviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenducviet.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
