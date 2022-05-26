package com.team2.docgram.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** FileDto.java
 *  
 * 
 * @author 문예빈
 * @since 2022-05-19
 */


@Getter
@Setter
@ToString
public class FileDto {

	private Integer pk;
	private String file_title;
	private String file_num;
	
}


