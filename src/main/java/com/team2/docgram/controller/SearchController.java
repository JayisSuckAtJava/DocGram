package com.team2.docgram.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	@PostMapping("/search")
	public String searchDetail(@RequestParam Map<String,String> map) {
		
		return "search";
		
	}
}
