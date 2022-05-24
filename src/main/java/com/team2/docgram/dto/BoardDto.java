package com.team2.docgram.dto;
import java.security.Timestamp;
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
	
	private int board_pk;
	private String title;
	private String content;
	private Timestamp date;
	private Timestamp start_date;
	private Timestamp end_date;
	private int user;
	private int file;
	private int hashtag;
	private UserDto userDetail;
	private FileDto fileDetail;
	private List<HashtagDto> hashtagList;

}

