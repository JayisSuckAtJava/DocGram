package com.team2.docgram.service;

import com.team2.docgram.dto.UserDto;

public interface UserService {

	UserDto readOne(UserDto user);

	Integer createOne(UserDto user);

	UserDto readUserOne(UserDto user);

	void updateOne(UserDto user);

	void deleteOne(UserDto user);

	void createStarMark(Integer boardPk);

	void deleteStarMark(Integer boardPk);

	void readStarMark(Integer boardPk);

	void createMytag(String hashtag);

	void deleteMytag(String hashtag);

	void readMytag(String hashtag);

}
