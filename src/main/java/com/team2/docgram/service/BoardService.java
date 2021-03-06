package com.team2.docgram.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.ui.Model;

import com.team2.docgram.dto.BoardDto;

/**  BoardService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface BoardService {

	List<BoardDto> readBoardList(Long page,Long userId);

	Map<String, Object> readBoard(Long id, Long userId, Long deptId);

	String createBoard(BoardDto board, String hashtagList, String relatedBoardList,String fileName);
	
	Map<String, Object> readBoardOne(Long id);

	List<BoardDto> readStarmarkList(Long userId);

	List<BoardDto> readDeptmarkList(Long deptId);

	List<BoardDto> readNoticeList();

	void boardUpdate(BoardDto board, String hashtagList, String relatedBoardList);

	Long readBoardUserId(Long id);

	Integer deleteBoard(Long id);

	List<BoardDto> readMyBoardList(Long userId);

	List<BoardDto> readDeptBoardList(Long page, Long deptId, String sel, String text);

	Map<String, Object> readNoticeList(Long page);

	Long readBoardListSize(Long userId);

	Long readDeptBoardListSize(Long deptId, String sel, String text);

}
