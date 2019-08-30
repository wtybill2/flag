package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.UserModel;


public interface UserMapper<T> {
	int insert(T t);

    int delete(Object t);

    int updateActive(T t);

    T select(T t);
    
    //T selecter(@Param(value="st")T t);

    List<T> selectAll(T t);

    List<T> selectModel(T t);

    int selectCount(T t);

	T selectrole(T t);
	
	List<T> selectDao(T t);
	
	
}
