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
	
	@GetMapping("sdsd")
	public String test() {
		return "detailsearch";
	}
	
	@GetMapping("/sdsd2")
	public String test2() {
		return "header";
	}
	
	@GetMapping("/sdsd3")
	public String test3() {
		return "footer";
	}
	
	@GetMapping("/sdsd4")
	public String test4() {
		return "documentview";
	}
	
	@GetMapping("/loginmain")
	public String test5() {
		return "loginmain";
	}
	
	@GetMapping("/page")
	public String test6() {
		return "page";
	}
	
	@GetMapping("/write")
	public String test7() {
		return "write";
	}
	
	@GetMapping("/popup")
	public String test8() {
		return "popup";
	}

	@GetMapping("main")
	public String test101() {
		return "board/main";
	}
	
	@GetMapping("bootstrapTest")
	public String test102() {
		return "test/bootstrapTest";
	}
	
	@GetMapping("signup")
	public String test103() {
		return "test/signup";
	}
	
	@GetMapping("dept_popup")
	public String test104() {
		return "test/dept_popup";
	}
	
}

