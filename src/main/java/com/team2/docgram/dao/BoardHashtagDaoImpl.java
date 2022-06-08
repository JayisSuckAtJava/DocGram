package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardHashtagDto;
import com.team2.docgram.dto.HashtagDto;

/**  BoardHashtagDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class BoardHashtagDaoImpl implements BoardHashtagDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "hashtag.";

	 /**
	 * 설명
	 * 
	 * @param boardId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public List<HashtagDto> readList(Long boardId) {
		return sqlSession.selectList(mapper+"readList", boardId);
	}

	 /**
	 * 설명
	 * 
	 * @param map 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public void createBoardHashtag(Map<String, Object> map) {
		sqlSession.insert(mapper+"createBoardHashtag", map);
	}

	 /**
	 * 설명
	 * 
	 * @param map
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public Long readBoardHashtag(Map<String, Object> map) {
		return sqlSession.selectOne(mapper+"readBoardHashtag", map);
	}

	 /**
	 * 설명
	 * 
	 * @param boardId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public void deleteHashtagList(Long boardId) {
		sqlSession.delete(mapper+"deleteHashtagList", boardId);
	}

	/**
	 * 설명
	 * 
	 * @param boardHashtag 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public void deleteHashtag(BoardHashtagDto boardHashtag) {
		sqlSession.delete(mapper+"deleteHashtag",boardHashtag);
	}

	/**
	 * 설명
	 * 
	 * @param boardHashtag 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public void createBoardHashtag(BoardHashtagDto boardHashtag) {
		sqlSession.insert(mapper+"createBoardHashtag", boardHashtag);
	}
	
	
	
}
