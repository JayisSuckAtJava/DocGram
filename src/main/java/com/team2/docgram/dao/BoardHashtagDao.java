package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.HashtagDto;

public interface BoardHashtagDao {

	List<HashtagDto> readList(Long boardId);

	void createBoardHashtag(Map<String, Object> map);

}
