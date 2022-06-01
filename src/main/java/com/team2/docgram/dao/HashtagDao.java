package com.team2.docgram.dao;

import com.team2.docgram.dto.HashtagDto;

/**  HashtagDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface HashtagDao {

	HashtagDto createHashtag(HashtagDto hashtag);

	Long readHashtag(String tagName);

}
