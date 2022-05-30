package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	@Override
	public List<BoardDto> readBoardList() {
		return sqlSession.selectList(mapper+"readBoardList");
	}

	@Override
	public BoardDto readBoard(Long id) {
		return sqlSession.selectOne(mapper+"readBoard",id);
	}
	
	
}
