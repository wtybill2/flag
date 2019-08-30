package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.RoleModel;
import com.example.serviceImpl.RoleServiceImpl;

import st.tool.FormatEmpty;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl IroleService;
	
	
	@RequestMapping(value = "/getRoleListAll", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getRoleListAll(RoleModel roleModel, Integer page, Integer limit) {
		//System.out.println(productModel.toString());
		String code = roleModel.getRole_code();
		if (!FormatEmpty.isEmpty(code)) {
			roleModel.setRole_code("%" + code + "%");
		}
		String name = roleModel.getRole_name();
		if (!FormatEmpty.isEmpty(name)) {
			roleModel.setRole_name("%" + name + "%");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("data", IroleService.selectAll(roleModel));
		map.put("code", 0);
		// map.put("msg", "");
		map.put("count", IroleService.selectCount(roleModel));
		return new JSONObject(map).toString();
	}

}
