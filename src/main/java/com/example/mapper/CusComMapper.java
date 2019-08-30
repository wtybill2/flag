package com.example.mapper;

import java.util.List;

public interface CusComMapper<T> {
	
	List<T> selectModel(T t);

	List<T> selectAll(T t);

	int selectCount(T t);

	T select(Object t);

	int insert(T t);

}
