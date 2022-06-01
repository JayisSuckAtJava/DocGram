package com.team2.docgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team2.docgram.service.StarmarkService;

/**  StarmarkController.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class StarmarkController {

	@Autowired
	private StarmarkService starmarkService;
}
