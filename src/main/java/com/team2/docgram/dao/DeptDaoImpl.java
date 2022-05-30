package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DeptDto;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";

	@Override
	public DeptDto readDeptList(Long deptId) {
		return sqlSession.selectOne(mapper+"readDeptList", deptId);
	}
	
	
}
