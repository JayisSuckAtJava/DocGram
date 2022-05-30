package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DeptDto {

	private Long id;
	private String name;
	private Long upperDept;
	private String address;
	private String url;
	private Integer security;
	
	private Long upperStId;
	private String upperStName;
	private Long upperNdId;
	private String upperNdName;
}
