package com.team2.docgram.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team2.docgram.dto.UserDto;

/**  UserDaoImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "user.";

	 /**
	 * 설명
	 * 
	 * @param user
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public UserDto readUser(UserDto user) {
		return sqlSession.selectOne(mapper+"readUser", user);
	}

	 /**
	 * 설명
	 * 
	 * @param user 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createUser(UserDto user) {
		sqlSession.insert(mapper+"createUser", user);
	}

	 /**
	 * 설명
	 * 
	 * @param user
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public Integer updateUser(UserDto user) {
		return sqlSession.update(mapper+"updateUser", user);
	}

	 /**
	 * 설명
	 * 
	 * @param hashtagId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void updateHashtag(Long hashtagId) {
		sqlSession.update(mapper+"updateUser", hashtagId);
	}

	 /**
	 * 설명
	 * 
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<UserDto> readUserList() {
		return sqlSession.selectList(mapper+"readUserList");
	}

	 /**
	 * 설명
	 * 
	 * @param name
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<UserDto> readUserList(String name) {
		return sqlSession.selectList(mapper+"readUserList", name);
	}
	
}
