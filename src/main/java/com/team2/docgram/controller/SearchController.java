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
	 * @param map
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("read")
	public String read(Model model, @RequestParam Map<String, Object>map) {
		System.out.println(map);
		if(map.get("page") == null) {
			map.put("page", 1);
		}
		// 기본검색 4항 제목 내용 작성자 기관 (sel)
		// 항목 검색 작성자의 직책, file의 이름, file 의 num
		// 태그 검색 태그에 따른 중첩된 데이터 검색 and h.name = and h.name =
		// 검색 기간 date -3month date -6month
		// 그렇게 나온 리스트의 페이지 처리 + 전체 조회값 . size
		
		// sel 값에 따라 text가 뭘 지정할지 결정됨, position 은 board.user.position_id 로 fileName은
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = searchService.searchDetail(map); 
		model.addAllAttributes(resultMap);
		//model.addAttribute("total", listSize);
		// service 에서 map 으로 리턴할까? 다 처리해서? 담배피고 결정하는걸로
		
		return "read/detail";
	}
}
