package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Area;
import com.example.test1.model.Payment;

@Mapper
public interface PaymentMapper {
	
	List<Payment> payment(HashMap<String, Object> map);
	
}
