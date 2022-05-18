package com.team2.docgram;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DBtest {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Test
	public void test() {
		sqlSession.insert("team2.test");
	}

}
