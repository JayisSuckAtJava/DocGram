package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.UserDto;

/**  UserDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface UserDao {

	UserDto readUser(UserDto user);

	void createUser(UserDto user);

	Integer updateUser(UserDto user);

	void updateHashtag(UserDto user);

	List<UserDto> readUserList(Map<String, Object> map);

	void deleteUser(Long userId);

	UserDto readUserOne(UserDto user);

	Integer updateDept(Map<String, Object> map);

	Integer searchEmail(String email);

}
