package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;

public interface SearchDao {

	List<BoardDto> searchDetail(Map<String, Object> map);

}
