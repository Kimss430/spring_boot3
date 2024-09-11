package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.AreaMapper;
import com.example.test1.model.Area;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	AreaMapper areaMapper;
	
	@Override
	public HashMap<String, Object> siArea(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		
		List<Area> list;
		try {
			System.out.println(map);
			if(!map.get("si").equals("")) {
				list = areaMapper.guList(map);
				System.out.println("구");
			} else {
				list = areaMapper.siList(map);
				System.out.println("시");
			};
			
			resultMap.put("list", list);
			resultMap.put("result", "success");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			
			
		}
		
		return resultMap;
	}


}
