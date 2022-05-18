package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.BoardDto;

public interface BoardDao {

	List<BoardDto> readAllList(Integer num);

	String test();

}
