package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Area;

@Mapper
public interface AreaMapper {
	
	List<Area> siList(HashMap<String, Object> map);
	
	List<Area> guList(HashMap<String, Object> map);
	
}
