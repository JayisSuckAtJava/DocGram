package com.team2.docgram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardDto> readBoardList() {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardDao.readBoardList();
		return null;
	}

	@Override
	public BoardDto readBoard(Long id) {
		return boardDao.readBoard(id);
	}

	
}
