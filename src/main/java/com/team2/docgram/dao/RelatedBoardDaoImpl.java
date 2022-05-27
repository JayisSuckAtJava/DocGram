package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.RelatedBoardDto;

@Repository
public class RelatedBoardDaoImpl implements RelatedBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	@Override
	public String readList(Integer relatedBoard_pk) {
		return sqlSession.selectOne(mapper+"readRelatedList", relatedBoard_pk);
	}

	@Override
	public RelatedBoardDto createOne(RelatedBoardDto relatedBoard) {
		sqlSession.insert(mapper+"createRelatedOne", relatedBoard);
		return relatedBoard;
	}

	@Override
	public RelatedBoardDto readBoardList(Integer targetBoard) {
		return sqlSession.selectOne(mapper+"readRelatedBoardList", targetBoard);
	}

	@Override
	public void updateRelated(RelatedBoardDto relatedBoard) {
		sqlSession.update(mapper+"", relatedBoard);
	}
	

	
	
	
	
}
