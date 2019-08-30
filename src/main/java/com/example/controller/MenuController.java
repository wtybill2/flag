package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.AuthModel;
import com.example.model.MenuModel;
import com.example.serviceImpl.MenuServiceImpl;



@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuServiceImpl menuServiceImpl;
	
	@RequestMapping("menuupd")
	private String menuupd(String role_code,Model model) {
		
		model.addAttribute("role_code",role_code);
		AuthModel auth1=new AuthModel();
		auth1.setRole_code(role_code);
		List<AuthModel> list1 = menuServiceImpl.selectDao(auth1);
		model.addAttribute("list1", list1);
		
		AuthModel auth=new AuthModel();
		auth.setRole_code("generalmanager");
		List<AuthModel> list = menuServiceImpl.selectDao(auth);
		model.addAttribute("list", list);
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		for (AuthModel ss : list) {
			List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("label", ss.getMenu_name());
			map.put("id", ss.getMenu_code());
			for (MenuModel aa : ss.getList()) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("label", aa.getMenu_name());
				map1.put("id", aa.getMenu_code());
				list3.add(map1);
			}
			map.put("children", list3);
			list2.add(map);
		}
		model.addAttribute("editJurisdiction", new JSONArray(list2));
		return "user/authUpdate";
	}
	
	@RequestMapping(value="/getMenu")
	private String index(String code,String role,Model model) {
		
		AuthModel auth=new AuthModel();
		auth.setRole_code(role);
		List<AuthModel> list = menuServiceImpl.selectDao(auth);
		model.addAttribute("list", list);
		return "/index";
		
	}
	
	@RequestMapping(value="/updMenu")
	@ResponseBody
	private String updMenu(String role_code,String[] menu_codearr,String[] newmenu_codearr) {

		
		int a=0;
		AuthModel model=new AuthModel();
		model.setRole_code(role_code);
		menuServiceImpl.updateAll(model);
			for (String ss : newmenu_codearr) {
				model.setMenu_code(ss);
				a = menuServiceImpl.update(model);
			}

		return a > 0 ? "success" : "err";
		
	}
	
	
	@RequestMapping(value="/getMenulist")
	@ResponseBody
	private String getMenulist(String role,Model model) {
		System.out.println(role);
		AuthModel auth=new AuthModel();
		auth.setRole_code(role);
		List<AuthModel> list = menuServiceImpl.selectDao(auth);
		
		return new JSONArray(list).toString();
		
	}
}
