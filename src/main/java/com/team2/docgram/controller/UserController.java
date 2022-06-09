package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		UserDto userDetail = userService.readUser(user);
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
	 * 설명
	 * 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("user/tos")
	public String userTos() {
		return "login/tos";
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
	@ResponseBody
	public UserDto updatePage(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		UserDto dbUser = userService.readUserOne(user);
		return dbUser;
		
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
	public void update(@RequestBody Map<String, Object> map, HttpSession session) {
		String password = (String) map.get("password");
		String deptNumber = (String) map.get("deptNumber");
		String phoneNumber= (String) map.get("phoneNumber");
		
		UserDto user = new UserDto();
		UserDto sessionUser = (UserDto) session.getAttribute("user");
		Long userId = sessionUser.getId();
		user.setId(userId);
		if(password == "") {
			user.setPassword(null);
		}else {
			user.setPassword(password);			
		}
		user.setDeptNumber(deptNumber);
		user.setPhoneNumber(phoneNumber);
		userService.updateUser(user);
		UserDto userDetail = userService.readUser(user);
		session.setAttribute("user", userDetail);
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
	 * 사용자의 MYtag 수정 로직
	 * 
	 * @param tagName 지정한 tag 이름 받음
	 * @param session 수정된 데이터를 보여줄 session
	 * @return 동일 페이지로 리턴 + 값 표시
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("mypage/mytag")
	@ResponseBody
	public String updateMytag(String tagName,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		Long hashtagId = hashtagService.readHashtag(tagName);
		user.setHashtagId(hashtagId);
		userService.updateHashtag(user);
		UserDto userDetail = userService.readUser(user);
		session.setAttribute("user", userDetail);
		return tagName;
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
	 * 설명
	 * 
	 * @param session
	 * @param model
	 * @param name
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("admin/user")
	public String adminUserPage(HttpSession session, Model model, String name, Long page) {
		List<UserDto> userList = new ArrayList<UserDto>();
		if(name == null) {
			userList = userService.readUserList(page);			
		}else {
			userList = userService.readUserList(page, name);
		}
		model.addAttribute("userList",userList);
		return "admin/user";
	}
	
	/**
	 * 설명
	 * 
	 * @param map
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@PostMapping("admin/user/update")
	@ResponseBody
	public Integer adminUserUpdate(@RequestBody Map<String, Object> map, HttpSession session) {
		String deptString = (String) map.get("deptId");
		String userString = (String) map.get("userId");
		Long deptId = Long.parseLong(deptString);
		Long userId = Long.parseLong(userString);
		Integer result = userService.updateDept(deptId,userId);
		return result;
		
	}
	
	/**
	 * 설명
	 * 
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@GetMapping("admin/board")
	public String adminBoardPage(HttpSession session, Model model, @RequestParam(defaultValue = "1", required = false, name= "page")Long page, String sel, String text) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long deptId = user.getDeptId();
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardService.readDeptBoardList(page, deptId, sel, text);
		model.addAttribute("boardList", boardList);
		return "admin/board";
	}
	
}

