package com.team2.docgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.DeptStarmarkDao;
import com.team2.docgram.dao.UserStarmarkDao;
import com.team2.docgram.dto.DeptStarmarkDto;
import com.team2.docgram.dto.UserStarmarkDto;

/**  StarmarkServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class StarmarkServiceImpl implements StarmarkService {
	
	@Autowired
	private DeptStarmarkDao deptStarmarkDao;
	
	@Autowired
	private UserStarmarkDao userStarmarkDao;

	 /**
	 * 설명
	 * 
	 * @param userId
	 * @param boardId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createStarmark(Long userId, Long boardId) {
		UserStarmarkDto userStarmarkDto = new UserStarmarkDto();
		userStarmarkDto.setBoardId(boardId);
		userStarmarkDto.setUserId(userId);		
		userStarmarkDao.createStarmark(userStarmarkDto);
	}

	 /**
	 * 설명
	 * 
	 * @param userId
	 * @param boardId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void deleteStarmark(Long userId, Long boardId) {
		UserStarmarkDto userStarmarkDto = new UserStarmarkDto();
		userStarmarkDto.setBoardId(boardId);
		userStarmarkDto.setUserId(userId);
		userStarmarkDao.deleteStarmark(userStarmarkDto);
	}

	 /**
	 * 설명
	 * 
	 * @param deptId
	 * @param boardId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void createDeptmark(Long deptId, Long boardId) {
		DeptStarmarkDto deptStarmarkDto = new DeptStarmarkDto();
		deptStarmarkDto.setBoardId(boardId);
		deptStarmarkDto.setDeptId(deptId);
		deptStarmarkDao.createDeptmark(deptStarmarkDto);
	}

	 /**
	 * 설명
	 * 
	 * @param deptId
	 * @param boardId 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public void deleteDeptmark(Long deptId, Long boardId) {
		DeptStarmarkDto deptStarmarkDto = new DeptStarmarkDto();
		deptStarmarkDto.setBoardId(boardId);
		deptStarmarkDto.setDeptId(deptId);
		deptStarmarkDao.deleteDeptmark(deptStarmarkDto);
	}

}
