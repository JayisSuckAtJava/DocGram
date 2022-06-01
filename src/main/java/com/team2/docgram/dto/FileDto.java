package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**  FileDto.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Setter
@Getter
@ToString
public class FileDto {

	private Long id;
	private String name;
	private String num;
}
