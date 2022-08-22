package com.nguyenducviet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenducviet.entity.CategoryEntity;
import com.nguyenducviet.repository.CategoryRepository;
import com.nguyenducviet.service.ICategoryService;



@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryReposetory;
	
	@Override
	public Map<String,String> findAll() {
		Map<String,String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryReposetory.findAll();
		for(CategoryEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
}
