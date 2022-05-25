package com.team2.docgram.controller;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team2.docgram.dao.TestDao;
import com.team2.docgram.dto.DepartmentDto;

@Controller
public class TestContorller {
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	

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
	
	@GetMapping("/dbTest")
	@ResponseBody
	public String dbTest() {
		
		String num = "10";
		String result = sqlSession.selectOne("team2.ifTest", num);
		
		return result;
	}
	
	@GetMapping("/dbTest2")
	@ResponseBody
	public Object dbTest2() {
		
		String ad = "중구,송파구,강남구";
		String[] arr = ad.split(",");
		System.out.println(arr);
		
		List<DepartmentDto> result = sqlSession.selectList("team2.foreachTest", arr);
		
		for(DepartmentDto i : result) {
			System.out.println(i.getDescription());
		}
		
		return result;
	}
	
	@GetMapping("/dbTest3")
	@ResponseBody
	public Object dbTest3() {
		
		String ad = "윤구,재범,예빈";
		String[] arr = ad.split(",");
		System.out.println(arr);
		
		sqlSession.selectList("team2.hashinsert", arr);
		
	
		
		return "hi";
	}
	
}
