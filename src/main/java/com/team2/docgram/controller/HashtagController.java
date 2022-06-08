package com.team2.docgram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.docgram.dto.HashtagDto;
import com.team2.docgram.service.HashtagService;

/**  HashtagController.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Controller
public class HashtagController {

	@Autowired
	private HashtagService hashtagService;
	
	@GetMapping("admin/board/{id}")
	@ResponseBody
	public List<HashtagDto> updateHashtag(@PathVariable("id")Long id) {
		List<HashtagDto> hashtagList = new ArrayList<>();
		hashtagList = hashtagService.readHashtagList(id);
		return hashtagList;
	}
}
