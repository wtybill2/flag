package com.example.mapper;

import java.util.List;

public interface OrderMapper<T> {
	
	List<T> selectModel(T t);

    int selectCount(T t);

    T select(Object t);

    int insert(T t);
}
