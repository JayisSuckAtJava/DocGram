package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.BoardDto;

public interface BoardDao {

	List<BoardDto> readAllList(Integer num);

	String test();

	BoardDto readOne(Integer num);

	void createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

}
