package com.example.mapper;

import java.util.List;

import com.example.model.ProductModel;

public interface ProdMapper<T> {
	
    List<T> selectModel(T t);
    
    List<T> selectAll(T t);

    int selectCount(T t);

    T select(Object t);

    int insert(T t);

	int deletebyId(T t);
	
	int updatebyId(T t);
}
