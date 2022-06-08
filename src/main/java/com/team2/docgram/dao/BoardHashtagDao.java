package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardHashtagDto;
import com.team2.docgram.dto.HashtagDto;

/**  BoardHashtagDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface BoardHashtagDao {

	List<HashtagDto> readList(Long boardId);

	void createBoardHashtag(Map<String, Object> map);

	Long readBoardHashtag(Map<String, Object> map);

	void deleteHashtagList(Long boardId);

	void deleteHashtag(BoardHashtagDto boardHashtag);

	void createBoardHashtag(BoardHashtagDto boardHashtag);

}
