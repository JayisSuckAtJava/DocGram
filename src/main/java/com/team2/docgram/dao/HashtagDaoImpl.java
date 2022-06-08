package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.HashtagDto;

/**  HashtagDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class HashtagDaoImpl implements HashtagDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "hashtag.";

	 /**
	 * 설명
	 * 
	 * @param hashtag
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public HashtagDto createHashtag(HashtagDto hashtag) {
		sqlSession.insert(mapper+"createHashtag", hashtag);
		return hashtag;
	}

	 /**
	 * 설명
	 * 
	 * @param tagName
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public Long readHashtag(String tagName) {
		return sqlSession.selectOne(mapper+"readHashtag", tagName);
	}

	 /**
	 * 설명
	 * 
	 * @param hashtagId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public String readHashtag(Long hashtagId) {
		return sqlSession.selectOne(mapper+"readHashtagName", hashtagId);
	}

	/**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<HashtagDto> readHashtagList(Long id) {
		return sqlSession.selectList(mapper+"readHashtagList", id);
	}
}
