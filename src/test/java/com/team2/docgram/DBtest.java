package com.team2.docgram;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.BoardHashtagDao;
import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		})
public class DBtest {
	String root = "C:\\ProjectTeam2\\file\\";
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BoardHashtagDao bhDao;
	
	
	@Autowired
	private BoardService boardService;
	@Test
	public void teststst() {
		BoardDto board = new BoardDto();
		board.setTitle(" xptmxm");
		board.setContent("내용");
		board.setUserId(1l);
//		Long re = boardDao.createBoard(board);
//		System.out.println(re);
//		BoardDto re = boardDao.createBoard(board);
//		System.out.println(re);
	}

	
	@Test
	public void teststs2t() {
		int a =1 ;
		int b= 2;
		System.out.println(a+b);
	}

/*
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
	}
	
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
	
	@Test
	public void tsds() {
		String til = "D";
		String zero = "0";
		Integer a = 315454;//PK 들어가는값
		
		
		for(int i = a.toString().length(); i<13 ; i++) {
			til = til + zero;
		}
		String test = til+a;
		System.out.println(test);

	}
	
	@Test
	public void tXss() {
		List<BoardDto> list = new ArrayList<>();
		list = sqlSession.selectList("board.readBoardList");
		for(BoardDto i : list) {
			System.out.println(i);
		}
		System.out.println("test");
	}
	
	@Test
	public void tst() {
		Map<String,Object> map = new HashMap<>();
		BoardDto board;
		Long id = 1L;
		
		Object obj = sqlSession.selectOne("board.test",id);
		System.out.println(obj);
		board = sqlSession.selectOne("board.test",id);
		//map = sqlSession.selectOne("board.test");
		System.out.println(board);
		System.out.println("here");
		
	}
	@Test
	public void tresd() {
		List<BoardDto> board = sqlSession.selectList("board.readBoardList");
		for (BoardDto i : board) {
			System.out.println(i);
		}
	}
	
	@Test
	public void hashtag() {
		Long boardId = 1L;
		List<HashtagDto> hashtagList = new ArrayList<>();
		hashtagList = sqlSession.selectList("hashtag.readList", boardId);
		
		System.out.println(hashtagList);
	}
	
	@Test
	public void deptTest() {
		Long deptId = 11000000L;
		DeptDto dept = sqlSession.selectOne("user.readDeptList",deptId);
		
		System.out.println(dept);
	}
	
	@Test
	public void boardRelTest() {
		Long[] relationListId = {2L,3L,4L};
		
		List<BoardDto> relationList = new ArrayList<>();
		for(Long i : relationListId) {
			relationList.add(sqlSession.selectOne("board.readRelationBoard", i));
		}
		for(BoardDto i : relationList) {
			System.out.println(i);
		}
	}
	
	@Test
	public void sdasdsd() {
		Long id = 1L;
		Map<String, Object> map = boardService.readBoard(id);
		
		System.out.println(map);
	}
	
	@Test
	public void stea() {
		String in = "2,3,4";
		String [] sa = in.split(",");
		Stream<String> str = Stream.of(sa);
		System.out.println(str.toString());
	}
	
	@Test
	public void longtest() {
		// 11110009 를 입력받아서 끝에 9인걸 받는다
		
		Long a = 11110009L;
		Long b = a%10;
		System.out.println(b);
	}*/
	@Test
	public void stea() {
		UserDto user = new UserDto();
		user.setEmail("ac");
		user.setPassword("df");
		UserDto u = userDao.readUser(user);
		System.out.println(u);
	}
	
	@Test
	public void sdsdsd() {
		Long page = 3L;
		page = ( page - 1 ) * 10;
		System.out.println(page);
	}
	
	@Test
	public void thhang() {
		Long r = 1L;
		Long rel1, rel2, rel3;
		if(r==0) {
			System.out.println(r+"은 0");
		}else{
			rel1 = ( r >= 1 ) ? 1L : null;
			rel2 = ( r >= 2 ) ? 1L : null;
			rel3 = ( r >= 3 ) ? 1L : null;
		}
	}
	
