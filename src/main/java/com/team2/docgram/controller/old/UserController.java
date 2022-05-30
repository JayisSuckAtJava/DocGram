package com.team2.docgram.controller.old;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.old.UserService;


public class UserController {
/*
	@Autowired
	private UserService userService;
	*/
	@GetMapping("signin")
	public String signinPage() {
		return "signin";
	}
	
	@PostMapping("signin")
	public String signin(UserDto user,HttpSession session) {
		UserDto result = userService.readOne(user);
		if(result == null) {
			return "signin";
		}else {
			session.setAttribute("user", result);
			return "main";
		}
	}
	
	@GetMapping("signout")
	public String signout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@GetMapping("signup")
	public String signupPage() {
		return "signup";
	}
	
	@PostMapping("signup")
	public String signup(UserDto user) {
		// read 를 session에 정보로 조회해서 하면 안되냐?
		// 그러면 session 에 mytag 란 거랑 starMark 란 걸 만들어서 거기에
		// user 의 mytag 랑 starMark 박아둘까"? 그러면
		// el 로 ${session.mytag} 이지랄 해서 읽을수 있는데
		Integer result = userService.createOne(user);
		if(result == 0) {
			return "signup";
		}else {
			return "login";			
		}
	}
	
	@GetMapping("find")
	public String findPage() {
		return "find";
	}
	
	@PostMapping("find")
	public String find(UserDto user, Model model) {
		UserDto read = userService.readUserOne(user);
		return "login";
	}
	
	@GetMapping("update")
	public String updatePage(HttpSession session, Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
				// 굳이 db 접속해서 다 가져와야하나?
				// 혹시 모르지 조인으로 더 많은걸 가져와야 할지
		UserDto result = userService.readOne(user);
		model.addAttribute("userDetail", result);
		return "update";
	}
	
	@PostMapping("update")
	public String update(UserDto user, HttpSession session, Model model) {
		userService.updateOne(user);
		return "update";
	}
	
	@GetMapping("delete")
	public String deletePage(HttpSession session, Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		model.addAttribute("user", user);
		return "signout";
	}
	
	@PostMapping("delete")
	public String delete(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		userService.deleteOne(user);
		return "main";
	}
	
	//user 객체가 starMark 나 mytag 변경시 수정하는 로직.
	
	@GetMapping("mypage")
	public String mypagePage() {
		return "mypage";
	}
	
	@PostMapping("starMark/create")
	public void starMarkCreate(Integer boardPk) {
		userService.createStarMark(boardPk);
	}
	
	@PostMapping("starMark/delete")
	public void starMarkDelete(Integer boardPk) {		
		userService.deleteStarMark(boardPk);
	}
	
	@PostMapping("starMark/read")
	public void starMarkRead(Integer boardPk) {
		// read 를 session에 정보로 조회해서 하면 안되냐?
		userService.readStarMark(boardPk);
	}
	
	@PostMapping("mytag/create")
	public void mytagCreate(String hashtag) {
		userService.createMytag(hashtag);
	}
	
	@PostMapping("mytag/delete")
	public void mytagDelete(String hashtag) {		
		userService.deleteMytag(hashtag);
	}
	
	@PostMapping("mytag/read")
	public void mytagRead(String hashtag) {
		// read 를 session에 정보로 조회해서 하면 안되냐?
		userService.readMytag(hashtag);
	}
	
}
