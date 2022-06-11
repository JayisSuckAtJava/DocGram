package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.FileService;
import com.team2.docgram.service.SearchService;



/**  BoardController.java
 *   Board 테이블에 작성되는 게시글 모든 CRUD 컨트롤러
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class BoardController {
	
	@Autowired
	private FileService fileService;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private SearchService searchService;
	

	/**
	 * 게시판 리스트 조회 페이지, 게시판 조회 + 페이징 처리
	 * 
	 * @param model 값을 화면에 보여주기 위한 model
	 * @param page page 처리를 위한 값
	 * @return 전체 게시판 리스트 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board/list")
	public String boardList(Model model,Long page,HttpSession session, String sel, String text) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		if(page == null) {
			page = 1L;
		}
		List<BoardDto> boardList = new ArrayList<>();
		if(sel == null || text == null) {
			boardList = boardService.readBoardList(page, userId);			
		}else {
			boardList = searchService.readBoardList(page, userId, sel, text);
		}
		model.addAttribute("boardList", boardList);
		return "board/dept";
	}
	
	/**
	 * 게시글 1개 조회 상세 데이터를 id 로 검색
	 * 
	 * @param id 상세 데이터 조회를 위한 해당 board 의 id
	 * @param model 화면에 보여주기 위해 model 에 값을 넣음
	 * @return 게시글 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board/{id}")
	public String board(@PathVariable("id")Long id, Model model, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long deptId = user.getDeptId();
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoard(id, userId, deptId);
		
		model.addAllAttributes(map);
		return "board/detail";
	}
	
	/**
	 * 게시글 작성 페이지 접속
	 *  
	 * @return 게시글 작성 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board/create")
	public String boardCreatePage() {
		return "board/create";		
	}
	
	/**
	 * 입력받은 값을 통해 db 저장 게시글 작성
	 * 
	 * @param session User 객체가 저장된 session
	 * @param board 작성된 board ( title , content )
	 * @param hashtagList 작성된 hash를 1개의 String 으로 전달받음 ( tag, tag, tag )
	 * @param mFile 첨부된 문서 file
	 * @param relatedBoardList 연관 게시글 지정을 1개의 String 으로 전달 받음 ( id, id, id )
	 * @return 작성 완료시 다시 게시글 리스트 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@PostMapping("board/create")
	public String boardCreate(HttpSession session,BoardDto board,String hashtagList, MultipartFile mFile,String relatedBoardList) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		board.setUserId(userId);
		
		String fileName = mFile.getOriginalFilename();
			
		String savedFileName = boardService.createBoard(board,hashtagList,relatedBoardList,fileName);
		if(savedFileName == null) {
			return "redirect:/board/list";
		}else {
			fileService.createFile(savedFileName, mFile);
			return "redirect:/board/list";
		}
	}
	
	/**
	 * 파일의 id 값을 get으로 받아 file Download
	 * 
	 * @param id 조회를 위한 해당 File의 id
	 * @return 검색된 file의 download Resource
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id")Long id) {
		return fileService.readFile(id);
	}
	
	/**
	 * 게시글 수정을 위한 페이지 전환 + DB 저장값 표시
	 * 
	 * @param id DB에 저장된 board를 읽기위한 id
	 * @param model 표시를 위해 값을 심을 model
	 * @return update 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("board/update/{id}")
	public String boardUpdatePage(@PathVariable("id")Long id,Model model) {
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoardOne(id);
		model.addAllAttributes(map);
		return "board/update";
	}


	/**
	 * 수정 완료 후 post 로 수정된 값 받아 db에 수정
	 * 
	 * @param id 해당 board 의 id
	 * @param board 수정된 board의 title content
	 * @param hashtagList 작성한 hashtag 들을 1개의 String 으로 변환
	 * @param relatedBoardList 선택된 관련 문서들의 id를 1개의 String 으로 변환
	 * @return 다시 해당 board 의 조회 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@PostMapping("board/update/{id}")
	public String boardUpdate(@PathVariable("id")Long id,BoardDto board, String hashtagList, String relatedBoardList, MultipartFile mFile) {
		board.setId(id);
		boardService.boardUpdate(board, hashtagList, relatedBoardList);
		return "redirect:/board/"+id;
	}
	
	/**
	 * DocGram 의 메인 페이지 공지사항, 부서별 알림, 즐겨찾기 목록 등을 user 정보로 조회 표현
	 * 
	 * @param session session에 저장된 user 정보를 받기 위한 session
	 * @param model 표현을 위해 값을 심을 model
	 * @return main 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping(value = {"main","/"})
	public String mainPage(HttpSession session,Model model) {
		
		UserDto user = (UserDto) session.getAttribute("user");
		if(user == null) {
			return "board/main";
		}else {
		Long userId = user.getId();
		Long deptId = user.getDeptId();
		
		List<BoardDto> starList = boardService.readStarmarkList(userId);
		List<BoardDto> deptList = boardService.readDeptmarkList(deptId);
		List<BoardDto> noticeList = boardService.readNoticeList();
		
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("starList", starList);
		model.addAttribute("noticeList", noticeList);
		return "board/main";
		}
	}
	
	/**
	 * 공지사항 조회를 위한 List 출력 페이지
	 * 
	 * @param model 값을 심기 위한 model
	 * @return 공지사항 조회 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("notice/list")
	public String noticeList(Model model) {
		List<BoardDto> noticeList = boardService.readNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "board/notice";
	}
	
	/**
	 * 해당 공지사항 조회 표현
	 * 
	 * @param model 표현을 위해 값을 심는 model
	 * @param boardId 선택한 공지사항의 조회를 위한 id
	 * @return 공지사항 조회 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("notice/{id}")
	public String notice(Model model,@PathVariable("id")Long boardId, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long deptId = user.getDeptId();
		Map<String, Object> notice = new HashMap<>();
		notice = boardService.readBoard(boardId, userId, deptId);
		model.addAllAttributes(notice);
		return "board/detail";
	}
	
	@GetMapping("notice/create")
	public String noticeCreate() {
		return "board/create";
	}
	
	/**
	 * 공지사항 작성
	 * 
	 * @param session session에 있는, 작성자 정보 조회를 위한 session
	 * @param board 작성된 title, content
	 * @param hashtagList 작성된 hashtag 들을 1개의 String 으로 변환
	 * @param mFile 첨부된 문서
	 * @param relatedBoardList 선택된 연관 게시글들을 1개의 String 으로 변환
	 * @return 전체 공지사항 페이지로 이동
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("notice/create")
	public String createNotice(HttpSession session,BoardDto board,String hashtagList, MultipartFile mFile,String relatedBoardList) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		
		board.setUserId(userId);
		board.setSecurity(0);
		boardCreate(session,board,hashtagList,mFile,relatedBoardList);
		return "redirect:/notice/list";
	}
	
	/**
	 * 게시글 삭제
	 * 
	 * @param id 해당 게시글의 id 값
	 * @param session 수정하려는 사용자가 작성자 혹은 관리자 인이 확인을 위해 session 의 user를 가져오기 위한 session
	 * @return 다시 전체 게시글 리스트로 이동
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@GetMapping("board/delete/{id}")
	@ResponseBody
	public Integer delectBoard(@PathVariable("id")Long id,HttpSession session) {
		Integer result = 0;
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long positionId = user.getPositionId();
		Long boardUserId = boardService.readBoardUserId(id);
		if(userId == boardUserId || positionId > 6) {
			result = boardService.deleteBoard(id);
		}
		return result;
	}
	
}
