package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.MenuService;
import com.example.service.UserService;

import st.tool.FormatEmpty;

import com.example.mapper.MenuMapper;
import com.example.mapper.UserMapper;
import com.example.model.AuthModel;
import com.example.model.UserModel;

@Service
public class MenuServiceImpl implements MenuService<AuthModel> {
	@Autowired
	private MenuMapper<AuthModel> menuMapper;
	
	@Override
	public List<AuthModel> selectDao(AuthModel t) {
		
		return menuMapper.selectDao(t);
	}
	@Override
	public int update(AuthModel t) {
		// TODO Auto-generated method stub
		return menuMapper.update(t);
	}
	@Override
	public int updateAll(AuthModel t) {
		return menuMapper.updateAll(t);
		
	}
	
}
