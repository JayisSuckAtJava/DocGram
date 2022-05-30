package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.HashtagDto;

@Repository
public class HashtagDaoImpl implements HashtagDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "hashtag.";

	@Override
	public HashtagDto createHashtag(HashtagDto hashtag) {
		sqlSession.insert(mapper+"createHashtag", hashtag);
		return hashtag;
	}
}
