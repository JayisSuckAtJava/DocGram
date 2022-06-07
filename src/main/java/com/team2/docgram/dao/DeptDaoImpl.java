package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DeptDto;

/**  DeptDaoImpl.java
 *   Dept Table 에 접근하는 DAO
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
	 * Dept 객체의 id 로 정보 조회
	 * 
	 * @param deptId PK 인 id
	 * @return 해당 Dept의 모든 정보를 담은 객체
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public DeptDto readDeptList(Long deptId) {
		return sqlSession.selectOne(mapper+"readDeptList", deptId);
	}

	/**
	 * 부서 검색
	 * 
	 * @param name Dept 의 이름에 포함되는 단어
	 * @return 검색된 부서들의 List
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@Override
	public List<DeptDto> searchDept(String name) {
		return sqlSession.selectList(mapper+"searchDept",name);
	}
	
	
}
