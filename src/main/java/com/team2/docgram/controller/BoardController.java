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
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.FileService;



/**  BoardController.java
 *   설명
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
	
	/**
	 * 설명
	 * 
	 * @param 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board")
	public String boardList(Model model,Long page) {
		if(page == null) {
			page = 1L;
		}
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readBoardList(page);
		model.addAttribute("boardList", boardList);
		return "detailsearch";
	}
	
	/**
	 * 설명
	 * 
	 * @param 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board/{id}")
	public String board(@PathVariable("id")Long id,Model model) {
		Map<String, Object> map = new HashMap<>();
		map = boardService.readBoard(id);
		
		model.addAllAttributes(map);
		return "board/detail";
	}
	
	/**
	 * 설명
	 * 
	 * @param 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@GetMapping("board/create")
	public String boardCreatePage() {
		return "board/create";
	}
	
	/**
	 * 설명
	 * 
	 * @param 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@PostMapping("board/create")
	public String boardCreate(HttpSession session,BoardDto board,String hashtagList, MultipartFile mFile,String relatedBoardList) {
		//UserDto user = (UserDto) session.getAttribute("user");
		//Long userId = user.getId();
		board.setUserId(1L);
		
		String fileName = mFile.getOriginalFilename();
			
		String savedFileName = boardService.createBoard(board,hashtagList,relatedBoardList,fileName);
		if(savedFileName == null) {
			return "redirect:../read";
		}else {
			fileService.createFile(savedFileName, mFile);
			return "redirect:../read";
		}
	}
	
	/**
	 * 설명
	 * 
	 * @param id
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id")Long id) {
		return fileService.readFile(id);
	}
	
	/**
	 * 설명
	 * 
	 * @param id
	 * @param model
	 * @return
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
	 * 설명
	 * 
	 * @param id
	 * @param board
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@PostMapping("board/update/{id}")
	public String boardUpdate(@PathVariable("id")Long id,BoardDto board, String hashtagList, String relatedBoardList) {
		board.setId(id);
		boardService.boardUpdate(board, hashtagList, relatedBoardList);
		return "redirect:../"+id;
	}
	
	/**
	 * 설명
	 * 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("board/popup")
	public String popup() {
		return "board/popup";
	}
	
	
	/**
	 * 설명
	 * 
	 * @param session
	 * @param model
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("main")
	public String mainPage(HttpSession session,Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		//Long userId = user.getId();
		//Long deptId = user.getDeptId();
		Long userId = 1L;
		Long deptId = 11110000L;
		
		List<BoardDto> starList = boardService.readStarmarkList(userId);
		List<BoardDto> deptList = boardService.readDeptmarkList(deptId);
		List<BoardDto> noticeList = boardService.readNoticeList();
		
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("starList", starList);
		model.addAttribute("noticeList", noticeList);
		
		return "board/main";
	}
	
	/**
	 * 설명
	 * 
	 * @param model
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("notice")
	public String noticeList(Model model) {
		List<BoardDto> noticeList = boardService.readNoticeList();
		model.addAttribute("boardList", noticeList);
		return "board/notice";
	}
	
	/**
	 * 설명
	 * 
	 * @param model
	 * @param boardId
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("notice/{id}")
	public String notice(Model model,@PathVariable("id")Long boardId) {
		Map<String, Object> notice = new HashMap<>();
		notice = boardService.readBoard(boardId);
		model.addAllAttributes(notice);
		return "board/detail";
	}
	
	/**
	 * 설명
	 * 
	 * @param board
	 * @param session
	 * @return
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
		return "redirect:../";
	}
	
	/**
	 * 설명
	 * 
	 * @param id
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@PostMapping("board/delete/{id}")
	public String delectBoard(@PathVariable("id")Long id,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long positionId = user.getPositionId();
		Long boardUserId = boardService.readBoardUserId(id);
		if(userId == boardUserId || positionId > 6) {
			boardService.deleteBoard(id);
			return "read";
		}
		return "";
	}
	
	@GetMapping("bo/del/{id}")
	public String dee(@PathVariable("id")Long id) {
		boardService.deleteBoard(id);
		return "redirect:../../read";
	}
	
}
