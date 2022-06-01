package com.team2.docgram.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team2.docgram.dto.UserDto;
import com.team2.docgram.service.HashtagService;
import com.team2.docgram.service.StarmarkService;
import com.team2.docgram.service.UserService;


/**  UserController.java
 *   설명
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
	
	/**
	 * 설명
	 * 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@GetMapping("signin")
	public String loginPage() {
		return "login/login";
	}
	
	/**
	 * 설명
	 * 
	 * @param user
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
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
	
	/**
	 * 설명
	 * 
	 * @param session
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("signout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	/**
	 * 설명
	 * 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("signup")
	public String signupPage() {
		return "login/join";
	}
	
	/**
	 * 설명
	 * 
	 * @param user
	 * @param deptCode
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
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

	/**
	 * 설명
	 * 
	 * @param model
	 * @param session
	 * @return
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
	 * 설명
	 * 
	 * @param user
	 * @param session
	 * @return
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
	 * 설명
	 * 
	 * @param session
	 * @param confirm
	 * @return
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
			return "signup";
		}else {
			return "mypage";
		}
	}
	
	/**
	 * 설명
	 * 
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@GetMapping("mypage/user")
	public String searchUserPage(Model model) {
		List<UserDto> userList = userService.readUserList();
		model.addAttribute("userList", userList);
		return "";
	}
	
	/**
	 * 설명
	 * 
	 * @param model
	 * @param name
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

	@GetMapping("mypage/mytag")
	public String mytag(HttpSession session,Model model) {
		UserDto user = (UserDto) session.getAttribute("user");
		Long hashtagId = user.getHashtagId();
		String mytag = hashtagService.readHashtag(hashtagId);
		model.addAttribute("mytag", user);
		return null;
	}
	
	/**
	 * 설명
	 * 
	 * @param tagName
	 * @param session
	 * @return
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
	 * @param boardId
	 * @param session
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
	 * 설명
	 * 
	 * @param boardId
	 * @param session
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
	 * 설명
	 * 
	 * @param boardId
	 * @param session
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
	 * 설명
	 * 
	 * @param boardId
	 * @param session
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
}

