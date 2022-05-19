package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

public interface BoardService {

	List<BoardDto> readBoardList(UserDto user);

	BoardDto readOne(Integer num);

	void createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

}
