package com.team2.docgram.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DeptDto;

/**  SearchService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface SearchService {

	List<BoardDto> searchDetail(String sel, String text, Long position, String fileName, String fileNum,
			String hashtagList, Long dateRange, Date start, Date end);

	Map<String, Object> searchDetail(Map<String, Object> map);

	List<DeptDto> searchDept(String name);

	List<BoardDto> searchRelation(String text, String sel);

}
