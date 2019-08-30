package com.example.service;

import java.util.List;



public interface UserService<T> {
	String insert(T t);

	String delete(Object t);

	int updateActive(T t);

	T select(T t);
	
	//T selecter(T t);
	
	T selectrole(T t);
	
	List<T> selectAll(T t);

    List<T> selectModel(T t);

    int selectCount(T t);
    
    
}
