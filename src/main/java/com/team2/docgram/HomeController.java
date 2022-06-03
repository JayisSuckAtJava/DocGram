package com.team2.docgram;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	
	@GetMapping("/create")
	public String test2() {
		return "board/create";
	}
	
	@GetMapping("/dept")
	public String test3() {
		return "board/dept";
	}
	
	@GetMapping("/detail")
	public String test4() {
		return "board/detail";
	}
	
	@GetMapping("/detail1")
	public String test5() {
		return "board/detail1";
	}
	
	@GetMapping("/notice")
	public String test6() {
		return "board/notice";
	}

	
	@GetMapping("notice1")
	public String test7() {
		return "board/notice1";
	}
	
	@GetMapping("/login")
	public String test8() {
		return "login/login";
	}
	
	@GetMapping("/search")
	public String test9() {
		return "read/search";
	}
	
	@GetMapping("/board")
	public String test10() {
		return "admin/board";
	}
	
	@GetMapping("/user")
	public String test11() {
		return "admin/user";
	}
	

	@GetMapping("1main")
	public String test101() {
		return "board/main";
	}
	
	@GetMapping("bootstrapTest")
	public String test102() {
		return "test/bootstrapTest";
	}
	
	@GetMapping("join")
	public String test103() {
		return "login/join";
	}

	@GetMapping("mypage")
	public String test104() {
		return "mypage/mypage";
	}


	@GetMapping("jay/test")
	public String urltest() {
		return "testforurl";
	}
}