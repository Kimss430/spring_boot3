package com.example.test1.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.PaymentService;
import com.google.gson.Gson;


@Controller
public class ChartController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/chart.do")
	public String payment(Model model) throws Exception {
		return "/chart";
	}
	
	@RequestMapping(value = "/chart.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String chart(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = paymentService.paymentChart(map);
		return new Gson().toJson(resultMap);
		

	}
}
