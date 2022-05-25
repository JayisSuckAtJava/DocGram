package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;

public interface SearchService {

	List<BoardDto> searchDetail(Map<String, Object> map);

}
