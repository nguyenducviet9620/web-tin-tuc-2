package com.nguyenducviet.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nguyenducviet.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(long id);
//	NewDTO insert(NewDTO insertNew);
//	NewDTO update(NewDTO updateNew);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);

}
