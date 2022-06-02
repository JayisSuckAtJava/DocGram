package com.team2.docgram.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.HashtagService;
import com.team2.docgram.service.StarmarkService;
import com.team2.docgram.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HashtagService hashtagService;
	
	@Autowired
	private StarmarkService starmarkService;
	
	@GetMapping("signin")
	public String loginPage() {
		return "login/login";
	}
	
	@PostMapping("signin")
	public String login(UserDto user,HttpSession session) {
		
		UserDto userDetail = userService.readUser(user);
		if(userDetail == null) {
			return "redirect:/signin";
		}else {
			session.setAttribute("user", user);
			return "redirect:/main";			
		}
	}
	
	@GetMapping("signout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	@GetMapping("signup")
	public String signupPage() {
		return "login/join";
	}
	
	@PostMapping("signup")
	public String createUser(UserDto user,Long deptCode) {
		// 입력받는 deptCode 값이 11 110 000 + position
		
		Long positionId = deptCode % 10;
		Long deptId = deptCode - positionId;
		user.setPositionId(positionId);
		user.setDeptId(deptId);
		
		userService.createUser(user);
		
		return "redirect:/";
	}

	@GetMapping("mypage/update")
	public String updatePage(Model model,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		UserDto dbUser = userService.readUser(user);
		model.addAttribute("dbUser", dbUser);
		return "";
	}
	
	@PostMapping("mypage/update")
	public String update(UserDto user,HttpSession session) {
		UserDto updatedUser = userService.updateUser(user);
		if(updatedUser == null) {
			return "";
		}else {
			session.setAttribute("user", updatedUser);			
			return "redirect:/";
		}
	}
	
	@GetMapping("mypage/user")
	public String searchUserPage() {
		List<UserDto> userList = userService.readUserList();
		return "";
	}
	
	@PostMapping("mypage/user")
	public String searchUser(Model model,String name) {
		List<UserDto> userList = userService.readUserList(name);
		model.addAttribute("", model);
		return "";
	}

	@PostMapping("mypage/mytag")
	public String updateMytag(String tagName,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = hashtagService.readHashtag(tagName);
		userService.updateHashtag(hashtagId);
		return "redirect:/";
	}
	
	@PostMapping("starmark/create")
	public void createStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		starmarkService.createStarmark(userId,boardId);
	}
	
	@PostMapping("starmark/delete")
	public void deleteStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long userId = user.getId();
		starmarkService.deleteStarmark(userId,boardId);
	}
	
	@PostMapping("deptmark/create")
	public void createDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.createDeptmark(deptId,boardId);			
		}
	}
	
	@PostMapping("deptmark/delete")
	public void deleteDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long postionId = user.getPositionId();
		if(postionId > 5) {
			Long deptId = user.getDeptId();
			starmarkService.deleteDeptmark(deptId,boardId);			
		}
	}
}

