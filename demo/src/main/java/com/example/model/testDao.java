package com.example.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class testDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<testDto> selectList() {
		List<testDto> list = sqlSession.selectList("test.selectList");
		return list;
	}
}
