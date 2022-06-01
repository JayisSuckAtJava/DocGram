package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.SearchService;

/**  SearchController.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 설명
	 * 
	 * @param model
	 * @param page
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("read")
	public String readPage(Model model,@RequestParam(defaultValue = "1", required = false, name= "page")Long page) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList(page);
		model.addAttribute("boardList", boardList);
		return "read/detail";
	}
	
	/**
	 * 설명
	 * 
	 * @param map
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@PostMapping("read")
	public String read(Map<String, Object> map) {
		// 기본검색 4항 제목 내용 작성자 기관 (sel)
		// 항목 검색 작성자의 직책, file의 이름, file 의 num
		// 태그 검색 태그에 따른 중첩된 데이터 검색 and h.name = and h.name =
		// 검색 기간 date -3month date -6month
		// 그렇게 나온 리스트의 페이지 처리 + 전체 조회값 . size
		System.out.println(map);
		return "read/detail";
	}
}
