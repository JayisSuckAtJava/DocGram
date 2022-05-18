package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;

/** BoardController.java
 *  게시판 접속 처리 컨트롤러
 *  
 * @author JAY - 이재범
 * @since 2022-05-17
 */
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	/** 
	 *  최초 게시판 접근 - 전체 리스트 조회 전달
	 *  
	 *  @param session 에 저장된 user 의 정보를 조회하기 위한 session
	 *  @param model view에 값을 전달 - 표현 하기 위한 model
	 *  @return board.jsp 를 view로 전달
	 *  
	 * @author JAY - 이재범
	 * @since 2022-05-17
	 */
	@GetMapping("/board")
	public String boardList(Model model,HttpSession session) {
		
		UserDto user = (UserDto) session.getAttribute("user");
		
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		
		boardList = boardService.readAllList(user);
		
		model.addAttribute("list", boardList);
		return "board";
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return boardService.test();
	}
	
	
}
