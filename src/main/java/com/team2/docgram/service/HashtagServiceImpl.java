package com.team2.docgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.HashtagDao;
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

}
