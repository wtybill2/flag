package com.example.model;

public class CusComModel {
	
	private Integer id;
	private String cust_code;
	private String user_code;
	private String TIME;
	private String type;
	private String content;
	
	
	public CusComModel(String cust_code, String user_code, String tIME, String type, String content) {
		super();
		this.cust_code = cust_code;
		this.user_code = user_code;
		TIME = tIME;
		this.type = type;
		this.content = content;
	}
	public CusComModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
