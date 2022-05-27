package com.team2.docgram.dao;

import com.team2.docgram.dto.HashtagTableDto;

public interface HashtagDao {

	HashtagTableDto createList(HashtagTableDto hashtagTable);

	void createOne(String description);

	String readList(Integer hashtagNum);


}
