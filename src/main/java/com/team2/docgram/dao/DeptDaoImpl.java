package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DeptDto;

/**  DeptDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";

	 /**
	 * 설명
	 * 
	 * @param deptId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public DeptDto readDeptList(Long deptId) {
		return sqlSession.selectOne(mapper+"readDeptList", deptId);
	}

	@Override
	public List<DeptDto> searchDept(String name) {
		return sqlSession.selectList(mapper+"searchDept",name);
	}
	
	
}
