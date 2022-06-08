package com.team2.docgram.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.StarmarkService;

/**  StarmarkController.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class StarmarkController {

	@Autowired
	private StarmarkService starmarkService;
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 설명
	 * 
	 * @param userId
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("rest/star")
	@ResponseBody
	public List<BoardDto> mypageStarmark(Long userId) {
		List<BoardDto> starList = boardService.readStarmarkList(userId);
		return starList;
	}
	
	/**
	 * 즐겨찾기 추가 로직
	 * 
	 * @param boardId 즐겨찾기에 추가할 게시판 id
	 * @param session user의 id를 포함한 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("starmark/create")
	public void createStarmark(@RequestBody Map<String, Object> map, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		starmarkService.createStarmark(userId,boardId);
	}
	
	/**
	 * 즐겨찾기 삭제 로직
	 * 
	 * @param boardId 삭제할 대상 board의 id
	 * @param session 사용자의 정보를 조회할 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("starmark/delete")
	@ResponseBody
	public void deleteStarmark(@RequestBody Map<String, Object> map, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long boardId = Long.parseLong((String) map.get("boardId")); 
		System.out.println(boardId);
		starmarkService.deleteStarmark(userId,boardId);
	}
	
	/**
	 * 부서 알림 추가 로직
	 * 
	 * @param boardId 추가할 board 의 id
	 * @param session 사용자가 속한 부서 정보를 가진 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("deptmark/create")
	public void createDeptmark(@RequestBody Map<String, Object> map, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.createDeptmark(deptId,boardId);			
		}
	}
	
	/**
	 * 부서 알림 삭제 로직
	 * 
	 * @param boardId 삭제할 board 의 id
	 * @param session 사용자가 속한 부서 정보를 가진 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("deptmark/delete")
	public void deleteDeptmark(@RequestBody Map<String, Object> map, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.deleteDeptmark(deptId,boardId);			
		}
	}
}
