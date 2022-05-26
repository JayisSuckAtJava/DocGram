package com.team2.docgram;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
		
	
	}
	
	@GetMapping("/fileTest")
	public String filetest() {
		return "file";
	}
	
	@PostMapping("/fileTest")
	@ResponseBody
	public String filetestpst(MultipartFile mFile,String text) {
		String root = "C:\\ProjectTeam2\\file\\";
		
		
		System.out.println("start");
		
		

		System.out.println(text);
		System.out.println(mFile.getOriginalFilename());
		String oName = "pk_"+mFile.getOriginalFilename();

		System.out.println(oName);
		
		String file_attach = root+oName;
		
		System.out.println(file_attach);
		
		File file = new File(file_attach);
		
		System.out.println(file.isFile());
		System.out.println(mFile.isEmpty());
		
		try {
			mFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("end");
		
		
		
		return "file";
	}
	
	**/	
/*

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
	
	@Test
	public void String() {
		// String ac,ad 를 입력 받아서 배열로 혹은 List로
		// front 에서 해시,태그,들은,이런,식으,로,옵니다
		// 를 받으면 배열로 만들어서 db에 연동처리
		String hashtagList = "안녕,모두,아니";
		
		
		// 1번 split 을 사용하여 String[] 로
		String[] list = hashtagList.split(",");
		for(String i : list) {
			System.out.println(i);
		}
		
		// 2번 1번의 배열을 list에 넣는다
		List<String> arrayList = new ArrayList<String>();
		for(String i : list) {
			arrayList.add(i);
		}
		System.out.println(arrayList);
		
		
		String test =arrayList.toString();
		System.out.println(test);
		String teste = test.substring(1, test.length()-1);
		System.out.println(teste);
	}
		
	
	@Test
	public void testest() {
		
		testdb db = searchDetail();
		System.out.println(db);
		//db 라는 걸로 컨트롤러가 받았어 그럼 이제 어떻게 단계랑 그런걸 구분하냐?
		
	}

	
	//String key, String text, Date date, Date start, Date end, String file, String rank, String hashtagList
	public testdb searchDetail() {
		testdb db = new testdb();
		
		String dayis = "2022-05-25";
		Date day = Date.valueOf(dayis);
		
		
		String st = "2022-04-25";
		String en = "2022-05-23";
		Date start = Date.valueOf(st);
		Date end = Date.valueOf(en);

		db.setKey("title");
		db.setText("세종시");
		db.setFile("공문");
		db.setRank(2);
		db.setHashtagList("믿음,소망,사랑");
		db.setDate(day);
		db.setFileCode("D1005");
		
		return db;
	}
	
	
	@Setter
	@Getter
	@ToString
	public class testdb {
		Integer rank;
		String key, text, file, hashtagList, fileCode;
		Date date;
	}*/
	
	@Test
	public void test() {
		String test = "재범,윤구,예빈";
		String result = hashtagListIs(test);
		System.out.println(result);
	}
	
	
	public String hashtagListIs(String hashtagList) {
		// 표현되는 hashtag 는 ( #재범 #윤구 #예빈 )이렇게
		
		
		String proc = hashtagList.replace(",", "</td> #<td>");
		System.out.println(proc);
		
		String hashtagListDetail="#<td>"+proc+"</td>";
		// 이렇게 넘어가면 js 에서 인식을 하냐?
		
		return hashtagListDetail;
	}
}
