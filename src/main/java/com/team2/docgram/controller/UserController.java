package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.BoardService;
import com.team2.docgram.service.HashtagService;
import com.team2.docgram.service.StarmarkService;
import com.team2.docgram.service.UserService;


/**  UserController.java
 *   사용자 CRUD 에 관한 컨트롤러
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HashtagService hashtagService;
	
	@Autowired
	private StarmarkService starmarkService;
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 로그인 페이지 전환
	 * 
	 * @return 로그인 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("user/signin")
	public String loginPage() {
		return "login/login";
	}
	
	/**
	 * 로그인 처리
	 * 
	 * @param user 입력된 user 정보
	 * @param session user 객체를 session에 심기 위한 session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("user/signin")
	public String login(UserDto user,HttpSession session) {
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		UserDto userDetail = userService.readUser(user);
		System.out.println(userDetail);
		if(userDetail == null) {
			return "redirect:signin";
		}else {
			session.setAttribute("user", userDetail);
			
			return "redirect:../main";			
		}
	}
	
	/**
	 * 로그아웃 처리
	 * 
	 * @param session user의 정보가 담겨있는 session
	 * @return 다시 메인 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("user/signout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	/**
	 * 가입 페이지로 전환
	 * 
	 * @return 가입 페이지 view
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("user/signup")
	public String signupPage() {
		return "login/join";
	}
	
	/**
	 * 가입 처리
	 * 
	 * @param user 작성된 user 정보
	 * @param deptCode dept_id 와 postion_id 가 포함된 정보
	 * @return 다시 로그인 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("user/signup")
	public String createUser(UserDto user,Long deptCode) {
		// 입력받는 deptCode 값이 11 110 000 + position
		System.out.println(user);
		
		Long positionId = deptCode % 10;
		Long deptId = deptCode - positionId;
		user.setPositionId(positionId);
		user.setDeptId(deptId);
		
		userService.createUser(user);
		
		return "redirect:/user/signin";
	}

	/**
	 * 마이페이지 - 정보 조회 페이지
	 * 
	 * @param model db에 저장된 해당 유저 값 표시를 위한 model
	 * @param session user 정보를 조회하기 위한 session
	 * @return 사용자 정보와 함께 조회 페이지 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("mypage/update")
	public String updatePage(Model model,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		UserDto dbUser = userService.readUser(user);
		model.addAttribute("dbUser", dbUser);
		return "";
	}
	
	/**
	 * 사용자 정보 수정
	 * 
	 * @param user 수정된 user 정보
	 * @param session 다시 user의 정보를 심을 session
	 * @return 수정된 session과 함께 다시 수정된 정보 조회로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("mypage/update")
	public String update(UserDto user,HttpSession session) {
		UserDto sessionUser = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		if(updatedUser == null) {
			return "redirect:/";
		}else {
			session.setAttribute("user", updatedUser);			
			return "";
		}
	}
	
	/**
	 * 회원 탈퇴
	 * 
	 * @param session 사용자의 정보를 담고있는 session
	 * @param confirm 회원 탈퇴 재차 확인
	 * @return session 초기화 + 가입 페이지로 전환
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@PostMapping("mypage/quit")
	public String delete(HttpSession session,@RequestParam(defaultValue = "1", name = "confirm") Integer confirm) {
		if(confirm == 1) {
			UserDto user = (UserDto) session.getAttribute("user");
			Long userId = user.getId();
			userService.deleteUser(userId);
			session.invalidate();
			return "../user/signup";
		}else {
			return "mypage";
		}
	}
	
	/**
	 * 관리자 페이지 - 사용자 조회
	 * 
	 * @param model 사용자 들의 값을 심기 위한 model
	 * @return 사용자 목록 + 페이지
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("mypage/user")
	public String searchUserPage(Model model) {
		List<UserDto> userList = userService.readUserList();
		model.addAttribute("userList", userList);
		return "mypage/mypage";
	}
	
	/**
	 * 사용자 목록중 이름으로 사용자 검색
	 * 
	 * @param model 값 표현을 위한 model
	 * @param name 검색할 사용자의 이름
	 * @return 
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("mypage/user")
	public String searchUser(Model model,String name) {
		List<UserDto> userList = userService.readUserList(name);
		model.addAttribute("", model);
		return "";
	}

	/**
	 * 사용자 지정 태그 수정 페이지
	 * 
	 * @param session
	 * @param model
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@GetMapping("mypage/mytag")
	public String mytag(HttpSession session,Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = user.getHashtagId();
		String mytag = hashtagService.readHashtag(hashtagId);
		model.addAttribute("mytag", user);
		return null;
	}
	
	/**
	 * 사용자의 MYtag 수정 로직
	 * 
	 * @param tagName 지정한 tag 이름 받음
	 * @param session 수정된 데이터를 보여줄 session
	 * @return 동일 페이지로 리턴 + 값 표시
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("mypage/mytag")
	public String updateMytag(String tagName,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = hashtagService.readHashtag(tagName);
		userService.updateHashtag(hashtagId);
		return "redirect:/";
	}
	
	/**
	 * 설명
	 * 
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 3.
	 */
	@GetMapping("mypage")
	public String mypagePage(HttpSession session,Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readMyBoardList(userId);
		model.addAttribute("boardList", boardList);
		return "mypage/mypage";
	}
	
	/**
	 * 즐겨찾기 추가 로직
	 * 
	 * @param boardId 즐겨찾기에 추가할 게시판 id
	 * @param session user의 id를 포함한 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("starmark/create")
	public void createStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		starmarkService.createStarmark(userId,boardId);
	}
	
	/**
	 * 즐겨찾기 삭제 로직
	 * 
	 * @param boardId 삭제할 대상 board의 id
	 * @param session 사용자의 정보를 조회할 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("starmark/delete")
	public void deleteStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		starmarkService.deleteStarmark(userId,boardId);
	}
	
	/**
	 * 부서 알림 추가 로직
	 * 
	 * @param boardId 추가할 board 의 id
	 * @param session 사용자가 속한 부서 정보를 가진 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("deptmark/create")
	public void createDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.createDeptmark(deptId,boardId);			
		}
	}
	
	/**
	 * 부서 알림 삭제 로직
	 * 
	 * @param boardId 삭제할 board 의 id
	 * @param session 사용자가 속한 부서 정보를 가진 session
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@PostMapping("deptmark/delete")
	public void deleteDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.deleteDeptmark(deptId,boardId);			
		}
	}
	
	@GetMapping("admin/user")
	public String adminUserPage(HttpSession session) {
		return "admin/user";
	}
	
	@GetMapping("admin/board")
	public String adminBoardPage(HttpSession session) {
		return "admin/board";
	}
	
}

