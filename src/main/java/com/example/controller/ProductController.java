package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.model.ProductModel;
import com.example.serviceImpl.ProductServiceImpl;

import st.tool.FormatEmpty;
import st.tool.FormatPOI;

@Controller
@RequestMapping("/pro")
public class ProductController {

	@Autowired
	private ProductServiceImpl IproductService;

	@RequestMapping("/product")
	private String getproduct() {
		return "product/product_list";
	}

	@RequestMapping("/productmenu")
	private String getproductmenu() {
		return "order/order";
	}

	@RequestMapping("/proadd")
	private String proadd() {
		return "product/product_add";
	}

	@RequestMapping(value = "/delpro", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String delpro(String id) {
		ProductModel model = new ProductModel();
		model.setId(Integer.parseInt(id));
		return IproductService.deletebyId(model) + "";
	}

	@RequestMapping(value = "/proupd", produces = "application/json;charset=utf-8")

	public String proupd(String id, Model model) {
		ProductModel user = new ProductModel();
		user.setId(Integer.parseInt(id));
		ProductModel list = IproductService.select(user);
		model.addAttribute("list", list);
		System.out.println(list);
		return "product/product_update";
	}
	
	@RequestMapping(value = "/updpro", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String updpro(ProductModel productModel,String id) {
		productModel.setId(Integer.parseInt(id));
		return IproductService.updatebyId(productModel)+"";
	}

	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String list() {
		String code = "%";
		ProductModel pp = new ProductModel();
		pp.setCode(code);
		List<ProductModel> list = IproductService.selectAll(pp);

		return new JSONArray(list).toString();
	}

	@RequestMapping("/add")
	@ResponseBody
	private String add(ProductModel productModel) {
		String code = productModel.getCode();
		ProductModel pp=new ProductModel();
		pp.setCode(code);
		//System.out.println(productModel.toString());
		ProductModel ss = IproductService.select(pp);
		if (!FormatEmpty.isEmpty(ss)) {
			return "1";
		}
		String name = productModel.getName();
		String cost = productModel.getCost();
		String sum = productModel.getSum();

		ProductModel model = new ProductModel(code, name, sum, cost);
		return FormatEmpty.isEmpty(IproductService.insert(model)) ? "2" : "0";

	}

	@RequestMapping(value = "uploadExcel")
	@ResponseBody
	public String uploadExcel(CommonsMultipartResolver multipartResolver, HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("code", "0");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				result.put("data", parse(file.getInputStream()));
			}
		}
		return new JSONObject(result).toString();
	}

	private List<ProductModel> parse(InputStream fis) throws IOException {
		// 由输入流得到工作簿
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// 得到工作表
		XSSFSheet sheet = workbook.getSheet("list");
		List<ProductModel> list = new ArrayList<>();
		for (Row row : sheet) {
			if (0 == row.getRowNum()) {
				continue;
			}
			ProductModel userModel = new ProductModel();
			userModel.setCode(getValue(row.getCell(0)));
			userModel.setName(getValue(row.getCell(1)));
			userModel.setSum(getValue(row.getCell(2)));
			userModel.setCost(getValue(row.getCell(3)));
			list.add(userModel);
			add(userModel);
		}
		workbook.close();
		fis.close();
		return list;
	}

	private String getValue(Cell cell) {
		CellType type = cell.getCellTypeEnum();
		if (CellType.STRING.equals(type)) {
			return cell.getStringCellValue();
		} else if (CellType.NUMERIC.equals(type)) {
			return String.valueOf(cell.getNumericCellValue());
		}
		return null;
	}

	@RequestMapping(value = "exportExcel")
	public void exportExcel(HttpServletResponse response) throws Exception {

		List<ProductModel> dataList = IproductService.selectModel(new ProductModel());
		List<String> propList = Arrays.asList("code", "name", "sum", "cost");
		List<String> fieldName = Arrays.asList("账号", "姓名", "库存", "花费");

		Workbook wb = FormatPOI.exportExcel(dataList, propList, fieldName);

		// 1)、设置响应的头文件，会自动识别文件内容
		response.setContentType("multipart/form-data");
		// 2)、设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=test.xls");
		// 3)、输出流
		OutputStream out = response.getOutputStream();
		wb.write(out);
		wb.close();
		out.close();
	}

	@RequestMapping(value = "exportExcelTpl")
	public void exportExcelTpl(HttpServletResponse response) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("list");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell0 = row.createCell(0);
		cell0.setCellValue("账号");
		XSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("姓名");
		XSSFCell cell2 = row.createCell(2);
		cell2.setCellValue("库存");
		XSSFCell cell3 = row.createCell(3);
		cell3.setCellValue("花费");

		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
		OutputStream out = response.getOutputStream();
		workbook.write(out);
		workbook.close();
		out.close();
	}

	@RequestMapping(value = "/getList", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getList(ProductModel productModel, Integer page, Integer limit) {
		//System.out.println(productModel.toString());
		String code = productModel.getCode();
		if (!FormatEmpty.isEmpty(code)) {
			productModel.setCode("%" + code + "%");
		}
		String name = productModel.getName();
		if (!FormatEmpty.isEmpty(name)) {
			productModel.setName("%" + name + "%");
		}
//		if (!FormatEmpty.isEmpty(page)) {
//			productModel.setPageIndex(page);
//		}
//		if (!FormatEmpty.isEmpty(limit)) {
//			productModel.setPageLimit(limit);
//		}
//		productModel.setPageOn(true);
		Map<String, Object> map = new HashMap<>();
		map.put("data", IproductService.selectModel(productModel));
		map.put("code", 0);
		// map.put("msg", "");
		map.put("count", IproductService.selectCount(productModel));
		return new JSONObject(map).toString();
	}
}
