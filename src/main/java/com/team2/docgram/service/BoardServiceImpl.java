package com.team2.docgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

/** BoardServiceImpl.java
 *   Service 구현 객체 - Board의 로직처리 , DAO 객체와의 연결 다리
 * @author JAY - 이재범
 * @since 2022-05-18
 */
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public String test() {
		return boardDao.test();
	}

	
	/**
	 * 전체의 게시판 리스트를 조회
	 * 
	 * @param user 리스트 분류를 위한 user- 소속 정보에 따른 조회 검색 변경
	 * @return 정보에 따른 검색 정보 목록.
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public List<BoardDto> readAllList(UserDto user) {
		//Integer num = user.getDeptNum;
		return boardDao.readAllList(1);
	}

	/**
	 * 한개의 게시글 조회 + 작성자 정보 통합 전달
	 * 
	 * @param num 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public BoardDto readOne(Integer num) {
		return boardDao.readOne(num);
	}


	/**
	 * 게시글 작성 Board 객체를 받아 DB 에 저장
	 * 
	 * @param board 컨트롤러로 변환되어 전달받은 BoardDto
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void createOne(BoardDto board) {
		boardDao.createOne(board);
		
	}


	/**
	 * 게시글 수정 Board 객체를 받아 DB 에 변동
	 * 
	 * @param board 게시글의 정보를 담은 Board 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void updateOne(BoardDto board) {
		boardDao.updateOne(board);
	}


	/**
	 * 게시글 삭제를 위해 PK 를 받아 DB 에 지정 삭제
	 * 
	 * @param 구분을 위한 Board 의 PK 값
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void deleteOne(Integer num) {
		boardDao.deleteOne(num);
	}
	
	

	
}
