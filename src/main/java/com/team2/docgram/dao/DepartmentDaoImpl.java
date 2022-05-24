package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DepartmentDto;

/** DepartMentDaoImpl.java
 *   부서 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";



	 /**
	 * DeptPk 를 사용하여 DeptDto 반환
	 * 
	 * @param deptPk 검색할 dept 구분을 위한 pk
	 * @return DepartmentDto 모든 데이터를 담은 Dept 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public DepartmentDto readOne(Integer deptPk) {
		return sqlSession.selectOne(mapper+"",deptPk);
	}

}
