
package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	@Override
	public FileDto readFile(Long fileId) {
		return sqlSession.selectOne(mapper+"readFile", fileId);
	}

	@Override
	public FileDto createFile(FileDto file) {
		sqlSession.insert(mapper+"createFile", file);
		return file;
	}

	@Override
	public void updateFile(FileDto file) {
		sqlSession.update(mapper+"updateFile", file);
	}
}
