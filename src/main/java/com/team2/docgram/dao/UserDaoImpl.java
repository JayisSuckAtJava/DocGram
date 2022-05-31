package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";

	@Override
	public UserDto readUser(UserDto user) {
		return sqlSession.selectOne(mapper+"readUser", user);
	}

	@Override
	public void createUser(UserDto user) {
		sqlSession.insert(mapper+"createUser", user);
	}

	@Override
	public Integer updateUser(UserDto user) {
		return sqlSession.update(mapper+"updateUser", user);
	}

	@Override
	public void updateHashtag(Long hashtagId) {
		sqlSession.update(mapper+"updateUser", hashtagId);
	}
	
}
