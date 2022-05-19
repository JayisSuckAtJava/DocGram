package com.team2.docgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team2.docgram.dao.TestDao;

@Controller
public class TestContorller {

	@Autowired
	private TestDao testDao;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return testDao.test();
	}
	
	@PostMapping("/file")
	public String fileTest() {
		return "s";
	}
	
	@GetMapping("/string")
	@ResponseBody
	public String[] stringTest() {
		// 스트링 배열을 받아서 1개씩 나눠는것
		String input = "태그,들이,움직,이는,게,신기해";
		String[] split = input.split(",");
		System.out.println(split);
		
		return split;
		
		
	}
	
	String root = "C:\\ProjectTeam2\\file";
	
	@PostMapping("/upload")
	public String uploadtest(MultipartHttpServletRequest mRequest) {
		
		MultipartFile mFile = mRequest.getFile("file");
		String oNanme = mFile.getOriginalFilename();
		
		return null;
	}
}
