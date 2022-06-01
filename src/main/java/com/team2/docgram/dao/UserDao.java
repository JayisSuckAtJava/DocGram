package com.team2.docgram.dao;

import java.util.List;

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

	void updateHashtag(Long hashtagId);

	List<UserDto> readUserList();

	List<UserDto> readUserList(String name);

	void deleteUser(Long userId);

}
