package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.SearchDao;
import com.team2.docgram.dto.BoardDto;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public List<BoardDto> searchDetail(Map<String, Object> map) {
		return searchDao.searchDetail(map);
	}

	
}
