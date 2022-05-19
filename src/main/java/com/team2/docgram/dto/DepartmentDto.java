package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;

/** DepartmentDto.java
 *  부서 Dto
 * 
 * @author 문예빈
 * @since 2022-05-19
 */

@Getter
@Setter
public class DepartmentDto {
	
	private int dept_pk;
	private String description;
	private int teamUpperSt;
	private String starMark;
	private String address;
	private String url;
}
