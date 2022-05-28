package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String boardList(Model model) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@GetMapping("/board/{id}")
	public String board(@PathVariable("pk")Long id,Model model) {
		BoardDto board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board";
	}
}
