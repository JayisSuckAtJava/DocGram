package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.BoardDto;

@Repository
public class SearchDaoImpl implements SearchDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

	@Override
	public List<BoardDto> searchDetail(Map<String, Object> map) {
		return sqlSession.selectList(mapper+"", map);
	}

}
