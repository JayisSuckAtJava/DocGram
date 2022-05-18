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

	@Override
	public String test() {
		return boardDao.test();
	}

}
