package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDto {

	private Long id;
	private String email;
	private String name;
	private String password;
	private String phoneNumber;
	private String deptNumber;
	private Long positionId;
	private Long deptId;
	
	private PositionDto position;
	private DeptDto dept;
}
