package com.team2.docgram.dao;

import java.util.List;

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
	 * 설명
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
	public BoardDto readBoard(Long id) {
		return sqlSession.selectOne(mapper+"readBoard",id);
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
	 * 설명
	 * 
	 * @param userId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readStarmarkList(Long userId) {
		return sqlSession.selectList(mapper+"readStarmarkList", userId);
	}

	 /**
	 * 설명
	 * 
	 * @param deptId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readDeptmarkList(Long deptId) {
		return sqlSession.selectList(mapper+"readDeptmarkList", deptId);
	}

	 /**
	 * 설명
	 * 
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readNoticeList() {
		return sqlSession.selectList(mapper+"readNoticeList");
	}

	 /**
	 * 설명
	 * 
	 * @param board 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createNotice(BoardDto board) {
		sqlSession.selectOne(mapper+"createNotice", board);
	}

	
}
