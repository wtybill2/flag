package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.UserService;

import st.tool.FormatEmpty;

import com.example.mapper.UserMapper;
import com.example.model.AuthModel;
import com.example.model.UserModel;

@Service
public class UserServiceImpl implements UserService<UserModel> {
	@Autowired
	public UserMapper<UserModel> userMapper;

	@Override
	public String insert(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.insert(t)+"";
	}

	@Override
	public String delete(Object t) {
		// TODO Auto-generated method stub
		return userMapper.delete(t)+"";
	}

	@Override
	public int updateActive(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.updateActive(t);
	}

	@Override
	public UserModel select(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.select(t);
	}

	@Override
	public List<UserModel> selectAll(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.selectAll(t);
	}

	@Override
	public List<UserModel> selectModel(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.selectModel(t);
	}

	@Override
	public int selectCount(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.selectCount(t);
	}

	@Override
	public UserModel selectrole(UserModel t) {
		// TODO Auto-generated method stub
		return userMapper.selectrole(t);
	}

	


	

	
	
}
