package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.BoardDto;

public interface BoardDao {

	List<BoardDto> readBoardList();

	BoardDto readOne(Integer num);

	Integer createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

	List<BoardDto> readNoticeList();

	List<BoardDto> searchByTitle(String text);

	List<BoardDto> searchByContent(String text);

	List<BoardDto> searchByName(String text);

	List<BoardDto> searchByDept(Integer text);

	void updateFile(Integer fileResult);

	BoardDto readRelatedBoard(Integer relatedPk);

}
