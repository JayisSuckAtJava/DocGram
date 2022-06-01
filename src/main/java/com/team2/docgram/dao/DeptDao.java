package com.team2.docgram.dao;

import java.util.List;

import com.team2.docgram.dto.DeptDto;

/**  DeptDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface DeptDao {

	DeptDto readDeptList(Long deptId);

}
