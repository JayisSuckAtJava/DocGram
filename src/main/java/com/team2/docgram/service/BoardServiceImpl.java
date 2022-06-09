package com.team2.docgram.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.BoardHashtagDao;
import com.team2.docgram.dao.DeptDao;
import com.team2.docgram.dao.FileDao;
import com.team2.docgram.dao.HashtagDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.BoardHashtagDto;
import com.team2.docgram.dto.DeptDto;
import com.team2.docgram.dto.FileDto;
import com.team2.docgram.dto.HashtagDto;
import com.team2.docgram.dto.UserDto;

/**  BoardServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private BoardHashtagDao boardHashtagDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private HashtagDao hashtagDao;
	
	@Autowired
	private FileDao fileDao;
	
	
	 /**
	 * 설명
	 * 
	 * @param page
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public List<BoardDto> readBoardList(Long page,Long userId) {
		BoardDto board = new BoardDto();
		if(page > 0) {
			page = ( page - 1 ) * 10; 
		}
		board.setStart(page);
		board.setUserId(userId);
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardDao.readBoardList(board);
		return boardList;
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 28.
	 */
	@Override
	public Map<String, Object> readBoard(Long id, Long userId, Long deptId) {
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("userId", userId);
		searchMap.put("deptId", deptId);
		searchMap.put("boardId", id);
		
		BoardDto board = boardDao.readBoard(searchMap);
		
		if(board.getFile() == null) {
			board.setFile(null);
		}else {
			FileDto file = board.getFile();
			String fileName = file.getName();
			Integer underbar = fileName.indexOf("_");
			file.setName(fileName.substring(underbar+1));
			board.setFile(file);
		}
		
		
		
		Long boardId = board.getId();
		List<HashtagDto> hashtagList = new ArrayList<>();
		hashtagList = boardHashtagDao.readList(boardId);
		
		UserDto user = board.getUser();
		Long boardDeptId = user.getDeptId();
		DeptDto dept = deptDao.readDeptList(boardDeptId);
		
		// 만약에 넣는 값이 null 이면 어쩌냐?
		Long[] relationListId = {board.getRelation1(), board.getRelation2(), board.getRelation3()};
		List<BoardDto> relationList = new ArrayList<>();  
		relationList = readRelationList(relationListId);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("board", board);
		map.put("hashtagList", hashtagList);
		map.put("dept", dept);
		map.put("relationList", relationList);
		
		return map;
	}

	/**
	 * 설명
	 * 
	 * @param relationListId
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	private List<BoardDto> readRelationList(Long[] relationListId) {
		List<BoardDto> relationList = new ArrayList<>();
		for(Long i : relationListId) {
			if(i==null) {
				relationList.add(null);
			}else {
				relationList.add(boardDao.readRelationBoard(i));								
			}
		}
		return relationList;
	}

	 /**
	 * 설명
	 * 
	 * @param board
	 * @param hashtagList
	 * @param relatedBoardList
	 * @param fileName
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public String createBoard(BoardDto board, String hashtagList, String relatedBoardList,String fileName) {
		String[] hashtagListArray = hashtagList.split(",");
		String[] relatedBoardListArray = relatedBoardList.split(",");
		Integer relatedListArrayLength = relatedBoardListArray.length;
		
		if(relatedBoardList.equals("")) {
			board.setRelation1(null);
			board.setRelation2(null);
			board.setRelation3(null);
		}else {
			Long rel1 = (relatedListArrayLength >= 1) ? Long.parseLong(relatedBoardListArray[0]) : null;
			Long rel2 = (relatedListArrayLength >= 2) ? Long.parseLong(relatedBoardListArray[1]) : null;
			Long rel3 = (relatedListArrayLength >= 3) ? Long.parseLong(relatedBoardListArray[2]) : null;
			
			board.setRelation1(rel1);
			board.setRelation2(rel2);
			board.setRelation3(rel3);
		}
		if(board.getSecurity() == null) {
			board.setSecurity(1);			
		}
		board = boardDao.createBoard(board);
		Long boardId = board.getId();
		
		Long hashtagListId;
		if (hashtagList.isBlank()) {
			hashtagListId = null;
		}else {
			
			for(String i : hashtagListArray) {
				System.out.println(i);
								
				Long hashtagId = hashtagDao.readHashtag(i);
				
				if(hashtagId == null) {
					HashtagDto hashtag = new HashtagDto();
					hashtag.setName(i);
					hashtag = hashtagDao.createHashtag(hashtag);					
					hashtagId = hashtag.getId();
				}
				
				BoardHashtagDto boardHashtag = new BoardHashtagDto();
				boardHashtag.setBoardId(boardId);
				boardHashtag.setHashtagId(hashtagId);
				boardHashtagDao.createBoardHashtag(boardHashtag);
			}
		}
		
		if(fileName.isBlank()) {
			return null;
		}else {			
			String savedFileName = boardId+"_"+fileName;
			FileDto file = new FileDto();
			file.setName(savedFileName);
			file = fileDao.createFile(file);
			Long fileId = file.getId();
			
			String fileNum = createFileNum(fileId);
			file.setNum(fileNum);
			fileDao.updateFile(file);
			
			board.setFileId(fileId);
			boardDao.updateBoardFile(board);
			return savedFileName;
		}
	}

	/**
	 * 설명
	 * 
	 * @param fileId
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	private String createFileNum(Long fileId) {
		String result = "D";
		String zero = "0";	
		
		for(int i = fileId.toString().length(); i<13 ; i++) {
			result = result + zero;
		}
		String fileNum = result+fileId;
		
		return fileNum;
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 30.
	 */
	@Override
	public Map<String, Object> readBoardOne(Long id) {
		BoardDto board = new BoardDto();
		board = boardDao.readBoardOne(id);

		List<HashtagDto> hashtag = boardHashtagDao.readList(id);
		String hashtagList = "";
		if(hashtag.isEmpty()) {
			hashtagList = null;
		}else {
			for(HashtagDto i : hashtag) {
				hashtagList = hashtagList + i.getName() + ",";
			}
			hashtagList = hashtagList.substring(0, hashtagList.length()-1);
		}
		 

		String relationList = "";
		Long[] relationArray = {board.getRelation1(), board.getRelation2(), board.getRelation3()};
		for(Long i : relationArray) {
			if(i == null) {
				break;
			}else {
				relationList = relationList + i + ",";
			}
		}
		if(relationList == "") {
			
		}else {
			relationList = relationList.substring(0, relationList.length()-1);			
		}

		
		Map<String, Object> map = new HashMap<>();
		map.put("hashtagList", hashtagList);
		map.put("relationList", relationList);
		map.put("board", board);
		
		
		
		return map;
	}

	 /**
	 * 설명
	 * 
	 * @param userId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readStarmarkList(Long userId) {
		return boardDao.readStarmarkList(userId);
	}

	 /**
	 * 설명
	 * 
	 * @param deptId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readDeptmarkList(Long deptId) {
		return boardDao.readDeptmarkList(deptId);
	}

	 /**
	 * 설명
	 * 
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 5. 31.
	 */
	@Override
	public List<BoardDto> readNoticeList() {
		return boardDao.readNoticeList();
	}

	 /**
	 * 설명
	 * 
	 * @param board
	 * @param hashtagList
	 * @param relatedBoardList 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public void boardUpdate(BoardDto board, String hashtagList, String relatedBoardList) {
		Long boardId = board.getId();
		boardHashtagDao.deleteHashtagList(boardId);
		Integer relatedListArrayLength;
		String[] relatedBoardListArray = relatedBoardList.split(",");
		if(relatedBoardList.equals("")) {
			relatedListArrayLength = 0; 
		}else {
			relatedListArrayLength = relatedBoardListArray.length;			
		}
		
		if(relatedListArrayLength == 0) {
			board.setRelation1(null);
			board.setRelation2(null);
			board.setRelation3(null);
		}else {
			Long rel1 = (relatedListArrayLength >= 1) ? Long.parseLong(relatedBoardListArray[0]) : null;
			Long rel2 = (relatedListArrayLength >= 2) ? Long.parseLong(relatedBoardListArray[1]) : null;
			Long rel3 = (relatedListArrayLength >= 3) ? Long.parseLong(relatedBoardListArray[2]) : null;
			
			board.setRelation1(rel1);
			board.setRelation2(rel2);
			board.setRelation3(rel3);
		}		
		
		boardDao.updateBoard(board);
	
		String[] hashtagListArray = hashtagList.split(",");
		Long hashtagListId;
		if (hashtagList.isBlank()) {
			hashtagListId = null;
		}else {
			
			for(String i : hashtagListArray) {
				Long hashtagId = hashtagDao.readHashtag(i);
				
				if(hashtagId == null) {
					HashtagDto hashtag = new HashtagDto();
					hashtag.setName(i);
					hashtag = hashtagDao.createHashtag(hashtag);					
					hashtagId = hashtag.getId();
				}
				
				BoardHashtagDto boardHashtag = new BoardHashtagDto();
				boardHashtag.setBoardId(boardId);
				boardHashtag.setHashtagId(hashtagId);
				Long result = boardHashtagDao.readBoardHashtag(boardHashtag);
				
				if(result == null) {
					boardHashtagDao.createBoardHashtag(boardHashtag);										
				}
				
			}
		}
		
		
	}

	 /**
	 * 설명
	 * 
	 * @param id
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public Long readBoardUserId(Long id) {
		return boardDao.readBoardUserId(id);
	}

	 /**
	 * 설명
	 * 
	 * @param id 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 1.
	 */
	@Override
	public Integer deleteBoard(Long id) {
		return boardDao.deleteBoard(id);
	}

	/**
	 * 설명
	 * 
	 * @param userId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 3.
	 */
	@Override
	public List<BoardDto> readMyBoardList(Long userId) {
		return boardDao.readMyBoardList(userId);
	}

	/**
	 * 설명
	 * 
	 * @param page
	 * @param deptId
	 * @return 
	 *
	 * @author JAY - 이재범
	 * @since 2022. 6. 8.
	 */
	@Override
	public List<BoardDto> readDeptBoardList(Long page, Long deptId, String sel, String text) {
		BoardDto board = new BoardDto();
		UserDto user = new UserDto();
		user.setDeptId(deptId);
		if(page > 0) {
			page = ( page - 1 ) * 10; 
		}
		board.setStart(page);
		board.setUser(user);
		List<BoardDto> boardList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("board", board);
		map.put("sel", sel);
		map.put("text", text);
		boardList = boardDao.readDeptBoardList(map);
		return boardList;
	}
	
}
