package com.team2.docgram.dao;

import com.team2.docgram.dto.DeptStarmarkDto;

/**  DeptStarmarkDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface DeptStarmarkDao {

	void createDeptmark(DeptStarmarkDto deptStarmarkDto);

	void deleteDeptmark(DeptStarmarkDto deptStarmarkDto);


}
