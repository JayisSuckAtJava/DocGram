package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.FileDto;

/** FileDaoImpl.java
 *   파일 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class FileDaoImpl implements FileDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "namespace.";

	@Override
	public Integer createOne(String fileName) {
		return sqlSession.insert(mapper+"", fileName);
	}

	@Override
	public FileDto readOne(Integer filePk) {
		return sqlSession.selectOne(mapper+"", filePk);
	}
	
	

}
