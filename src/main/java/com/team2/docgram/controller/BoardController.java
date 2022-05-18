package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return boardService.test();
	}
	
	/** 
	 *  최초 게시판 접근 - 전체 리스트 조회
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
	
	
	/**
	 *  단일 게시글 조회 상세 페이지 조회
	 *  
	 * @param model 조회된 게시물의 값을 전달하기 위한 model
	 * @param num 해당 게시물을 조회하기 위한 Board 의 PK num
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-17
	 */
	@GetMapping("/board/{num}")
	public String board(Model model,@PathVariable("num")Integer num) {
		BoardDto board = boardService.readOne(num);
		model.addAttribute("board", board);
		return "board";
	}
	
	/**
	 *  게시글 작성 페이지로 이동
	 *  
	 * @return 해당 페이지 view
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-17
	 */
	@GetMapping("/board/create")
	public String boardCreatePage() {
		return "board";
	}
	
	/**
	 *  게시글 작성을 로직 Input 값 변환 , 작성자 확인 후 DB 저장 
	 *  
	 * @param board boardDto에 값 변환하여 저장
	 * @param session 작성자의 사용자 정보 session 에서 값 추출 
	 * @return 작성 완료시 board 로 이동
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-17
	 */
	@PostMapping("/board/create")
	public String boardCreate(BoardDto board,HttpSession session) {
		UserDto user;
		user = (UserDto) session.getAttribute("user");
		board.setUser(user);
		boardService.createOne(board);
		return "redirect:/board";
	}
	
	/**
	 *  게시글 수정 페이지로 이동
	 * 
	 * @param model 수정 페이지 내에 기존 게시글 정보 표출을 위한 데이터를 담을 model 객체
	 * @param num 해당 게시글을 구분하기 위한 Board 의 PK
	 * @return 
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@GetMapping("/board/update/{num}")
	public String boardUpdatePage(Model model,@PathVariable("num")Integer num) {
		BoardDto board = boardService.readOne(num);
		model.addAttribute(null, board);
		return "board";
	}
	
	/**
	 *  게시글 수정 - 수정된 데이터를 DB 에 변동하는 로직
	 * 
	 * @param board 변동된 Board를 담을 객체
	 * @param num 해당 Board 의 PK
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@PostMapping("/board/upadte/{num}")
	public String boardUpdate(BoardDto board,@PathVariable("num")Integer num) {
		board.setBoardNumber(num);
		boardService.updateOne(board);
		return "board";
	}
	
	/**
	 *  게시글 삭제 - DB 에 있는 1개의 Board 데이터 삭제
	 * 
	 * @param num 구분을 위한 해당 Board 의 PK
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@PostMapping("/board/delete/{num}")
	public String boardDelete(@PathVariable("num")Integer num) {
		boardService.deleteOne(num);
		return "board";
	}
	
	
	
	
	
}
