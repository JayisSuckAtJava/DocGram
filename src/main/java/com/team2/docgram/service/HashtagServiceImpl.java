package com.team2.docgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardHashtagDao;
import com.team2.docgram.dao.HashtagDao;
import com.team2.docgram.dto.BoardHashtagDto;
import com.team2.docgram.dto.HashtagDto;
/**  HashtagServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class HashtagServiceImpl implements HashtagService {
	
	@Autowired
	private HashtagDao hashtagDao;
	
	@Autowired
	private BoardHashtagDao boardHashtagDao; 

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
		return hashtagDao.readHashtag(tagName);
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
		return hashtagDao.readHashtag(hashtagId);
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
		return hashtagDao.readHashtagList(id);
	}

	/**
	 * 설명
	 * 
	 * @param boardId
	 * @param hashtagId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public void deleteHashtag(Long boardId, Long hashtagId) {
		BoardHashtagDto boardHashtag = new BoardHashtagDto();
		boardHashtag.setBoardId(boardId);
		boardHashtag.setHashtagId(hashtagId);
		boardHashtagDao.deleteHashtag(boardHashtag);
		
	}

	/**
	 * 설명
	 * 
	 * @param boardId
	 * @param hashtagName 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public void createHashtag(Long boardId, String hashtagName) {
		Long hashtagId = hashtagDao.readHashtag(hashtagName);
		
		if(hashtagId == null) {
			HashtagDto hashtag = new HashtagDto();
			hashtag.setName(hashtagName);
			hashtag = hashtagDao.createHashtag(hashtag);
			hashtagId = hashtag.getId();			
		}
		
		BoardHashtagDto boardHashtag = new BoardHashtagDto();
		
		boardHashtag.setBoardId(boardId);
		boardHashtag.setHashtagId(hashtagId);
		Long boardHashtagId = boardHashtagDao.readBoardHashtag(boardHashtag);
		if(boardHashtagId == null) {
			boardHashtagDao.createBoardHashtag(boardHashtag);			
		}
	}

}
