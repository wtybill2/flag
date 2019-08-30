package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.RoleMapper;
import com.example.model.RoleModel;
import com.example.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService<RoleModel> {
	
	@Autowired
	private RoleMapper<RoleModel> roleMapper;

	@Override
	public List<RoleModel> selectAll(RoleModel t) {
		// TODO Auto-generated method stub
		return roleMapper.selectAll(t);
	}

	@Override
	public int selectCount(RoleModel t) {
		// TODO Auto-generated method stub
		return roleMapper.selectCount(t);
	}

	

}
