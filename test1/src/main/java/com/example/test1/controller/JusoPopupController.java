package com.example.test1.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.SampleService;
import com.google.gson.Gson;

@Controller
public class JusoPopupController {

	@RequestMapping("/jusoPopup.do")
	public String sample(Model model) throws Exception{
		return "/jusoPopup";
	}
	@RequestMapping("/addr.do")
	public String addr(Model model) throws Exception{
		return "/addr";
	}
	
}
