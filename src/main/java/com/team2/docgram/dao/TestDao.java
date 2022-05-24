package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

	public String test() {
		String text;
		int a = sqlSession.insert("team2.test");
		if(a==0) {
			text = " yes ";
		}else {
			text = " not ";
		}
		
		return text;
	}
}
