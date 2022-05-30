package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.docgram.dto.BoardDto;

@Controller
public class TestController {

	@Autowired
	SqlSessionTemplate sql;
	
	@GetMapping("test")
	@ResponseBody
	public String test() {
		List<BoardDto> list = new ArrayList<>();
		list = sql.selectList("board.readBoardList");
		
		for(BoardDto i : list) {
			System.out.println(i);
		}
		
		String result = "hi";
		return result;
	}
	
	@GetMapping("test/1")
	public void tes2() {
		BoardDto board;
		Long id = 1L;
		board = sql.selectOne("board.readBoard",id);
		System.out.println(board);
	}
}
