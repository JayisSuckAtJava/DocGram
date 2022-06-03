package com.team2.docgram.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
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
 *   상세 검색 기능 구현 컨트롤러
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
	 * 검색 전 전체 리스트를 가져오는 기본 리스트 페이지
	 * 
	 * @param model 값을 심기 위한 model
	 * @param page 페이징 처리를 위한 함수
	 * @return 전체 리스트 + 검색 페이지 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("readasdsad")
	public String readPage(Model model,@RequestParam(defaultValue = "1", required = false, name= "page")Long page) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList(page);
		model.addAttribute("boardList", boardList);
		return "read/detail";
	}
	
	/**
	 * 검색된 조건에 해당하는 값을 보여주는 로직
	 * 
	 * @param map 상세 검색에 필요한 9개 요소 모두 받는 map
	 * @param model 값을 표현하기 위한 model
	 * @return 검색 결과값 + 전체 리스트 수 와 함께 동일 페이지 리턴
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("read")
	public String read(Model model, @RequestParam Map<String, Object>map) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = searchService.searchDetail(map); 
		model.addAllAttributes(resultMap);
		return "read/detail";
	}
}
