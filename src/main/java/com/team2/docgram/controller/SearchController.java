package com.team2.docgram.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** SearchController.java
 *  검색 - 상세 검색 처리 컨트롤러
 * 
 * @author JAY - 이재범
 * @since 2022-05-24
 */
@Controller
public class SearchController {
	
	

	/** 검색 페이지 접속 매핑
	 * 
	 * @return 검색 페이지에 해당하는 jsp
	 * @since 2022-05-24
	 */
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	/** 선택된 정보들을 map으로 받아서 검색 조건 구성
	 * 
	 * @param map 검색 조건들을 모두 String 으로 받음
	 * @return 
	 * @since 2022-05-24
	 */
	@PostMapping("/search")
	public String searchDetail(@RequestParam Map<String,String> map) {
		
		return "search";
		
	}
}
