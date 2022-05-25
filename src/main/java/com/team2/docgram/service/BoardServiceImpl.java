package com.team2.docgram.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.DepartmentDao;
import com.team2.docgram.dao.FileDao;
import com.team2.docgram.dao.HashtagDao;
import com.team2.docgram.dao.TeamDao;
import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DepartmentDto;
import com.team2.docgram.dto.FileDto;
import com.team2.docgram.dto.HashtagDto;
import com.team2.docgram.dto.TeamDto;
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
	private DepartmentDao deptDao;
	
	/**
	 * 전체의 게시판 리스트를 조회 - User의 정보를 이용해 team의 정보를 이용해 dept를 알아내고 dept를 like로 구분해 해당부서 게시글 조회
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
		Integer deptNum = team.getDept();
		return boardDao.readBoardList(deptNum);
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

		Integer filePk = board.getFile();
		FileDto file = fileDao.readOne(filePk);
		
		Integer hashtagPk = board.getHashtag();
		String hashtagList = hashtagDao.readList(hashtagPk);
		
		Long userNum = board.getUser();
		UserDto user = userDao.readOne(userNum);
		
		Integer teamNum = user.getTeam();
		
		TeamDto team = teamDao.readOne(teamNum);
		String rank = team.getRank();
		
		Integer deptNum = team.getDept();
		DepartmentDto dept = deptDao.readOne(deptNum);
		
		String description = dept.getDescription();
		
		user.setRank(rank);
		user.setDescription(description);
		
		
		board.setUserDetail(user);
		board.setFileDetail(file);
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
	public String createOne(BoardDto board, String hashtagList, String fileName) {
		String result = "";
		String[] hashtagArray = hashtagList.split(",");
		List<Integer> hashtagPkList = null;
		
		Integer hashtagPK;
		if(hashtagList == "") {
			hashtagPK = null;
		}else {
			for(String i : hashtagArray) {
				hashtagDao.createOne(i);				 
			}
			hashtagPK = hashtagDao.createList(hashtagList);
		}
		
		board.setHashtag(hashtagPK);
		Integer boardPk = boardDao.createOne(board);
		
		Integer fileResult;
		if(fileName == "") {
			fileResult = 0;
		}else {
			String savedFileName = boardPk+"_"+fileName;
			fileResult = fileDao.createOne(fileName);
			
			result = savedFileName;
		}
		return result;
		
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

	
	// user 의 소속 부서 상위에 즐겨찾기
	// user 의 소속 부서 즐겨찾기
	// user 의 즐겨찾기 markList
	// 공지사항 notice List
	// 최근 user 의 소속 부서 에서 작성된 글. - 기본 boardlist

	
	
	
	 /**
	 * user 의 소속 정보로 상위 부서의 즐겨찾기 사항 조회 반환
	 * 
	 * @param user 상위 부서조회를 위한 소속 정보를 조회 위한 user
	 * @return deptUpperStList 해당 상위 부서의 즐겨찾기로 조회된 boardList
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public List<BoardDto> readUpperStBoardList(UserDto user) {
		/*
		 * Integer teamPk = user.getTeam(); TeamDto team = teamDao.readOne(teamPk);
		 * Integer deptPk = team.getDept(); DepartmentDto dept =
		 * deptDao.readOne(deptPk);
		 */
		DepartmentDto dept = readDept(user);
		
		Integer upperDeptPk = dept.getTeamUpperSt();
		DepartmentDto upperDept = deptDao.readOne(upperDeptPk);
		String upperDeptStarMark = upperDept.getStarMark();
		String[] upperDpetBoardList = upperDeptStarMark.split(",");
		
		List<BoardDto> deptUpperStList = new ArrayList<>();
		
		for(String i : upperDpetBoardList) {
			Integer boardPk = Integer.parseInt(i);
			deptUpperStList.add(boardDao.readOne(boardPk));
		}
		
		return deptUpperStList;
	}
	
	/**
	 * user 의 소속 정보로 즐겨찾기 사항 조회 반환
	 * 
	 * @param user 소속 정보를 조회 위한 user
	 * @return depttList 해당 부서의 즐겨찾기로 조회된 boardList
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public List<BoardDto> readDeptBoardList(UserDto user) {
		/*
		 * Integer teamPk = user.getTeam(); TeamDto team = teamDao.readOne(teamPk);
		 * Integer deptPk = team.getDept(); DepartmentDto dept =
		 * deptDao.readOne(deptPk);
		 */
		DepartmentDto dept = readDept(user);
		
		String deptStarMark = dept.getStarMark();
		String[] deptBoardList = deptStarMark.split(",");

		List<BoardDto> deptList = new ArrayList<>();

		for(String i : deptBoardList) {
			Integer boardPk = Integer.parseInt(i);
			deptList.add(boardDao.readOne(boardPk));
		}
		return deptList;
	}

	 /**
	 * user 의 즐겨찾기 목록을 조회-반환
	 * 
	 * @param user 즐겨찾기 목록을 조회위한 user
	 * @return starMarkList 즐겨찾기 목록으로 조회된 boardList
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public List<BoardDto> readStarMarkList(UserDto user) {
		String starMark = user.getStarmark();
		String[] starMarkArray = starMark.split(",");
		
		List<BoardDto> starMarkList = new ArrayList<>();
		
		for(String i : starMarkArray) {
			Integer boardPk = Integer.parseInt(i);
			starMarkList.add(boardDao.readOne(boardPk));
		}
		return starMarkList;
	}

	 /**
	 * 공지사항 조회-반환
	 * 
	 * @return 작성된 공지사항 boardList
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public List<BoardDto> readNoticeList() {
		return boardDao.readNoticeList();
	}

	/**
	 *  사용자의 정보를 이용하여 소속 부서 객체 반환
	 * 
	 * @param user 소속 정보 조회를 위한 user
	 * @return dept 해당 유저가 소속한 부서
	 */
	public DepartmentDto readDept(UserDto user) {
		Integer teamPk = user.getTeam();
		TeamDto team = teamDao.readOne(teamPk);
		Integer deptPk = team.getDept();
		DepartmentDto dept = deptDao.readOne(deptPk);
		
		return dept;
	}

	
}
