package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardHashtagDto {

	private Long id;
	private Long boardId;
	private Long hashtagId;
}
