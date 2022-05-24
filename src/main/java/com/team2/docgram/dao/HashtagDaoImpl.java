package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** HashtagDaoImpl.java
 *   해시태그 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class HashtagDaoImpl implements HashtagDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

	@Override
	public Integer createList(String hashtagList) {
		return sqlSession.insert(mapper+"", hashtagList);
	}
	
	

}
