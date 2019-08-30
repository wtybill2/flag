package com.example.model;

import java.util.List;

public class AuthModel {
	private Integer id;
	private String role_code;
	private String menu_code;
	private String menu_name;
	private List<MenuModel> list;

	public List<MenuModel> getList() {
		return list;
	}

	public void setList(List<MenuModel> list) {
		this.list = list;
	}
	
	
	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	
}
