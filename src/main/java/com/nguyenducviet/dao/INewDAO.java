package com.nguyenducviet.dao;

import java.util.List;

import com.nguyenducviet.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
