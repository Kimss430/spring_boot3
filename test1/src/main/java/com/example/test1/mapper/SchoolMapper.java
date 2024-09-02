package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Board;
import com.example.test1.model.School;

@Mapper
public interface SchoolMapper {
	
	// 학생목록
	List<School> selectStuList(HashMap<String, Object> map);
	
	School selectStuInfo(HashMap<String, Object> map);
	
	int selectStuListCnt(HashMap<String, Object> map);
}
