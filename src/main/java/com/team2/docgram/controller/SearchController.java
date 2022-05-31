package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("read")
	public String readPage(Model model) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList();
		model.addAttribute("boardList", boardList);
		return "read/detail";
	}
}
