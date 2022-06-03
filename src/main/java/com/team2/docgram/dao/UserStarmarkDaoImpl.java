package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.UserStarmarkDto;
/**  UserStarmarkDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class UserStarmarkDaoImpl implements UserStarmarkDao {
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "starmark.";

	 /**
	 * 설명
	 * 
	 * @param userStarmarkDto 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createStarmark(UserStarmarkDto userStarmarkDto) {
		sqlSession.insert(mapper+"createStarmark", userStarmarkDto);
	}

	 /**
	 * 설명
	 * 
	 * @param userStarmarkDto 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void deleteStarmark(UserStarmarkDto userStarmarkDto) {
		sqlSession.delete(mapper+"deleteStarmark", userStarmarkDto);
	}

}
