package com.team2.docgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.UserDto;

/**  UserServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	 /**
	 * 설명
	 * 
	 * @param user
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public UserDto readUser(UserDto user) {
		return userDao.readUser(user);
	}

	 /**
	 * 설명
	 * 
	 * @param user 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public void createUser(UserDto user) {
		userDao.createUser(user);
	}

	 /**
	 * 설명
	 * 
	 * @param user
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public UserDto updateUser(UserDto user) {
		Integer result = userDao.updateUser(user);
		if(result == 1) {
			return user;
		}else {
			return null;
		}
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
	public void updateHashtag(UserDto user) {
		userDao.updateHashtag(user);
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
		return userDao.readUserList();
	}

	  /**
	 * 설명
	 * 
	 * @param userId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
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
		return userDao.readUserList(name);
	}

	@Override
	public UserDto readUserOne(UserDto user) {
		return userDao.readUserOne(user);
	}

}
