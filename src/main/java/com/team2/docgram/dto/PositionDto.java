package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PositionDto {

	private Long id; 
	private String name;
	private Integer security;
}
