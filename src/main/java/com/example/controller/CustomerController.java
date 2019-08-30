package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.CusComModel;
import com.example.model.CustomerModel;
import com.example.model.UserModel;
import com.example.serviceImpl.CusComServiceImpl;
import com.example.serviceImpl.CustServiceImpl;

import st.tool.FormatEmpty;

@Controller
@RequestMapping("cus")
public class CustomerController {
	
	@Autowired
	private CustServiceImpl IcustomerService;
	
	@Autowired
	private CusComServiceImpl IcusComService;
	
	
	@RequestMapping("/cusadd")
	private String cusadd() {
		return "customer/customer_addcommunication";
		
	}
	@RequestMapping("/add")
	@ResponseBody
	private String add(CusComModel cuscomModel,HttpSession session) {
		String cust_code=cuscomModel.getCust_code();
		UserModel username=(UserModel) session.getAttribute("user");
		String user_code=username.getUser_code();
		
		String time=cuscomModel.getTIME();
		
		
		String type=cuscomModel.getType();
		String content=cuscomModel.getContent();
		CusComModel model = new CusComModel(cust_code,user_code,time,type,content);
        return FormatEmpty.isEmpty(IcusComService.insert(model)) ? "2" : "0";
		
	}
	@RequestMapping(value = "/getcustlist", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getList(CustomerModel customerModel, Integer page, Integer limit) {
		//System.out.println(productModel.toString());
		String code = customerModel.getCust_code();
		if (!FormatEmpty.isEmpty(code)) {
			customerModel.setCust_code("%" + code + "%");
		}
		String name = customerModel.getCust_name();
		if (!FormatEmpty.isEmpty(name)) {
			customerModel.setCust_name("%" + name + "%");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("data", IcustomerService.selectModel(customerModel));
		map.put("code", 0);
		
		map.put("count", IcustomerService.selectCount(customerModel));
		return new JSONObject(map).toString();
	}
	
	@RequestMapping(value = "/getcuscomlist", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getcuscomlist(CusComModel cusComModel, Integer page, Integer limit) {
		//System.out.println(productModel.toString());
		String code = cusComModel.getCust_code();
		if (!FormatEmpty.isEmpty(code)) {
			cusComModel.setCust_code("%" + code + "%");
		}
		String name = cusComModel.getUser_code();
		if (!FormatEmpty.isEmpty(name)) {
			cusComModel.setUser_code("%" + name + "%");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("data", IcusComService.selectModel(cusComModel));
		map.put("code", 0);
		
		map.put("count", IcusComService.selectCount(cusComModel));
		return new JSONObject(map).toString();
	}
	public static void main(String[] args) {
//		String a="aa\r\ndaf\r\nsgg";
//		String b=StringUtils.substringBefore(a, "\r\n");
//		System.out.println(b);
		while(true) {
			Scanner sc=new Scanner(System.in);
			String write=sc.next();
			switch(write){
			case "1":
				System.out.println(write);
				continue;
				//return;
				//break;
			default:
			System.out.println(write);
			break;
			//return;
			}
			//break;
			//return;
		}
	}
}
