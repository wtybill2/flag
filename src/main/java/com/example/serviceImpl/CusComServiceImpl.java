package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CusComMapper;
import com.example.model.CusComModel;
import com.example.service.CusComService;

@Service
public class CusComServiceImpl implements CusComService<CusComModel> {
	
	@Autowired
	private CusComMapper<CusComModel> cusComMapper;

	@Override
	public List<CusComModel> selectModel(CusComModel t) {
		return cusComMapper.selectModel(t);
	}

	@Override
	public List<CusComModel> selectAll(CusComModel t) {
		return cusComMapper.selectAll(t);
	}

	@Override
	public int selectCount(CusComModel t) {
		return cusComMapper.selectCount(t);
	}

	@Override
	public CusComModel select(Object t) {
		return cusComMapper.select(t);
	}

	@Override
	public int insert(CusComModel t) {
		return cusComMapper.insert(t);
	}

}
