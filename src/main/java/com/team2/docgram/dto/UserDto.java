package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;

/** UserDto.java
 *  
 * 
 * @author 문예빈
 * @since 2022-05-19
 */


@Getter
@Setter
public class UserDto {

	private Long user_pk;
	private String name;
	private String id;
	private String name;
	private String password;
	private String phone_num;
	private String dept_num;
	private String email;
	private String starmark;
	private String mytag;
	private int team;
	private String rank;
	private String description;
	private String deptMark;
	
}
