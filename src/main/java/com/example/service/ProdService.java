package com.example.service;

import java.util.List;

import com.example.model.ProductModel;

public interface ProdService<T> {
	
	List<T> selectModel(T t);
	
	List<T> selectAll(T t);

    int selectCount(T t);
    
    T select(T t);

    int insert(T t);
    
    int deletebyId(T t);

	int updatebyId(ProductModel t);

}
