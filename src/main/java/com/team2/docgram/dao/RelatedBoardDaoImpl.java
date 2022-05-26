package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class RelatedBoardDaoImpl implements RelatedBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	@Override
	public String readList(Integer relatedBoard_pk) {
		return sqlSession.selectOne(mapper+"readRelatedList", relatedBoard_pk);
	}
	
	
}
