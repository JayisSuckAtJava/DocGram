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
	
	private String mapper = "file.";

	/** 
	 * DB에 File 이름 저장
	 * 
	 * @param fileName 저장할 이름 ( 서비스에서 처리된 )
	 * @return 해당 file 객체의 pk
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public Integer createOne(String fileName) {
		return sqlSession.insert(mapper+"createOne", fileName);
	}

	/**
	 * DB 에 저장된 File 조회 객체 반환
	 * 
	 * @param filePk 조회할 객체의 pk
	 * @return pk에 맞는 해당 file 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public FileDto readOne(Integer filePk) {
		return sqlSession.selectOne(mapper+"readOne", filePk);
	}

	@Override
	public void updateFile_num(String file_num) {
		sqlSession.update(mapper+"updateFile_num", file_num);
	}
	
	
	
	

}
