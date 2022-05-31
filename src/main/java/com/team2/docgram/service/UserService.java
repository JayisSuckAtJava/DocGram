package com.team2.docgram.service;

import java.util.List;

import com.team2.docgram.dto.UserDto;

public interface UserService {

	UserDto readUser(UserDto user);

	void createUser(UserDto user);

	UserDto updateUser(UserDto user);

	void updateHashtag(Long hashtagId);

	List<UserDto> readUserList();

	List<UserDto> readUserList(String name);

}
