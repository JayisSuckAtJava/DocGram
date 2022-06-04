package com.team2.docgram.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**  BoardDto.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Setter
@Getter
@ToString
public class BoardDto {

	private Long id;
	private String title;
	private String content;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	private Integer security;
	private Long userId;
	private Long fileId;
	private Long relation1;
	private Long relation2;
	private Long relation3;
	
	private FileDto file;
	private UserDto user;
	private Long start;
	private Long starmarkId;
}
