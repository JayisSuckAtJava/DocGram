package com.team2.docgram.dto;
import java.security.Timestamp;
import lombok.Getter;
import lombok.Setter;

/** BoardDto.java
 *  게시판 Dto
 * 
 * @author 문예빈
 * @since 2022-05-19
 */

@Getter
@Setter
public class BoardDto {
	
	private Long board_pk;
	private String title;
	private String content;
	private Timestamp date;
	private int boardSecurity;
	private Long user;
	private Long file;
	private Long relatedBoard;
	private Long board_hashtagList;
	

}

