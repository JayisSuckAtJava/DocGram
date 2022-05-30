package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.HashtagDto;

@Repository
public class BoardHashtagDaoImpl implements BoardHashtagDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "hashtag.";

	@Override
	public List<HashtagDto> readList(Long boardId) {
		return sqlSession.selectList(mapper+"readList", boardId);
	}

	@Override
	public void createBoardHashtag(Map<String, Object> map) {
		sqlSession.insert(mapper+"createBoardHashtag", map);
	}
	
}
