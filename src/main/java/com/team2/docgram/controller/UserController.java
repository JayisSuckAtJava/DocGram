package com.team2.docgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team2.docgram.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
}
