package com.nguyenducviet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenducviet.converter.NewConverter;
import com.nguyenducviet.dto.NewDTO;
import com.nguyenducviet.entity.CategoryEntity;
import com.nguyenducviet.entity.NewEntity;
import com.nguyenducviet.repository.CategoryRepository;
import com.nguyenducviet.repository.NewRepository;
import com.nguyenducviet.service.INewService;

@Service
public class NewService implements INewService {
	

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

//	@Override
//	@Transactional
//	public NewDTO insert(NewDTO insertNew) {
//		CategoryEntity category = categoryRepository.findOneByCode(insertNew.getCategoryCode());
//		NewEntity newEntity = newConverter.toEntity(insertNew);
//		newEntity.setCategory(category);
//		
//		return newConverter.toDto(newRepository.save(newEntity));
//	}
//
//	@Override
//	@Transactional
//	public NewDTO update(NewDTO dto) {
//		NewEntity oldNew = newRepository.findOne(dto.getId());
//		CategoryEntity category =categoryRepository.findOneByCode(dto.getCategoryCode());
//		oldNew.setCategory(category);
//		NewEntity updateNew = newConverter.toEntity(oldNew, dto);
//		return newConverter.toDto(newRepository.save(updateNew));
//	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category =categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if(dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {	
		for(long id : ids) {
			newRepository.delete(id);
		}
	}
}
