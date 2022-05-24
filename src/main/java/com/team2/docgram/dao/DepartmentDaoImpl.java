package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** DepartMentDaoImpl.java
 *   부서 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

}
