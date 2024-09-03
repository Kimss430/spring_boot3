package com.example.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PaymentController {

	@RequestMapping("/payment.do")
	public String payment(Model model) throws Exception {
		return "/payment";
	}
	
	
}
