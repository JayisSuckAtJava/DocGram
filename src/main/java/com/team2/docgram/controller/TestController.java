package com.team2.docgram.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.service.FileService;

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
	
	@GetMapping("test/fileSave")
	public void createFile(String savedFileName,MultipartFile file) {
		String root = "/usr/local/tomcat8.5/webapps/ROOT/resources/static/pdf/";
		File path = new File(root+savedFileName);
		
		try {
			file.transferTo(path);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			System.out.println(" 파일 저장에 실패 하였습니다. ");
		}
	}
}
