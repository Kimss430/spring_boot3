package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Code;
import com.example.test1.model.Item;

@Mapper
public interface ItemMapper {
	
	HashMap<String, Object> selectItemList(HashMap<String, Object> map);
}
