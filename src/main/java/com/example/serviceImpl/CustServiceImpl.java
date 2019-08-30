package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CustMapper;
import com.example.model.CustomerModel;
import com.example.service.CustService;

@Service
public class CustServiceImpl implements CustService<CustomerModel> {
	@Autowired
	private CustMapper<CustomerModel> custMapper;

	@Override
	public List<CustomerModel> selectModel(CustomerModel t) {
		// TODO Auto-generated method stub
		return custMapper.selectModel(t);
	}

	@Override
	public List<CustomerModel> selectAll(CustomerModel t) {
		// TODO Auto-generated method stub
		return custMapper.selectAll(t);
	}

	@Override
	public int selectCount(CustomerModel t) {
		// TODO Auto-generated method stub
		return custMapper.selectCount(t);
	}

	@Override
	public CustomerModel select(Object t) {
		// TODO Auto-generated method stub
		return custMapper.select(t);
	}

	@Override
	public int insert(CustomerModel t) {
		// TODO Auto-generated method stub
		return custMapper.insert(t);
	}

}
