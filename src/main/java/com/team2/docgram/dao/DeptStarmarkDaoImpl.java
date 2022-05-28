package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptStarmarkDaoImpl implements DeptStarmarkDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = ".";
}
