package com.example.model;

import st.tool.FormatPager;

public class ProductModel extends FormatPager {
	private Integer id;
	private String code;
	private String name;
	private String sum;
	private String cost;
	
	
	
	
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", code=" + code + ", name=" + name + ", sum=" + sum + ", cost=" + cost + "]";
	}
	public ProductModel(String code, String name, String sum, String cost) {
		super();
		this.code = code;
		this.name = name;
		this.sum = sum;
		this.cost = cost;
	}
	public ProductModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	  
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
}
