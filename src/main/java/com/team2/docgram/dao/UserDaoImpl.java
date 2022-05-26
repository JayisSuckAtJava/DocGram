package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.UserDto;

/** UserDaoImpl.java
 *   사용자 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";

	
	
	/**
	 * User의 PK 값을 사용해 User 객체 반환
	 * 
	 * @param num 해당 User 테이블의 PK 값
	 * @return UserDto PK값으로 조회한 1개의 User 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-19
	 */
	@Override
	public UserDto readOne(Integer num) {
		return sqlSession.selectOne(mapper+"readOne", num);
	}

	
}
