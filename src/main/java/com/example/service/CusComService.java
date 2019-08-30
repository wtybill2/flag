package com.example.service;

import java.util.List;

public interface CusComService<T> {
	
	List<T> selectModel(T t);

	List<T> selectAll(T t);

	int selectCount(T t);

	T select(Object t);

	int insert(T t);

}
