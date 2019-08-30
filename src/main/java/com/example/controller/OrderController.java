package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.OrderModel;
import com.example.model.ProductModel;
import com.example.model.UserModel;
import com.example.serviceImpl.OrderServiceImpl;
import com.example.serviceImpl.ProductServiceImpl;


import st.tool.FormatEmpty;
@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderServiceImpl IOrderService;
	@Autowired
	private ProductServiceImpl IproductService;
	
	@RequestMapping(value = "/getList", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getList(OrderModel orderModel, Integer page, Integer limit) {
		String code = orderModel.getCust_code();
		if (!FormatEmpty.isEmpty(code)) {
			orderModel.setCust_code("%" + code + "%");
		}
		String name = orderModel.getProd_code();
		if (!FormatEmpty.isEmpty(name)) {
			orderModel.setProd_code("%" + name + "%");
		}
		if (!FormatEmpty.isEmpty(page)) {
			orderModel.setPageIndex(page);
		}
		if (!FormatEmpty.isEmpty(limit)) {
			orderModel.setPageLimit(limit);
		}
		orderModel.setPageOn(true);
		Map<String, Object> map = new HashMap<>();
		map.put("data", IOrderService.selectModel(orderModel));
		map.put("code", 0);
		map.put("count", IOrderService.selectCount(orderModel));
		return new JSONObject(map).toString();
	}
	
	@RequestMapping("getaddlist")
	public String getaddlist() {
		
		return "order/order_add";
	}
	
	@RequestMapping("/getproductlist")
	@ResponseBody
	private String getproductlist() {
		ProductModel pro=new ProductModel();
		pro.setCode("%");
        List<ProductModel> list = IproductService.selectAll(pro);
        System.out.println(list.toString());
        return FormatEmpty.isEmpty(list) ? "" : new JSONArray(list).toString();
	}
	@RequestMapping("/add")
	@ResponseBody
	private String add(OrderModel orderModel,HttpSession session) {
		String cust_code=orderModel.getCust_code();
		
		OrderModel ss=IOrderService.select(cust_code);
		if(!FormatEmpty.isEmpty(ss)) {
			return "1";
		}
		UserModel username=(UserModel) session.getAttribute("user");
		String user_code=username.getUser_code();
		String prod_code=orderModel.getProd_code();
		String time=orderModel.getTIME();
		System.out.println(time);
		
		int count=orderModel.getCount();
		String status=orderModel.getStatus();
		OrderModel model = new OrderModel(user_code,cust_code,prod_code,count,time,status);
        return FormatEmpty.isEmpty(IOrderService.insert(model)) ? "2" : "0";
		
	}
	

}


