package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardDto;

/** BoardDaoImpl.java
 *  게시글 CRUD에 관한 DB 와 연결하는 객체
 * 
 * @author JAY - 이재범
 * @since 2022-05-18
 */
@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * user 의 소속 정보에 따른 Board를 조회 List로 전달
	 * 
	 * @param num user 조회의 조건인 소속 정보
	 * @return 조건에 맞게 검색되어 사용자에게 전달될 데이터 
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public List<BoardDto> readAllList(Integer num) {
		
		
		return null;
	}

	@Override
	public String test() {
		String text;
		int a = sqlSession.insert("team2.test");
		if(a==0) {
			text = " yes ";
		}else {
			text = " not ";
		}
		
		return text;
	}
	
	

}
