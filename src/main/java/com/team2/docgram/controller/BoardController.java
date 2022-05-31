package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.FileService;

@Controller
public class BoardController {
	
	@Autowired
	private FileService fileService;

	@Autowired
	private BoardService boardService;
	
	@GetMapping("board")
	public String boardList(Model model) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList();
		model.addAttribute("boardList", boardList);
		return "detailsearch";
	}
	
	@GetMapping("board/{id}")
	public String board(@PathVariable("id")Long id,Model model) {
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoard(id);
		
		model.addAllAttributes(map);
		return "board/detail";
	}
	
	@GetMapping("board/create")
	public String boardCreatePage() {
		return "board/create";
	}
	
	@PostMapping("board/create")
	public String boardCreate(HttpSession session,BoardDto board,String hashtagList, MultipartFile mFile,String relatedBoardList) {
		//UserDto user = (UserDto) session.getAttribute("user");
		//Long userId = user.getId();
		board.setUserId(1L);
		
		String fileName = mFile.getOriginalFilename();
			
		String savedFileName = boardService.createBoard(board,hashtagList,relatedBoardList,fileName);
		if(savedFileName == null) {
			return "redirect:../";
		}else {
			fileService.createFile(savedFileName, mFile);
			return "redirect:create";
		}
	}
	
	@GetMapping("download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id")Long id) {
		return fileService.readFile(id);
	}
	
	@GetMapping("board/update/{id}")
	public String boardUpdatePage(@PathVariable("id")Long id,Model model) {
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoardOne(id);
		model.addAllAttributes(map);
		return "board/update";
	}
	
	@PostMapping("board/update/{id}")
	public String boardUpdate(@PathVariable("id")Long id,BoardDto board) {
		return "redirect:../"+id;
	}
	
	@GetMapping("board/popup")
	public String popup() {
		return "board/popup";
	}
	
	
	@GetMapping("main")
	public String mainPage(HttpSession session,Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		//Long userId = user.getId();
		//Long deptId = user.getDeptId();
		Long userId = 1L;
		Long deptId = 11110000L;
		
		List<BoardDto> starList = boardService.readStarmarkList(userId);
		List<BoardDto> deptList = boardService.readDeptmarkList(deptId);
		List<BoardDto> noticeList = boardService.readNoticeList();
		
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("starList", starList);
		model.addAttribute("noticeList", noticeList);
		
		return "board/main";
	}
	
	@GetMapping("notice")
	public String noticeList(Model model) {
		List<BoardDto> noticeList = boardService.readNoticeList();
		model.addAttribute("boardList", noticeList);
		return "board/notice";
	}
	
	@GetMapping("notice/{id}")
	public String notice(Model model,@PathVariable("id")Long boardId) {
		BoardDto notice = boardService.readNotice(boardId);
		model.addAttribute("board", notice);
		return "board/detail";
	}
	
	@PostMapping("notice/create")
	public String createNotice(BoardDto board,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		
		board.setUserId(userId);
		boardService.createNotice(board);
		return "redirect:/";
	}
	
	@GetMapping("un")
	public String updateNotice() {
		
	}
}
