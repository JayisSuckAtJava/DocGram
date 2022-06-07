package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DeptDto;
import com.team2.docgram.dto.UserDto;
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
	@GetMapping("asdsaddas")
	public String readPage(Model model,@RequestParam(defaultValue = "1", required = false, name= "page")Long page,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList(page,userId);
		model.addAttribute("boardList", boardList);
		return "read/search";
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
	@GetMapping("search/list")
	public String read(Model model, @RequestParam Map<String, Object>map, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		map.put("userId", user.getId());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = searchService.searchDetail(map); 
		model.addAllAttributes(resultMap);
		return "read/search";
	}
	
	/**
	 * 소속 부서에 관한 검색
	 * 
	 * @param name 검색할 부서의 이름
	 * @return 해당 name 이 포함되어 있는 부서들의 리스트
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("rest/dept")
	@ResponseBody
	public List<DeptDto> searchDept(String name) {
		List<DeptDto> deptList = new ArrayList<>();
		deptList = searchService.searchDept(name);
		
		return deptList;
	}
	
	/**
	 * 연관 게시글 검색
	 * 
	 * @param text 검색어가 입력되는 text
	 * @param sel 검색어의 종류를 선택하는 sel
	 * @return 해당 검색 결과로 반환되는 게시글 목록
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("rest/relation")
	@ResponseBody
	public List<BoardDto> searchRelation(String text,String sel) {
		List<BoardDto> boardList = new ArrayList<>();
		boardList = searchService.searchRelation(text,sel);
		return boardList;
	}
}
