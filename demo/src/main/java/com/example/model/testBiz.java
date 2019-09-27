package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testBiz {
	
	@Autowired
	private testDao dao;
	
	public List<testDto> selectList() {
		return dao.selectList();
	}
}
