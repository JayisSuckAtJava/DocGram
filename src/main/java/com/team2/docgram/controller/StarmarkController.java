package com.team2.docgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team2.docgram.service.StarmarkService;

@Controller
public class StarmarkController {

	@Autowired
	private StarmarkService starmarkService;
}
