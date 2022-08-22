package com.nguyenducviet.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nguyenducviet.dao.INewDAO;
import com.nguyenducviet.mapper.NewMapper;
import com.nguyenducviet.model.NewModel;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());
	}
}
