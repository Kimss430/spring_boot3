package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.PaymentMapper;
import com.example.test1.model.Area;
import com.example.test1.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentMapper paymentMapper;
	
	@Override
	public HashMap<String, Object> paymentChart(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		
		try {
			List<Payment> list = paymentMapper.payment(map);

			resultMap.put("list", list);
			resultMap.put("result", "success");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			
			
		}
		
		return resultMap;
	}

}
