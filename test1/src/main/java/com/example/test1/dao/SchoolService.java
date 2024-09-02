package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import com.example.test1.model.School;

public interface SchoolService {
	
	
	HashMap<String, Object> searchStuList(HashMap<String, Object> map);
	
	HashMap<String,Object> searchStuInfo(HashMap<String,Object> map);

}
