package com.team2.docgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDto readOne(UserDto user) {
		return null;
	}

	@Override
	public Integer createOne(UserDto user) {
		return null;
	}

	@Override
	public UserDto readUserOne(UserDto user) {
		return null;
	}

	@Override
	public void updateOne(UserDto user) {
		
	}

	@Override
	public void deleteOne(UserDto user) {
		
	}

	@Override
	public void createStarMark(Integer boardPk) {
		
	}

	@Override
	public void deleteStarMark(Integer boardPk) {
		
	}

	@Override
	public void readStarMark(Integer boardPk) {
		
	}

	@Override
	public void createMytag(String hashtag) {
		
	}

	@Override
	public void deleteMytag(String hashtag) {
		
	}

	@Override
	public void readMytag(String hashtag) {
		
	}

}
