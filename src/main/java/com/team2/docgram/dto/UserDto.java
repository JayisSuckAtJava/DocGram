package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** UserDto.java
 *  
 * 
 * @author 문예빈
 * @since 2022-05-19
 */


@Getter
@Setter
@ToString
public class UserDto {

	private Integer pk;
	private String name;
	private String id;
	private String password;
	private String phone_num;
	private String dept_num;
	private String email;
	private String starmark;
	private String mytag;
	private String rank;
	private String description;
	private String deptMark;
	private Integer team;
	private String userDept; 
	private String userDeptUpperSt;
	private String userDeptUpperNd;
	
	
}
