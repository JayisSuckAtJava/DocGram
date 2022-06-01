package com.team2.docgram.dao;

import com.team2.docgram.dto.UserStarmarkDto;

/**  UserStarmarkDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface UserStarmarkDao {

	void createStarmark(UserStarmarkDto userStarmarkDto);

	void deleteStarmark(UserStarmarkDto userStarmarkDto);

}