	@Test
	public void sdsdssdsdd() {
		Map<String,Object> map = new HashMap<>();				
		map.put("boardId", 1L);
		map.put("hashtagId", 5L);
		
		Long result = bhDao.readBoardHashtag(map);
		System.out.println(result);
	}
	
	@Test
	public void sdsdssfd() {
		// 제작 의도
		// 게시글 수정에서 해시태그를 수정할 경우 원래 해시태그가 삭제 되는게 아니라
		// 포함한 상태로 나옴
		// array로 처리하니까 sort를 사용해볼 예정
		
		String[] a = {"믿음","소망","사랑"};
		String[] b = {"사랑","탄식","믿음"};
		String[] test = {"ㄱ","가","ㄴ","나"};

		for(String i : a) {
			System.out.println(i);
		}
		System.out.println("---------");
		for(String i : b) {
			System.out.println(i);
		}
		System.out.println("---------");
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(String i : a) {
			System.out.println(i);
		}
		System.out.println("---------");
		for(String i : b) {
			System.out.println(i);
		}
		System.out.println("---------");
		Arrays.sort(test);
		for(String i : test) {
			System.out.println(i);
		}

	}
	
	@Test
	public void sdsad() {
		// index 가 바뀌면 어카냐
		
		String[] a = {"가","나","라","마"};
		String[] b = {"나","가","다","라"};
		
		for(String i : a) {
			System.out.println(i);
		}
		System.out.println("---------");
		for(String i : b) {
			System.out.println(i);
		}
		System.out.println("---------");
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(String i : a) {
			System.out.println(i);
		}
		System.out.println("---------");
		for(String i : b) {
			System.out.println(i);
		}
	}
	
	@Test
	public void sdsadadasd() {
		
		String[] a = {"가","나","다","라","하"};
		String[] b = {"나","다","라","마","하"};
		
			
			String one = null;
			String two = null;
			Boolean result = false;
			String same = "";
			String plus = "";
			String minus = "";
			
			for(String j : a) {
				one = j;
				
				for(String k : b) {
					two = k;
					result = one.equals(two);
					if(result == true) {
						same = same + k + ",";
						System.out.println(result);
					}else {
						plus = plus + k + ",";
					}
				}
				System.out.println("--------------");
			}
			System.out.println(same);
			System.out.println(plus);
			
			String[] sameS = same.split(",");
			String[] plusS = plus.split(",");
			for(String t : sameS) {
				System.out.println(t);
			}
			Stream<String> test = Arrays.stream(sameS);
			Stream<String> te2 = Arrays.stream(plusS);
			test.anyMatch(te2);
	}
	
	@Test
	public void sdsadasda() {
		Long page = 1L;
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList(page);
		int all = boardList.size();
		System.out.println(all);
	}
	
	@Test
	public void sadsadad() {
		sqlSession.selectOne("boardMapper.test");
	}
	
	@Test
	public void searchDetail() {
		
		String [] arr;
		String test = "내용";
		arr = test.split(",");
		
		for(String i : arr) {
			System.out.println(i);
		}
		System.out.println(arr.toString());
		searchDto sd = new searchDto();
		sd.setSel("title");
		sd.setText("306");
		sd.setPosition((long) 9);
		sd.setFileName("임시회");
		sd.setFileNum("D00000");
		sd.setHashtagList(arr);
		
		sd.setDateRange((long) 31);
				
		String st = "2022-05-01";
		String en = "2022-06-01";
		Date start = Date.valueOf(st);
		Date end = Date.valueOf(en);
		
		sd.setStart(start);
		sd.setEnd(end);
		
		List<BoardDto> boardList = new ArrayList<>();
		boardList = sqlSession.selectList("search.testSearch", sd);
		
		for(BoardDto i : boardList) {
			System.out.println(i);
		}
		
	}
	
	@Test
	public void size() {
		Map<String,Object> map = new HashMap<>();
		
		String[] arr = {"내용"};
		
		map.put("sel", "title");
		map.put("text", "306");
		map.put("position", 9);
		map.put("fileName", "임시회");
		map.put("dateRange", 30);
		map.put("hashtagList", arr);
		
		Long size = sqlSession.selectOne("search.searchDetailSize", map);
		System.out.println(size);
	}
	
	
	
	
}
