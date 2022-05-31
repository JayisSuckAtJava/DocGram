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
	public List<BoardDto> readBoardList(BoardDto board) {
		return sqlSession.selectList(mapper+"readBoardList",board);
	}

	@Override
	public BoardDto readBoard(Long id) {
		return sqlSession.selectOne(mapper+"readBoard",id);
	}

	@Override
	public BoardDto readRelationBoard(Long id) {
		return sqlSession.selectOne(mapper+"readRelationBoard", id);
	}

	@Override
	public BoardDto createBoard(BoardDto board) {
		sqlSession.insert(mapper+"createBoard", board);
		return board; 
	}

	@Override
	public void updateBoardFile(BoardDto board) {
		sqlSession.update(mapper+"updateBoardFile", board);
	}

	@Override
	public BoardDto readBoardOne(Long id) {
		return sqlSession.selectOne(mapper+"readBoardOne", id);
	}

	@Override
	public List<BoardDto> readStarmarkList(Long userId) {
		return sqlSession.selectList(mapper+"readStarmarkList", userId);
	}

	@Override
	public List<BoardDto> readDeptmarkList(Long deptId) {
		return sqlSession.selectList(mapper+"readDeptmarkList", deptId);
	}

	@Override
	public List<BoardDto> readNoticeList() {
		return sqlSession.selectList(mapper+"readNoticeList");
	}

	@Override
	public void createNotice(BoardDto board) {
		sqlSession.selectOne(mapper+"createNotice", board);
	}

	
}
