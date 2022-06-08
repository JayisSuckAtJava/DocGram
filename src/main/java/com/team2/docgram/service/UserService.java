package com.team2.docgram.service;

import java.util.List;

import com.team2.docgram.dto.UserDto;

/**  UserService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface UserService {

	UserDto readUser(UserDto user);

	void createUser(UserDto user);

	UserDto updateUser(UserDto user);

	void updateHashtag(UserDto user);

	List<UserDto> readUserList(Long page);

	List<UserDto> readUserList(Long page, String name);

	void deleteUser(Long userId);

	UserDto readUserOne(UserDto user);

	Integer updateDept(Long deptId, Long userId);

}
