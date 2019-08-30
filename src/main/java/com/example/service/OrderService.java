package com.example.service;

import java.util.List;

public interface OrderService<T> {
	
	List<T> selectModel(T t);

    int selectCount(T t);
    
    T select(Object t);

    int insert(T t);
}
