package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.team2.docgram.dto.UserDto;

/** UserDaoImpl.java
 *   사용자 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

	@Override
	public UserDto readOne(Integer num) {
		return sqlSession.selectOne(mapper+"readOne", num);
	}

	
}
