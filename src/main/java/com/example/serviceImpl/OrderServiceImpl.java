package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.OrderMapper;
import com.example.model.OrderModel;
import com.example.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService<OrderModel> {
	
	@Autowired
	private OrderMapper<OrderModel> orderMapper;

	@Override
	public List<OrderModel> selectModel(OrderModel t) {
		// TODO Auto-generated method stub
		return orderMapper.selectModel(t);
	}

	@Override
	public int selectCount(OrderModel t) {
		// TODO Auto-generated method stub
		return orderMapper.selectCount(t);
	}

	@Override
	public OrderModel select(Object t) {
		// TODO Auto-generated method stub
		return orderMapper.select(t);
	}

	@Override
	public int insert(OrderModel t) {
		// TODO Auto-generated method stub
		return orderMapper.insert(t);
	}
	

}
