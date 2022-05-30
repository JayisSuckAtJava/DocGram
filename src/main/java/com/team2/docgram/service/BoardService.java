package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.ui.Model;

import com.team2.docgram.dto.BoardDto;

public interface BoardService {

	List<BoardDto> readBoardList();

	Map<String, Object> readBoard(Long id);

	String createBoard(BoardDto board, String hashtagList, String relatedBoardList,String fileName);
	
	Map<String, Object> readBoardOne(Long id);

}
