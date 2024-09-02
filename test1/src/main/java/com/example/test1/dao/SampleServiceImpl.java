package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.SampleMapper;
import com.example.test1.model.Sample;

@Service
public class SampleServiceImpl implements SampleService{
	@Autowired
	SampleMapper sampleMapper;
	
	@Override
	public HashMap<String, Object> selectBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		try {
			List<Sample> sampleList = sampleMapper.selectBoardList(map);
			resultMap.put("sampleList", sampleList);
			resultMap.put("result", "success");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			
			
		}
		
		return resultMap;
	}

}
