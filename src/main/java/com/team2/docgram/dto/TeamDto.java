package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** TeamDto.java
 *  
 * 
 * @author 문예빈
 * @since 2022-05-19
 */


@Getter
@Setter
@ToString
public class TeamDto {
	
	private Integer team_pk;
	private Integer rank;
	private Integer dept;
}