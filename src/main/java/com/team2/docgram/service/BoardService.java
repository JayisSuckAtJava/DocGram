package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

public interface BoardService {

	List<BoardDto> readBoardList(UserDto user);

	BoardDto readOne(Integer num);

	String createOne(BoardDto board, String hashtagList, String fileName);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

	List<BoardDto> readUpperStBoardList(UserDto user);

	List<BoardDto> readStarMarkList(UserDto user);

	List<BoardDto> readNoticeList();

}
