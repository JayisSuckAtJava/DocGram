package com.team2.docgram.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**  UserStarmarkDto.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Setter
@Getter
@ToString
public class UserStarmarkDto {

	private Long id;
	private Long userId;
	private Long boardId;
}
