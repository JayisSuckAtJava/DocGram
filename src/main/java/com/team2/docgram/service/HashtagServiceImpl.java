package com.team2.docgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.HashtagDao;
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

}
