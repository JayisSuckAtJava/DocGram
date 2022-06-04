package com.team2.docgram.dao;

import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;

/**  BoardDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface BoardDao {

	List<BoardDto> readBoardList(BoardDto board);

	BoardDto readBoard(Long id);

	BoardDto readRelationBoard(Long i);

	BoardDto createBoard(BoardDto board);

	void updateBoardFile(BoardDto board);

	BoardDto readBoardOne(Long id);

	List<BoardDto> readStarmarkList(Long userId);

	List<BoardDto> readDeptmarkList(Long deptId);

	List<BoardDto> readNoticeList();

	void updateBoard(BoardDto board);

	Long readBoardUserId(Long id);

	void deleteBoard(Long id);

	List<BoardDto> searchDetail(Map<String, Object> map);

	Long searchDetailSize(Map<String, Object> map);

	List<BoardDto> readMyBoardList(Long userId);

}
