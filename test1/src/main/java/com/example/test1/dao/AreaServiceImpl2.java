package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.AreaMapper;
import com.example.test1.mapper.AreaMapper2;
import com.example.test1.mapper.ItemMapper;
import com.example.test1.model.Area;

@Service
public class AreaServiceImpl2 implements AreaService2{
	@Autowired
	AreaMapper2 areaMapper2;

	@Override
	public HashMap<String, Object> searchSiList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		
		List<Area> siList = areaMapper2.selectSiList(map);
		resultMap.put("siList", siList);
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchguList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		
		List<Area> guList = areaMapper2.selectGuList(map);
		resultMap.put("guList", guList);
		return resultMap;
		
	}

	@Override
	public HashMap<String, Object> searchDongList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		
		List<Area> dongList = areaMapper2.selectDongList(map);
		resultMap.put("dongList", dongList);
		return resultMap;
		
	}
	
	
}
