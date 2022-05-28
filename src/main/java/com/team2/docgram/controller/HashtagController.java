package com.team2.docgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team2.docgram.service.HashtagService;

@Controller
public class HashtagController {

	@Autowired
	private HashtagService hashtagService;
}
