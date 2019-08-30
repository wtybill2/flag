package com.example.mapper;

import java.util.List;

import com.example.model.AuthModel;

public interface MenuMapper<T> {
	
	List<T> selectDao(T t);

	int update(T t);

	int updateAll(T t);
}
