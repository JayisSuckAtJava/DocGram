package com.team2.docgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.HashtagDao;
@Service
public class HashtagServiceImpl implements HashtagService {
	
	@Autowired
	private HashtagDao hashtagDao;

	@Override
	public Long readHashtag(String tagName) {
		return hashtagDao.readHashtag(tagName);
	}

}
