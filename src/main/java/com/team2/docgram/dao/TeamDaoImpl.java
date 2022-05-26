package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.TeamDto;

/** TeamDaoImpl.java
 *   소속 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";
	
	
	
	
	/**
	 *  Team의 PK 값을 이용하여 Team 객체 반환
	 *
	 * @param num 조회를 위한 Team 의 PK
	 * @return TeamDto 해당 PK에 선택된 Team 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-19
	 */
	@Override
	public TeamDto readOne(Integer num) {
		return sqlSession.selectOne(mapper+"readTeam", num);
	}

}
