package com.team2.docgram.service;

import java.util.List;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

public interface BoardService {

	List<BoardDto> readAllList(UserDto user);

	String test();

	BoardDto readOne(Integer num);

	void createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

}
