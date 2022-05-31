package com.team2.docgram.controller;

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
	
	@GetMapping("lp")
	public String loginPage() {
		
	}
	
	@PostMapping("l")
	public String login(UserDto user,HttpSession session) {
		
		UserDto userDetail = userService.readUser(user);
		session.setAttribute("user", user);
		return "redirect:/main";
	}
	
	@GetMapping("lo")
	public String logout(HttpSession session) {
		session.invalidate();
		return "";
	}
	
	@GetMapping("sp")
	public String signupPage() {
		return "";
	}
	
	@PostMapping("su")
	public String createUser(UserDto user,Long deptCode) {
		// 입력받는 deptCode 값이 11 110 000 + position
		
		Long positionId = deptCode % 10;
		Long deptId = deptCode - positionId;
		user.setPositionId(positionId);
		user.setDeptId(deptId);
		
		userService.createUser(user);
		
		return "redirect:/";
	}

	@GetMapping("up")
	public String updatePage(Model model,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		userService.readUser();
		return "";
	}
	
	@PostMapping("u")
	public String update(UserDto user) {
		userService.updateUser();
		return "redirect:/";
	}
	
	@GetMapping("su")
	public String searchUserPage() {
		
	}
	
	@PostMapping("sus")
	public String searchUser(Model model) {
		model.addAttribute("", model);
		return "";
	}

	@PostMapping("um")
	public String updateMytag(String tagName,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = hashtagService.readHashtag(tagName);
		userService.updateHashtag(hashtagId);
		
	}
	
	@PostMapping("cs")
	public String createStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.createStarmark(boardId);
	}
	
	@PostMapping("ds")
	public String deleteStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.deleteStarmark(boardId);
	}
	
	@PostMapping("cd")
	public String createDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.createDeptmark(boardId);
	}
	
	@PostMapping("cdd")
	public String deleteDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.deleteDeptmark(boardId);
	}
}

