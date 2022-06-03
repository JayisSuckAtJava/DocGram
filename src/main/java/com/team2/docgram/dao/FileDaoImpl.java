
package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.FileDto;

/**  FileDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "board.";

	/**
	 * 설명
	 * 
	 * @param fileId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public FileDto readFile(Long fileId) {
		return sqlSession.selectOne(mapper+"readFile", fileId);
	}

	/**
	 * 설명
	 * 
	 * @param file
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public FileDto createFile(FileDto file) {
		sqlSession.insert(mapper+"createFile", file);
		return file;
	}

	/**
	 * 설명
	 * 
	 * @param file 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public void updateFile(FileDto file) {
		sqlSession.update(mapper+"updateFile", file);
	}
}
