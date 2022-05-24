package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.BoardDto;

public interface BoardDao {

	List<BoardDto> readBoardList(Integer num);

	BoardDto readOne(Integer num);

	Integer createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

	List<BoardDto> readNoticeList();

}
