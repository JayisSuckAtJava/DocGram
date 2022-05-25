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

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.service.SearchService;

/** SearchController.java
 *  검색 - 상세 검색 처리 컨트롤러
 * 
 * @author JAY - 이재범
 * @since 2022-05-24
 */
@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	/** 검색 페이지 접속 매핑 - 상세 검색
	 * 
	 * @return 검색 페이지에 해당하는 jsp
	 * @since 2022-05-24
	 */
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	/** 선택된 정보들을 map으로 받아서 검색 조건 구성 - 상세 검색
	 * 
	 * @param map 검색 조건들을 모두 String 으로 받음
	 * @return 
	 * @since 2022-05-24
	 */
	@PostMapping("/search")
	public String searchDetail(String key, String text, Date date, Date start, Date end, String file, String rank, String hashtagList,Model model) {
		// 위의 모든 조합을 만드세요
		// 일단 hashtagList 는 통으로 넘겨서 1개로 동적쿼리 수행
		
		Map<String, Object> map = new HashMap<>();
		map.put("date", date);
		map.put("key", key);
		map.put("text", text);
		map.put("file", file);
		map.put("rank", rank);
		map.put("hashtagList", hashtagList);
		
		List<BoardDto> boardList = new ArrayList<>();
		boardList = searchService.searchDetail(map);
		model.addAttribute("boardList", boardList);
		return "search";
		
	}
	
}
