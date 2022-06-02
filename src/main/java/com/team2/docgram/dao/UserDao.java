package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.UserDto;

public interface UserDao {

	UserDto readUser(UserDto user);

	void createUser(UserDto user);

	Integer updateUser(UserDto user);

	void updateHashtag(Long hashtagId);

	List<UserDto> readUserList();

	List<UserDto> readUserList(String name);

}
