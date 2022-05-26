package com.team2.docgram.dao;

import com.team2.docgram.dto.UserDto;

public interface UserDao {
	UserDto readOne(Integer userNum);
}
