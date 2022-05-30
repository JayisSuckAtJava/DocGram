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
	
	@GetMapping("")
	public String loginPage() {
		
	}
	
	@PostMapping("")
	public String login(UserDto user,HttpSession session) {
		
		UserDto u = userService.readUser();
		session.setAttribute("user", user);
		return "redirect:/main";
	}
	
	@GetMapping("")
	public String logout(HttpSession session) {
		session.invalidate();
		return "";
	}
	
	@GetMapping("")
	public String signupPage() {
		return "";
	}
	
	@PostMapping("")
	public String signup(UserDto user) {
		return "redirect:/";
	}
	
	@GetMapping("")
	public String updatePage(Model model,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		userService.readUser();
		return "";
	}
	
	@PostMapping("")
	public String update(UserDto user) {
		userService.updateUser();
		return "redirect:/";
	}
	
	@GetMapping("")
	public String searchUserPage() {
		
	}
	
	@PostMapping("")
	public String searchUser(Model model) {
		model.addAttribute("", model);
		return "";
	}

	@PostMapping("")
	public String updateMytag(String tagName,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = hashtagService.readHashtag(tagName);
		userService.updateHashtag(hashtagId);
		
	}
	
	@PostMapping("")
	public String createStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.createStarmark(boardId);
	}
	
	@PostMapping("")
	public String deleteStarmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.deleteStarmark(boardId);
	}
	
	@PostMapping("")
	public String createDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.createDeptmark(boardId);
	}
	
	@PostMapping("")
	public String createDeptmark(Long boardId,HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		starmarkService.deleteDeptmark(boardId);
	}
}

