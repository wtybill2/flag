package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.ProdMapper;
import com.example.model.ProductModel;
import com.example.service.ProdService;
@Service
public class ProductServiceImpl implements ProdService<ProductModel> {
	@Autowired
	public ProdMapper<ProductModel> prodMapper;

	

	@Override
	public List<ProductModel> selectModel(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.selectModel(t);
	}

	@Override
	public int selectCount(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.selectCount(t);
	}

	@Override
	public ProductModel select(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.select(t);
	}

	@Override
	public int insert(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.insert(t);
	}

	@Override
	public List<ProductModel> selectAll(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.selectAll(t);
	}
	
	@Override
	public int deletebyId(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.deletebyId(t);
	}
	@Override
	public int updatebyId(ProductModel t) {
		// TODO Auto-generated method stub
		return prodMapper.updatebyId(t);
	}

	


}
