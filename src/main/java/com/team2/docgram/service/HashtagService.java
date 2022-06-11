package com.team2.docgram.service;

import java.util.List;

import com.team2.docgram.dto.HashtagDto;

/**  HashtagService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface HashtagService {

	Long readHashtag(String tagName);

	String readHashtag(Long hashtagId);

	List<HashtagDto> readHashtagList(Long id);

	void deleteHashtag(Long boardId, Long hashtagId);

	void createHashtag(Long boardId, String hashtagName);

}
