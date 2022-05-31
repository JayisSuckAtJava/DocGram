package com.team2.docgram.dao;

import com.team2.docgram.dto.UserStarmarkDto;

public interface UserStarmarkDao {

	void createStarmark(UserStarmarkDto userStarmarkDto);

	void deleteStarmark(UserStarmarkDto userStarmarkDto);

}
