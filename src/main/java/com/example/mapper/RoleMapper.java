package com.example.mapper;

import java.util.List;

import com.example.model.RoleModel;

public interface RoleMapper<T> {
	
	List<T> selectAll(T t);

	int selectCount(T t);

}
