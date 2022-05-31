package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.UserStarmarkDto;
@Repository
public class UserStarmarkDaoImpl implements UserStarmarkDao {
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "starmark.";

	@Override
	public void createStarmark(UserStarmarkDto userStarmarkDto) {
		sqlSession.insert(mapper+"createStarmark", userStarmarkDto);
	}

	@Override
	public void deleteStarmark(UserStarmarkDto userStarmarkDto) {
		sqlSession.delete(mapper+"deleteStarmark", userStarmarkDto);
	}

}
