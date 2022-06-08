package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardDto;

/**  BoardDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	 /**
	 * 
	 * 
	 * @param board
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public List<BoardDto> readBoardList(BoardDto board) {
		return sqlSession.selectList(mapper+"readBoardList",board);
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public BoardDto readBoard(Map<String, Object> searchMap) {
		return sqlSession.selectOne(mapper+"readBoard",searchMap);
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public BoardDto readRelationBoard(Long id) {
		return sqlSession.selectOne(mapper+"readRelationBoard", id);
	}

	 /**
	 * 설명
	 * 
	 * @param board
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public BoardDto createBoard(BoardDto board) {
		sqlSession.insert(mapper+"createBoard", board);
		return board; 
	}

	 /**
	 * 설명
	 * 
	 * @param board 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public void updateBoardFile(BoardDto board) {
		sqlSession.update(mapper+"updateBoardFile", board);
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public BoardDto readBoardOne(Long id) {
		return sqlSession.selectOne(mapper+"readBoardOne", id);
	}

	 /**
	 * 즐겨찾기 게시글 조회
	 * 
	 * @param userId user정보로 starMark 에 접근
	 * @return 해당하는 board 의 list
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readStarmarkList(Long userId) {
		return sqlSession.selectList(mapper+"readStarmarkList", userId);
	}

	 /**
	 * 부서 알림 지정된 게시글 조회
	 * 
	 * @param deptId 조회를 위한 부서 id
	 * @return 부서 id 즐겨찾기에 해당된 boardList
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readDeptmarkList(Long deptId) {
		return sqlSession.selectList(mapper+"readDeptmarkList", deptId);
	}

	 /**
	 * 공지사항 조회
	 * 
	 * @return 공지사항 리스트 반환 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readNoticeList() {
		return sqlSession.selectList(mapper+"readNoticeList");
	}

	 /**
	 * 게시글 수정
	 * 
	 * @param board 수정된 데이터를 담은 boardDto 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public void updateBoard(BoardDto board) {
		sqlSession.update(mapper+"updateBoard", board);
	}

	 /**
	 * 게시글 id로 작성자 id를 반환
	 * 
	 * @param id 해당 게시글의 id
	 * @return user_id
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public Long readBoardUserId(Long id) {
		return sqlSession.selectOne(mapper+"readBoardUserId", id);
	}

	 /**
	 * 게시글 삭제
	 * 
	 * @param id 해당 게시글의 id 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public Integer deleteBoard(Long id) {
		return sqlSession.delete(mapper+"deleteBoard", id);
	}

	/**
	 * 상세 검색 기준으로 해당하는 board의 List 반환
	 * 
	 * @param map 검색 조건을 포함한 map
	 * @return 검색 조건에 해당되는 Board의 List
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 2.
	 */
	@Override
	public List<BoardDto> searchDetail(Map<String, Object> map) {
		return sqlSession.selectList("search.searchDetail", map);
	}

	/**
	 * 상세 검색 기준에 해당되는 전체 List 의 크기
	 * 
	 * @param map 검색 조건을 담은 map
	 * @return List 의 크기
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 2.
	 */
	@Override
	public Long searchDetailSize(Map<String, Object> map) {
		return sqlSession.selectOne("search.searchDetailSize", map);
	}

	/**
	 * 설명
	 * 
	 * @param userId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 3.
	 */
	@Override
	public List<BoardDto> readMyBoardList(Long userId) {
		return sqlSession.selectList(mapper+"readMyBoardList", userId);
	}

	/**
	 * 설명
	 * 
	 * @param map
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<BoardDto> searchRelation(Map<String, Object> map) {
		return sqlSession.selectList(mapper+"searchRelation", map);
	}

	/**
	 * 설명
	 * 
	 * @param board
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<BoardDto> readDeptBoardList(BoardDto board) {
		return sqlSession.selectList(mapper+"readDeptBoardList", board);
	}

	/**
	 * 설명
	 * 
	 * @param map
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<BoardDto> readBoardList(Map<String, Object> map) {
		return sqlSession.selectList("search.readBoardList", map);
	}

	
}
