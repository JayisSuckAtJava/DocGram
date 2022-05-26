package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** DepartmentDto.java
 *  부서 Dto
 * 
 * @author 문예빈
 * @since 2022-05-19
 */

@Getter
@Setter
@ToString
public class DepartmentDto {
	
	private Long dept_pk;
	private String description;
	private int teamUpperSt;
	private String starMark;
	private String address;
	private String url;
	private int deptSecurity;

}

