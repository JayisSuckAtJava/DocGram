package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**  PositionDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class PositionDaoImpl implements PositionDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = ".";
}
