package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.init.ImageCode;
import com.example.model.ProductModel;
import com.example.model.UserModel;
import com.example.serviceImpl.UserServiceImpl;

import st.tool.FormatEmpty;
import st.tool.MD5;

@Controller
@RequestMapping(value = "/user")
public class UserController {
//	 private static org.apache.log4j.Logger
//	 logger=org.apache.log4j.Logger.getLogger("busi");
	@Autowired
	private UserServiceImpl IuserService;

	@RequestMapping(value = "/cuscomm")
	private String cuscomm() {
		return "customer/customer_commication";
	}
	
	@RequestMapping(value = "/logout")
	private String logout() {
		return "login";
	}
	@RequestMapping(value = "/user_list")
	private String getUserList() {
		return "user/user_list";
	}
	
	@RequestMapping(value = "/cusmag")
	private String cusmag() {
		return "customer/customer_manage";
	}

	@RequestMapping(value = "/mail")
	private String mail() {
		return "user/mail";
	}
	@RequestMapping(value = "/authmanage")
	private String authmanage() {
		return "user/authmanage";
	}

	@RequestMapping(value = "/reg")
	private String reg() {
		return "/register";

	}
	
	@RequestMapping(value = "/getUserListAll", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getList(UserModel userModel, Integer page, Integer limit) {
		//System.out.println(productModel.toString());
		String code = userModel.getUser_code();
		if (!FormatEmpty.isEmpty(code)) {
			userModel.setUser_code("%" + code + "%");
		}
		String name = userModel.getUser_name();
		if (!FormatEmpty.isEmpty(name)) {
			userModel.setUser_name("%" + name + "%");
		}
//		if (!FormatEmpty.isEmpty(page)) {
//			userModel.setPageIndex(page);
//		}
//		if (!FormatEmpty.isEmpty(limit)) {
//			userModel.setPageLimit(limit);
//		}
//		userModel.setPageOn(true);
		Map<String, Object> map = new HashMap<>();
		map.put("data", IuserService.selectModel(userModel));
		map.put("code", 0);
		// map.put("msg", "");
		map.put("count", IuserService.selectCount(userModel));
		return new JSONObject(map).toString();
	}
	
	@RequestMapping(value = "/loginsuccess")
	@ResponseBody
	private String login(String code, String role, String pass, HttpSession session) {

		String pass1 = MD5.encode(pass);
		UserModel t = new UserModel();
		t.setUser_code(code);
		UserModel ModelDB = IuserService.select(t);

		if (!ModelDB.getRole_code().equals(role)) {

			return "3";
		} else if (ModelDB != null && ModelDB.getUser_pass().equals(pass1)) {
			UserModel u1 = new UserModel();
			u1.setRole_code(role);
			UserModel ui = IuserService.selectrole(u1);
			ModelDB.setRole_name(ui.getRole_name());
			session.setAttribute("user", ModelDB);
			return "0";
		} else {
			return "1";
		}
	}

	@RequestMapping(value = "/add")
	@ResponseBody
	private String add(String name, String code, String role, String pass, String AuthCode, HttpSession session) {
		UserModel t = new UserModel();
		t.setUser_code(code);
		UserModel u2 = IuserService.select(t);
		if (!FormatEmpty.isEmpty(u2)) {
			return "2";
		}
		UserModel u1 = new UserModel();
		u1.setRole_code(role);
		UserModel ui = IuserService.selectrole(u1);
		String pp = ui.getParent_code();
		String pp1 = ui.getRole_name();
		String pass1 = MD5.encode(pass);
		UserModel user = new UserModel();
		user.setUser_name(name);
		user.setUser_pass(pass1);
		user.setUser_code(code);
		user.setRole_code(role);
		user.setRole_name(pp1);
		user.setParent_code(pp);
		session.setAttribute("user", user);
		return IuserService.insert(user);

	}

	@RequestMapping(value = "/images/imagecode")
	public String imagecode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OutputStream os = response.getOutputStream();
		Map<String, Object> map = ImageCode.getImageCode(60, 20, os);
		String simpleCaptcha = "simpleCaptcha";
		request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
		request.getSession().setAttribute("codeTime", new Date().getTime());
		try {
			ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
		} catch (IOException e) {
			return "";
		}
		return null;
	}

	@RequestMapping(value = "/checkcode")
	@ResponseBody
	public String checkcode(HttpServletRequest request, HttpSession session) throws Exception {
		String checkCode = request.getParameter("AuthCode");
		Object cko = session.getAttribute("simpleCaptcha"); // 验证码对象
		if (cko == null) {
			request.setAttribute("errorMsg", "验证码已失效，请重新输入！");
			return "验证码已失效，请重新输入！";
		}
		String captcha = cko.toString();
		Date now = new Date();
		Long codeTime = Long.valueOf(session.getAttribute("codeTime") + "");
		if (StringUtils.isEmpty(checkCode) || captcha == null || !(checkCode.equalsIgnoreCase(captcha))) {
			request.setAttribute("errorMsg", "验证码错误！");
			return "验证码错误！";
		} else if ((now.getTime() - codeTime) / 1000 / 60 > 5) {
			// 验证码有效时长为5分钟
			request.setAttribute("errorMsg", "验证码已失效，请重新输入！");
			return "验证码已失效，请重新输入！";
		} else {
			session.removeAttribute("simpleCaptcha");
			return "1";
		}
	}

}
