package com.team2.docgram.service;

public interface StarmarkService {

	void createStarmark(Long userId, Long boardId);

	void deleteStarmark(Long userId, Long boardId);

	void createDeptmark(Long deptId, Long boardId);

	void deleteDeptmark(Long deptId, Long boardId);

}
