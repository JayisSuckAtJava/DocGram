package com.team2.docgram.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.DeptDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DeptDto;

/**  SearchServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<BoardDto> searchDetail(String sel, String text, Long position, String fileName, String fileNum,
			String hashtagList, Long dateRange, Date start, Date end) {
		Map<String, Object> map = new HashMap<>();
		
		if(hashtagList == null) {
			
		}else {
			String[] hashtagArray = hashtagList.split(",");
			map.put("hashtagList", hashtagArray);			
		}
		
		
		map.put("key", sel);
		map.put("text", text);
		map.put("postion", position);
		map.put("fileName", fileName);
		map.put("fileNum", fileNum);
		
		
		return boardDao.searchDetail(map);
	}

	/**
	 * 상세 정보 검색 - 데이터 처리 로직
	 * 
	 * @param map 검색 조건이 담긴 map
	 * @return 검색된 데이터 + 해당 데이터의 총 갯수
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 2.
	 */
	@Override
	public Map<String, Object> searchDetail(Map<String, Object> map) {
		
		if (map.get("hashtagList") == null || map.get("hashtagList").equals("")) {
			map.put("hashtagList", null);
		}else {
			String hashtagList = (String) map.get("hashtagList");
			String[] hashtagArray = hashtagList.split(",");
			map.put("hashtagList", hashtagArray);
		}
		if(map.get("dateRange") == null || map.get("dateRange").equals("null")) {
			map.put("start", null);
			map.put("end", null);
			map.put("dateRange", null);
		}else { 
			Long dateRange = Long.parseLong((String) map.get("dateRange"));
			if(dateRange == 999) { 
				map.put("dateRange", null);
			}else {
				map.put("start", null);
				map.put("end", null);
			}
		}
		if(map.get("page") == null || map.get("page").equals("")) {
			Long page = 0L;
			map.put("page", page);
		}else {
			Long page = Long.parseLong((String) map.get("page"));
			page = ( page - 1 ) * 10;
			map.put("page", page);
		}
		if(map.get("text") == null || map.get("text").equals("")) {
			map.put("text", null);
			map.put("sel", null);
		}
		if(map.get("position") == null || map.get("position").equals("null")) {
			map.put("position", null);
		}
		if(map.get("fileName") == null || map.get("fileName").equals("")) {
			map.put("fileName", null);
		}
		if(map.get("fileNum") == null || map.get("fileNum").equals("")) {
			map.put("fileNum", null);
		}
		List<BoardDto> boardList = new ArrayList<>();
		
		
		boardList = boardDao.searchDetail(map);
		Long listSize = boardDao.searchDetailSize(map);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("listSize", listSize);
		resultMap.put("boardList", boardList);
		
		System.out.println(map);
		System.out.println(resultMap);
		
		map.forEach((strKey, value)->{
			System.out.println(strKey + " : key and    value :" + value);
			System.out.println(map.get(strKey) == null);
		});
		return resultMap;
	}

	/**
	 * 소속 부서 검색 로직
	 * 
	 * @param name 해당 부서의 이름 또는 이름에 포함된 단어
	 * @return 검색된 Dept 객체의 List
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@Override
	public List<DeptDto> searchDept(String name) {
		return deptDao.searchDept(name);
	}

	/**
	 * 연관 게시글 검색 로직
	 * 
	 * @param text 검색될 텍스트
	 * @param sel 검색될 테스트의 종류를 선택하는 sel 
	 * @return 검색되어진 board 객체의 List
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 7.
	 */
	@Override
	public List<BoardDto> searchRelation(String text, String sel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		map.put("sel", sel);
		return boardDao.searchRelation(map);
	}

	/**
	 * 설명
	 * 
	 * @param page
	 * @param userId
	 * @param sel
	 * @param text
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<BoardDto> readBoardList(Long page, Long userId, String sel, String text) {
		if(page > 0) {
			page = ( page - 1 ) * 10; 
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		map.put("sel", sel);
		map.put("userId", userId);
		map.put("page", page);
		return boardDao.readBoardList(map);
	}
	

}
