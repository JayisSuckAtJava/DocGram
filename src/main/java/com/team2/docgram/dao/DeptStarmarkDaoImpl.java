package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DeptStarmarkDto;

@Repository
public class DeptStarmarkDaoImpl implements DeptStarmarkDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "starmark.";

	@Override
	public void createDeptmark(DeptStarmarkDto deptStarmarkDto) {
		sqlSession.insert(mapper+"createDeptmark", deptStarmarkDto);
	}

	@Override
	public void deleteDeptmark(DeptStarmarkDto deptStarmarkDto) {
		sqlSession.delete(mapper+"deleteDeptmark", deptStarmarkDto);
	}

}
