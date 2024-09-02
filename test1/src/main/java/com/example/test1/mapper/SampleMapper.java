package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Sample;

@Mapper
public interface SampleMapper {
	
	List<Sample> selectBoardList(HashMap<String, Object> map);
}
