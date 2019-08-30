package com.example.service;

import java.util.List;

import com.example.model.AuthModel;



public interface MenuService<T> {
	
	List<T> selectDao(T t);

	int update(T t);

	int updateAll(T t);
   
}
