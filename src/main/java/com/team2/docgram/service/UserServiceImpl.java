package com.team2.docgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto readUser(UserDto user) {
		return userDao.readUser(user);
	}

	@Override
	public void createUser(UserDto user) {
		userDao.createUser(user);
	}

	@Override
	public UserDto updateUser(UserDto user) {
		Integer result = userDao.updateUser(user);
		if(result == 1) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public void updateHashtag(Long hashtagId) {
		userDao.updateHashtag(hashtagId);
	}

	@Override
	public List<UserDto> readUserList() {
		return userDao.readUserList();
	}

	@Override
	public List<UserDto> readUserList(String name) {
		return userDao.readUserList(name);
	}

}
