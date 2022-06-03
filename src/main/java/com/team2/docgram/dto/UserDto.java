package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**  UserDto.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
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
	private Long hashtagId;
	
	private PositionDto position;
	private DeptDto dept;
	private HashtagDto mytag;
}
