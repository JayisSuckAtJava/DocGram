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
import com.team2.docgram.dto.DeptDto;
import com.team2.docgram.dto.FileDto;
import com.team2.docgram.dto.HashtagDto;
import com.team2.docgram.dto.UserDto;

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
	
	
	@Override
	public List<BoardDto> readBoardList(Long page) {
		BoardDto board = new BoardDto();
		board.setStart(page-1);
		board.setEnd(page*10);
		List<BoardDto> boardList = new ArrayList<>();
		boardList = boardDao.readBoardList(board);
		return boardList;
	}

	@Override
	public Map<String, Object> readBoard(Long id) {
		BoardDto board = boardDao.readBoard(id);
		FileDto file = board.getFile();
		String fileName = file.getName();
		Integer underbar = fileName.indexOf("_");
		file.setName(fileName.substring(underbar+1));
		board.setFile(file);
		
		Long boardId = board.getId();
		List<HashtagDto> hashtagList = new ArrayList<>();
		hashtagList = boardHashtagDao.readList(boardId);
		
		UserDto user = board.getUser();
		Long deptId = user.getDeptId();
		DeptDto dept = deptDao.readDeptList(deptId);
		
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

	@Override
	public String createBoard(BoardDto board, String hashtagList, String relatedBoardList,String fileName) {
		String[] hashtagListArray = hashtagList.split(",");
		System.out.println(hashtagListArray.toString());
		String[] relatedBoardListArray = relatedBoardList.split(",");
		// board 에들어가는 fk = user,file 끝.
		
		if(relatedBoardList == "") {
			board.setRelation1(null);
			board.setRelation2(null);
			board.setRelation3(null);
		}else {
			Long rel1 = Long.parseLong(relatedBoardListArray[0]);
			Long rel2 = Long.parseLong(relatedBoardListArray[1]);
			Long rel3 = Long.parseLong(relatedBoardListArray[2]);
			board.setRelation1(rel1);
			board.setRelation2(rel2);
			board.setRelation3(rel3);
		}
		
		board = boardDao.createBoard(board);
		Long boardId = board.getId();
		
		Long hashtagListId;
		if (hashtagList == "") {
			hashtagListId = null;
		}else {
			
			for(String i : hashtagListArray) {
				System.out.println(i);
				HashtagDto hashtag = new HashtagDto();
				hashtag.setName(i);
				hashtag = hashtagDao.createHashtag(hashtag);
				
				Long hashtagId = hashtag.getId();
				Map<String,Object> map = new HashMap<>();
				map.put("boardId", boardId);
				map.put("hashtagId", hashtagId);
				boardHashtagDao.createBoardHashtag(map);
			}
		}
		
		if(fileName == "") {
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

	private String createFileNum(Long fileId) {
		String result = "D";
		String zero = "0";	
		
		for(int i = fileId.toString().length(); i<13 ; i++) {
			result = result + zero;
		}
		String fileNum = result+fileId;
		
		return fileNum;
	}

	@Override
	public Map<String, Object> readBoardOne(Long id) {
		BoardDto board = new BoardDto();
		board = boardDao.readBoardOne(id);

		List<HashtagDto> hashtag = boardHashtagDao.readList(id);
		String hashtagList = "";
		for(HashtagDto i : hashtag) {
			hashtagList = hashtagList + i.getName() + ",";
		}
		hashtagList = hashtagList.substring(0, hashtagList.length()-1);
		
		
		String relationList = board.getRelation1().toString()+","+board.getRelation2().toString()+","+board.getRelation3().toString(); 
		
		Map<String, Object> map = new HashMap<>();
		map.put("hashtagList", hashtagList);
		map.put("relationList", relationList);
		map.put("board", board);
		
		
		
		return map;
	}

	@Override
	public List<BoardDto> readStarmarkList(Long userId) {
		
		return boardDao.readStarmarkList(userId);
	}

	@Override
	public List<BoardDto> readDeptmarkList(Long deptId) {
		return boardDao.readDeptmarkList(deptId);
	}

	@Override
	public List<BoardDto> readNoticeList() {
		return boardDao.readNoticeList();
	}

	@Override
	public BoardDto readNotice(Long boardId) {
		return boardDao.readNotice(boardId);
	}

	@Override
	public void createNotice(BoardDto board) {
		boardDao.createNotice(board);
	}
	
}
