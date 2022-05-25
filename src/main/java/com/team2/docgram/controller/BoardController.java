package com.team2.docgram.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.FileService;

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

	@Autowired
	private FileService fileService;

	
	
	
	
	/**
	 *  게시글에 첨부된 파일 다운로드
	 *  
	 * @param filePk 첨부된 파일의 PK
	 * @return ResponseEntity 객체를 리턴하여 파일 다운로드 하게함
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@GetMapping("/download/{path}")
	public ResponseEntity<Resource> fileDownload(@PathVariable("path")Integer filePk){
		return fileService.readOne(filePk);
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
		
		boardList = boardService.readBoardList(user);
		
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
	 * @param hashtagList 작성시 입력된 hashtag 의 값들을 담은 List
	 * @param file 업로드된 문서 file 의 값
	 * @return 작성 완료시 board 로 이동
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-17
	 */
	@PostMapping("/board/create")
	public String boardCreate(BoardDto board,HttpSession session,String hashtagList,MultipartFile file) {
		UserDto user = (UserDto) session.getAttribute("user");
		board.setUser(user.getUser_pk());
		String fileName = file.getOriginalFilename();
		
		
		
		if(fileName == "") {
			
			System.out.println(file.isEmpty());
			
		}else {
			
			String savedFileName = boardService.createOne(board,hashtagList,fileName);
			if(savedFileName == "") {
				System.out.println("DB에 파일 저장 문제 발생");
			}else {
				fileService.createOne(savedFileName, file);
			}
		}
		
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
		board.setBoard_pk(num);
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
	
	@GetMapping("/main")
	public String homePage(Model model,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		if(user.equals(null)) {
			return "main";
		}else {// 부서별 1(user의 현재 소속 Dept , 부서별 2 소속 Dept 의 teamUpperSt , 즐겨찾기 user의 starMark , 공지사항 - 어캐구분?
			// + 유저 정보 소속정보 + 상위 기관 링크
			
			Integer teamPk = user.getTeam(); // 이거 userDto 에 upper 정보 다 실어서 할까?
			
			List<BoardDto> boardList = boardService.readBoardList(user);
			List<BoardDto> deptList = boardService.readDeptBoardList(user);
			List<BoardDto> deptUpperStList = boardService.readUpperStBoardList(user);
			List<BoardDto> starMarkList = boardService.readStarMarkList(user);
			List<BoardDto> noticeList = boardService.readNoticeList();
			
			model.addAttribute("deptUpperStList", deptList);
			model.addAttribute("deptList", deptUpperStList);
			model.addAttribute("starMarkList", starMarkList);
			model.addAttribute("noticeList", noticeList);
			
			return "main";
		}
	}
	
	
	
	
	
}
