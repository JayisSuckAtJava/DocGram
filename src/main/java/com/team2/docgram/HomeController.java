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

	@GetMapping("/header")
	public String test() {
		return "comp/header";
	}
	
	@GetMapping("/footer")
	public String test1() {
		return "comp/footer";
	}
	
	@GetMapping("/create")
	public String test2() {
		return "board/create";
	}
	
	@GetMapping("/detail")
	public String test3() {
		return "board/detail";
	}
	
	@GetMapping("/popup")
	public String test4() {
		return "board/popup";
	}
	
	@GetMapping("/update")
	public String test5() {
		return "board/update";
	}

	
	@GetMapping("login")
	public String test6() {
		return "login/login";
	}
	
	@GetMapping("/detail1")
	public String test7() {
		return "read/detail";
	}
	
	@GetMapping("/popup1")
	public String test9() {
		return "test/popup";
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


}