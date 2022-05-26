package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardDto;


/** BoardDaoImpl.java
 *  게시글 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-18
 */
@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";
	
	

	/**
	 * user 의 소속 정보에 따른 Board를 조회 List로 전달
	 * 
	 * @param num user 조회의 조건인 Department 테이블의 PK
	 * @return 조건에 맞게 검색되어 사용자에게 전달될 데이터 
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public List<BoardDto> readBoardList() {
		return sqlSession.selectList(mapper+"boardList");
	}

	/**
	 * Board 의 pk를 통해 1개의 게시글 상세 내용 조회
	 * 
	 * @param num 1개의 게시글을 조회 하기 위한 PK
	 * @return 1개의 board 객체를 반환
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public BoardDto readOne(Integer num) {
		return sqlSession.selectOne(mapper+"readOne", num);
	}

	/**
	 * Board 테이블에 값을 Insert
	 * 
	 * @param board 저장할 데이터를 가진 Board 객체 
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public Integer createOne(BoardDto board) {
		return sqlSession.insert(null, board);
	}

	
	
	/**
	 *  수정된 Board 값을 테이블에 Update
	 *  
	 *  @param board 수정된 데이터를 가진 Board 객체
	 *
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void updateOne(BoardDto board) {
		sqlSession.update(null, board);
	}

	
	/**
	 *  Board 의 PK 를 통해 1개의 Row 를 선택 삭제
	 *  
	 *  
	 *  @param 구분을 위한 PK 값
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void deleteOne(Integer num) {
		sqlSession.delete(null,num);
	}

	/**
	 * Board 테이블의 공지사항만 조회
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public List<BoardDto> readNoticeList() {
		return sqlSession.selectList(mapper+"");
	}

	@Override
	public List<BoardDto> searchByTitle(String title) {
		return sqlSession.selectList(mapper+"", title);
		// sel from where b.title = ${title}
	}

	@Override
	public List<BoardDto> searchByContent(String content) {
		return sqlSession.selectList(mapper+"", content);
	}

	@Override
	public List<BoardDto> searchByName(String name) {
		return sqlSession.selectList(mapper+"", name);
	}

	@Override
	public List<BoardDto> searchByDept(Integer dept) {
		return sqlSession.selectList(mapper+"", dept);
	}

	@Override
	public void updateFile(Integer fileResult) {
		sqlSession.update(mapper+"", fileResult);
	}
	
	
	


}
