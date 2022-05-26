package com.team2.docgram.dto;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

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
	
	private Integer pk;
	private String title;
	private String content;
	private java.sql.Date date;
	private Integer user;
	private int boardSecurity;
	private UserDto userDetail;
	private FileDto fileDetail;
	private Integer file;
	private Long relatedBoard;
	private Integer hashtagList_pk;
	private String userName;
	private String deptDescription;
	private String hashtagList;
}

