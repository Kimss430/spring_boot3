package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.SchoolMapper;
import com.example.test1.model.Board;
import com.example.test1.model.School;
@Service
public class SchoolServiceImpl implements SchoolService {

@Autowired
SchoolMapper schoolMapper;

	@Override
	public HashMap<String, Object> searchStuList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> resultMap = 
				new HashMap<String, Object>();
		List<School> list = schoolMapper.selectStuList(map);
		int count = schoolMapper.selectStuListCnt(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchStuInfo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> resultMap = 
				new HashMap<String, Object>();
		School list = schoolMapper.selectStuInfo(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		
		return resultMap;
	}

}
