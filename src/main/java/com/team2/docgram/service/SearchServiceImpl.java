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
		
		if(map.get("hashtagList") == null) {
		}else {
			String hashtagList = (String) map.get("hashtagList");
			String[] hashtagArray = hashtagList.split(",");
			map.put("hashtagList", hashtagArray);
		}
		if(map.get("dateRange") == null) {
			map.put("start", null);
			map.put("end", null);			
		}else { // dateRange 지정 함
			Long dateRange = Long.parseLong((String) map.get("dateRange"));
			if(dateRange == 999) { // 개별지 하기로 선택 함
				map.put("dateRange", null);
			}else {
				map.put("start", null);
				map.put("end", null);
			}
		}
		if(map.get("page") == null) {
			map.put("page", 0);
		}else {
			Long page = Long.parseLong((String) map.get("page"));
			page = ( page - 1 ) * 10;
			map.put("page", page);
		}
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardDao.searchDetail(map);
		Long listSize = boardDao.searchDetailSize(map);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("listSize", listSize);
		resultMap.put("boardList", boardList);
		
		
		return resultMap;
	}

	@Override
	public List<DeptDto> searchDept(String name) {
		return deptDao.searchDept(name);
	}

	@Override
	public List<BoardDto> searchRelation(String text, String sel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		map.put("sel", sel);
		return boardDao.searchRelation(map);
	}
	

}
