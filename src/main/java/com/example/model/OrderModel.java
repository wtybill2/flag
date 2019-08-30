package com.example.model;

import st.tool.FormatPager;

public class OrderModel extends FormatPager{
	private Integer id;
	private String user_code;
	private String cust_code;
	private String prod_code;
	private int count;
	private String TIME;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public String getProd_code() {
		return prod_code;
	}
	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderModel(String user_code, String cust_code, String prod_code, int count, String tIME, String status) {
		super();
		this.user_code = user_code;
		this.cust_code = cust_code;
		this.prod_code = prod_code;
		this.count = count;
		TIME = tIME;
		this.status = status;
	}
	public OrderModel() {
		super();
	}
	
}
