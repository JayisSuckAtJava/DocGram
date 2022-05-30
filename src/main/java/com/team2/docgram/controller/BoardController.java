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
	
	@GetMapping("/board")
	public String boardList(Model model) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList();
		model.addAttribute("boardList", boardList);
		return "test2";
	}
	
	@GetMapping("/board/{id}")
	public String board(@PathVariable("id")Long id,Model model) {
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoard(id);
		
		model.addAllAttributes(map);
		return "board/documentview";
	}
	
	@GetMapping("/board/create")
	public String boardCreatePage() {
		return "";
	}
	
	@PostMapping("/board/create")
	public String boardCreate(HttpSession session,BoardDto board,String hashtagList, MultipartFile mFile,String relatedBoardList) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		board.setUserId(2L);
		
		String fileName = mFile.getOriginalFilename();
			
		String savedFileName = boardService.createBoard(board,hashtagList,relatedBoardList,fileName);
		if(savedFileName == null) {
			return "redirect:/board";
		}else {
			fileService.createFile(savedFileName, mFile);
			return "redirect:/board";
		}
	}
	
	@GetMapping("download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id")Long id) {
		return fileService.readFile(id);
	}
	
	@GetMapping("/board/update/{id}")
	public String boardUpdatePage(@PathVariable("id")Long id,Model model) {
		BoardDto board = boardService.readBoardOne(id);
		model.addAttribute("board", board);
		return "update";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id")Long id,BoardDto board) {
		
	}
}
