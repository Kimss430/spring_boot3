package com.example.test1.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.AreaService2;
import com.google.gson.Gson;

@Controller
public class AreaController2 {

	@Autowired
	AreaService2 areaService2;
	
	@RequestMapping("/area2.do")
	public String area(Model model) throws Exception{
		return "/area2";
	}
	
	@RequestMapping(value = "/si-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String area(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = areaService2.searchSiList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/gu-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String area2(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = areaService2.searchguList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/dong-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String area3(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = areaService2.searchDongList(map);
		
		return new Gson().toJson(resultMap);
	}
	
}
