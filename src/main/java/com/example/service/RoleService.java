package com.example.service;

import java.util.List;

public interface RoleService<T> {
	
	List<T> selectAll(T t);
	
	int selectCount(T t);

}
