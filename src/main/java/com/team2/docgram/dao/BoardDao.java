package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;

public interface BoardDao {

	List<BoardDto> readBoardList();

	BoardDto readOne(Integer pk);

	BoardDto createOne(BoardDto board);

	void updateOne(BoardDto board);

	void deleteOne(Integer pk);

	List<BoardDto> readNoticeList();

	List<BoardDto> searchByTitle(String text);

	List<BoardDto> searchByContent(String text);

	List<BoardDto> searchByName(String text);

	List<BoardDto> searchByDept(String text);

	void updateFile(Integer fileResult);

	BoardDto readRelatedBoard(Integer relatedPk);

	void updateRelated(Map<String, Object> map);

}
