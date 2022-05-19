package com.team2.docgram;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class DBtest {
	String root = "C:\\ProjectTeam2\\file\\";
	/*
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void teststst() {
		int a =1 ;
		int b= 2;
		System.out.println(a+b);
	}

	@Test
	public void test() {
		sqlSession.insert("team2.test");
	}
	
	@Test
	public void testd() {
		// 스트링 배열을 받아서 1개씩 나눠는것
				String input = "태그,들이,움직,이는,게,신기해";
				String[] split = input.split(",");
				System.out.println(split);
				
				for(String i : split) {
					System.out.println(i);
				}
				
	}
	
	
	
	
	
	

	public String uploadtest(MultipartFile mFile) {
		System.out.println("start");

		String oName = mFile.getOriginalFilename();

		System.out.println(oName);
		return oName;
	}
		
	@Test
	public void uploadtesttest() throws IllegalStateException, IOException {
		
		File file = new File(root+"test.txt");
		System.out.println(file.isFile());
		
		
		System.out.println(mFile.isEmpty());
		
		String result = uploadtest(mFile);
		System.out.println(result);
		
	
	}**/	


	public ResponseEntity<Resource> donwloadtest() throws FileNotFoundException, UnsupportedEncodingException {
		String selFileName = ""; // 여기에는 board.file.getFileName 이다.
		File file = new File(root+selFileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		String saveFileName =file.getName();
		Integer underbar = saveFileName.indexOf("_");
		String fileName = saveFileName.substring(underbar);
		return ResponseEntity.ok().header("content-disposition","filename=" + URLEncoder.encode(fileName, "utf-8"))
				 .contentLength(file.length())
				 .contentType(MediaType.parseMediaType("application/octet-stream"))
				 .body(resource);
}
}
