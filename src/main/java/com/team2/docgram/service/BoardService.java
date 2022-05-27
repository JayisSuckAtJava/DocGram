package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

public interface BoardService {

	List<BoardDto> readBoardList(UserDto user);

	BoardDto readOne(Integer num);

	void createOne(BoardDto board, String hashtagList,String relatedboardList);

	void updateOne(BoardDto board);

	void deleteOne(Integer num);

	List<BoardDto> readUpperStBoardList(UserDto user);

	List<BoardDto> readStarMarkList(UserDto user);

	List<BoardDto> readNoticeList();

	List<BoardDto> readDeptBoardList(UserDto user);

	List<BoardDto> searchList(String key, String text);

	String createOneAndFile(BoardDto board, String hashtagList, String fileName,String relatedboardList);

	void updateInclude(Integer boardPk,String relatedboardList);

}
