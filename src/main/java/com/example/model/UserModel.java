package com.example.model;

import st.tool.FormatPager;

public class UserModel extends FormatPager{
	private Integer id;
	private String user_name;
	private String user_pass;
	private String user_code;
	private String role_code;
	
	private String role_name;
	private String parent_code;
	



	public UserModel() {
		super();
	}

	

	public UserModel(String user_name, String user_pass, String user_code, String role_code, String parent_code) {
		super();
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_code = user_code;
		this.role_code = role_code;
		this.parent_code = parent_code;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", user_name=" + user_name + ", user_pass=" + user_pass + ", user_code="
				+ user_code + ", role_code=" + role_code + ",  role_name=" + role_name
				+ ", parent_code=" + parent_code + "]";
	}



	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}



}
