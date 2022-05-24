package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;

/** TeamDto.java
 *  
 * 
 * @author 문예빈
 * @since 2022-05-19
 */


@Getter
@Setter
public class TeamDto {
	
	private Long team_pk;
	private int rank;
	private int dept;
}