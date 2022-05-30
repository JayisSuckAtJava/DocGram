package com.team2.docgram.controller.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team2.docgram.dao.TestDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DepartmentDto;
import com.team2.docgram.dto.HashtagDto;


public class TestContorller {
	/*
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	

	@Autowired
	private TestDao testDao;
	*/
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
		
		String ad = "아,야,어";
		String[] arr = ad.split(",");
		
		
		System.out.println(arr);
		
		
		Map<String , Object> map = new HashMap<>();
		map.put("arr", arr);
		
		sqlSession.selectList("team2.hashinsert", map);
		
	
		
		return "hi";
	}
	
	@GetMapping("/dbTest4")
	@ResponseBody
	public Object dbTest4() {
		

		Map<String , Object> map = new HashMap<>();
		map.put("title", "테");
		map.put("content", "테");
		
		List<BoardDto> boardList =sqlSession.selectList("team2.selectInfo", map);
		System.out.println(boardList);
		
		
		  for(BoardDto i : boardList) { 
			  System.out.println(i.getContent());
			  System.out.println(i.getPk());
			  System.out.println(i.getDate());
		  }
		 
	
		
		return "hi";
	}
	
	@GetMapping("/dbTest5")
	@ResponseBody
	public Integer dbTest5() {
		
		HashtagDto dto = new HashtagDto();
		dto.setDescription("hi");
		// sqlSession 모든 dml 은 return integer - > 명령 수행 row 수
		Integer result = sqlSession.insert("team2.hashtagInsert", dto);
		
		//아까 계속 setter 지랄한 이유 . 저 selectKey 는 setter 에 parameter 넣는 거.
		System.out.println(dto.getPk());
		System.out.println(result);

		return result;
		
	}
	
	@GetMapping("/tagTest")
	public String test232323(Model model) {
		
		String test = "재범,윤구,예빈";
		String result = hashtagListIs(test);
		System.out.println(result);
		
		model.addAttribute("result", result);
		
		return "tagTest";
	}
	
	
	public String hashtagListIs(String hashtagList) {
		// 표현되는 hashtag 는 ( #재범 #윤구 #예빈 )이렇게
		
		
		String proc = hashtagList.replace(",", "</tag> #<tag>");
		System.out.println(proc);
		
		String hashtagListDetail="#<tag>"+proc+"</tag>";
		// 이렇게 넘어가면 js 에서 인식을 하냐?
		
		return hashtagListDetail;
	}
	
}
