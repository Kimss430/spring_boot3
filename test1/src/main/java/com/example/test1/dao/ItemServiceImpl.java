package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.ItemMapper;
import com.example.test1.model.Code;
import com.example.test1.model.Item;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemMapper itemMapper;

	@Override
	public HashMap<String, Object> searchItemList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		HashMap<String, Object> itemList = itemMapper.selectItemList(map);
		
		try {
			
			resultMap.put("itemList", itemList);
			resultMap.put("result", "sucess");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			resultMap.put("fail", "오류");
		}
		return resultMap;
	}


}