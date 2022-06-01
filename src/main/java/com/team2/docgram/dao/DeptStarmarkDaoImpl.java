package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.DeptStarmarkDto;

/**  DeptStarmarkDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class DeptStarmarkDaoImpl implements DeptStarmarkDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "starmark.";

	 /**
	 * 설명
	 * 
	 * @param deptStarmarkDto 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createDeptmark(DeptStarmarkDto deptStarmarkDto) {
		sqlSession.insert(mapper+"createDeptmark", deptStarmarkDto);
	}

	 /**
	 * 설명
	 * 
	 * @param deptStarmarkDto 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void deleteDeptmark(DeptStarmarkDto deptStarmarkDto) {
		sqlSession.delete(mapper+"deleteDeptmark", deptStarmarkDto);
	}

}
