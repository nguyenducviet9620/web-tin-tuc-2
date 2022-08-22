package com.nguyenducviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenducviet.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}
