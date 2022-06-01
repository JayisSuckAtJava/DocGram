package com.team2.docgram.service;

/**  StarmarkService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface StarmarkService {

	void createStarmark(Long userId, Long boardId);

	void deleteStarmark(Long userId, Long boardId);

	void createDeptmark(Long deptId, Long boardId);

	void deleteDeptmark(Long deptId, Long boardId);

}
