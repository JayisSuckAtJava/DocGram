package com.team2.docgram.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.DepartMentDao;
import com.team2.docgram.dao.FileDao;
import com.team2.docgram.dao.HashtagDao;
import com.team2.docgram.dao.TeamDao;
import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.UserDto;

/** BoardServiceImpl.java
 *   Service 구현 객체 - Board의 로직처리 , DAO 객체와의 연결 다리
 * @author JAY - 이재범
 * @since 2022-05-18
 */
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private HashtagDao hashtagDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private DepartMentDao deptDao;
	
	
	/**
	 * 전체의 게시판 리스트를 조회
	 * 
	 * @param user 리스트 분류를 위한 user- 소속 정보에 따른 조회 검색 변경
	 * @return 정보에 따른 검색 정보 목록.
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public List<BoardDto> readBoardList(UserDto user) {
		Integer teamNum = user.getTeam();
		TeamDto team = teamDao.readOne(teamNum);
		Integer deptNum = teamDao.getDepartMent();
		return boardDao.readBoardList(dept);
	}

	/**
	 * 한개의 게시글 조회 + 작성자 정보 통합 전달
	 * 
	 * @param num 해당 Board 의 PK
	 * @return
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public BoardDto readOne(Integer num) {
		
		BoardDto board = boardDao.readOne(num);
		
//		Integer fileNum = boardDao.getFile();
//		FileDto file = fileDao.readOne(fileNum);
//		
//		Integer hashtagNum = boardDao.getHashtag();
//		List<HashtagDto> hashtag = hashtagDao.readList(hashtagNum);
		FileDto file = readFileByBoardNum(num);
		List<Hashtag> hashtagList = readHashtagByBoardNum(num);
		
		Integer userNum = board.getUser();
		UserDto user = userDao.readOne(userNum);
		UserDto userDetail = readTeamAndDept(user);
		/*
		 * String name = user.getName(); String dept_num = user.getDept_num(); //Integer
		 * teamNum = user.getTeam();
		 * 
		 * TeamDto team = teamDao.readOne(teamNum); String rank = team.getRank();
		 * 
		 * Integer deptNum = team.getDept(); DepartmentDto dept =
		 * deptDao.readOne(deptNum); String description = dept.getDescription();
		 */
		
		board.setUserDeatil(userDeatil);
		board.setFileDeatil(file);
		board.setHashtagList(hashtagList);
		
		return board;
	}


	/**
	 * 게시글 작성 Board 객체를 받아 DB 에 저장
	 * 
	 * @param board 컨트롤러로 변환되어 전달받은 BoardDto
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void createOne(BoardDto board) {
		boardDao.createOne(board);
		
	}


	/**
	 * 게시글 수정 Board 객체를 받아 DB 에 변동
	 * 
	 * @param board 게시글의 정보를 담은 Board 객체
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void updateOne(BoardDto board) {
		boardDao.updateOne(board);
	}


	/**
	 * 게시글 삭제를 위해 PK 를 받아 DB 에 지정 삭제
	 * 
	 * @param 구분을 위한 Board 의 PK 값
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-18
	 */
	@Override
	public void deleteOne(Integer num) {
		boardDao.deleteOne(num);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public FileDto readFileByBoardNum(Integer num) {
		Integer fileNum = boardDao.getFile(num);
		FileDto file = fileDao.readOne(fileNum);
		return file;
	}
	
	public List<HashtagDto> readHashtagByBoardNum(Integer num) {
		Integer hashtagNum = boardDao.getHashtag(num);
		List<HashtagDto> hashtagList = hashtagDao.readList(hashtagNum);
		return hashtagList;
	}
	
	public UserDto readTeamAndDept(UserDto user) {;
		String dept_num = user.getDept();
		Integer teamNum = user.getTeam();
		
		TeamDto team = teamDao.readOne(teamNum);
		String rank = team.getRank();
		
		DepartmentDto dept = deptDao.readOne(deptNum);
		String description = dept.getDescription();
		String deptMark = dept.getStarMark();
		
		user.setRank(rank);
		user.setDescription(description);
		user.setDeptMark();
		
		return user;
	}

	
}
