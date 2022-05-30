package com.team2.docgram.service.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.docgram.dao.BoardDao;
import com.team2.docgram.dao.DepartmentDao;
import com.team2.docgram.dao.FileDao;
import com.team2.docgram.dao.HashtagDao;
import com.team2.docgram.dao.RelatedBoardDao;
import com.team2.docgram.dao.TeamDao;
import com.team2.docgram.dao.UserDao;
import com.team2.docgram.dto.BoardDto;
import com.team2.docgram.dto.DepartmentDto;
import com.team2.docgram.dto.FileDto;
import com.team2.docgram.dto.HashtagTableDto;
import com.team2.docgram.dto.RelatedBoardDto;
import com.team2.docgram.dto.TeamDto;
import com.team2.docgram.dto.UserDto;

/** BoardServiceImpl.java
 *   Service 구현 객체 - Board의 로직처리 , DAO 객체와의 연결 다리
 * @author JAY - 이재범
 * @since 2022-05-18
 */

public class BoardServiceImpl implements BoardService {
/*	
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
	
	@Autowired
	private RelatedBoardDao relatedDao;
	*/
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
		/*
		 * Integer teamNum = user.getTeam(); TeamDto team = teamDao.readOne(teamNum);
		 * Integer deptNum = team.getDept();
		 */
		
		return boardDao.readBoardList();
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
	public BoardDto readOne(Integer pk) {
		// null 로나옴
		
		BoardDto board = boardDao.readOne(pk);
		
		Integer filePk = board.getFile(); 
		FileDto file = fileDao.readOne(filePk);
		
		String originalFileTitle = file.getFile_title();
		Integer underbar = originalFileTitle.indexOf("_");
		String file_title = originalFileTitle.substring(underbar+1);
		file.setFile_title(file_title);
		
		Integer hashtagPk = board.getHashtagList_pk(); 
		String hashtagList = hashtagDao.readList(hashtagPk);
		 		
		Integer userNum = board.getUser();
		UserDto user = userDao.readOne(userNum);
		
		Integer teamNum = user.getTeam();
		
		TeamDto team = teamDao.readOne(teamNum);
		Integer rank = team.getRank();
		
		String rankDes = rankIs(rank);
		user.setRank(rankDes);
		
		Integer relatedBoard_pk = board.getRelatedBoard();
		String relatedString = relatedDao.readList(relatedBoard_pk);
		String[] relatedList = relatedString.split(","); 
		List<BoardDto> relatedBoardList = new ArrayList<>();
		
		for(String i : relatedList) {
			Integer j = Integer.parseInt(i);
			BoardDto result = boardDao.readRelatedBoard(j);
			relatedBoardList.add(result); 			
		}
		
		Integer deptNum = team.getDept();
		
		UserDto deptDetail = deptDao.readDeptList(deptNum);
		
		user.setUserDept(deptDetail.getUserDept());
		user.setUserDeptUpperSt(deptDetail.getUserDeptUpperSt());
		user.setUserDeptUpperNd(deptDetail.getUserDeptUpperNd());
		
		String hashtagListDetail = hashtagListIs(hashtagList);
		
		board.setUserDetail(user);
		board.setFileDetail(file);
		board.setHashtagList(hashtagListDetail);
		board.setRelatedBoardList(relatedBoardList);
		
		return board;
	}
	
	public String hashtagListIs(String hashtagList) {
		String proc = hashtagList.replace(",", "</tag> #<tag>");		
		String hashtagListDetail="#<tag>"+proc+"</tag>";		
		
		return hashtagListDetail;
	}
	
	
	public String rankIs(Integer rank) {
		String rankDes="";
		
		switch (rank) {
		case 1:
			rankDes = "서기보";
			break;
		case 2:
			rankDes = "서기";
			break;
		case 3:
			rankDes = "주사보";
			break;
		case 4:
			rankDes = "주사";
			break;
		case 5:
			rankDes = "사무관";
			break;
		case 6:
			rankDes = "서기관";
			break;
		case 7:
			rankDes = "부이사관";
			break;
		case 8:
			rankDes = "이사관";
			break;
		case 9:
			rankDes = "관리관";
			break;

		default:
			break;
		}
		return rankDes;
	}


	/**
	 * 게시글 작성 Board 객체를 받아 DB 에 저장
	 * 
	 * @param board 컨트롤러로 변환되어 전달받은 BoardDto
	 * 
	 * @author JAY - 이재범
	 * @return 
	 * @since 2022-05-18
	 */
	@Override
	public void createOne(BoardDto board, String hashtagList,String relatedBoardList) {
		//hash 태그,태그,태그
		String[] hashtagArray = hashtagList.split(",");
				
		Integer hashtagListPK;
		if(hashtagList == "") {
			hashtagListPK = null;
		}else {
			for(String i : hashtagArray) {
				hashtagDao.createOne(i);				 
			}			
			hashtagListPK = createHashtagTable(hashtagList);
		}
		
		Integer relatedBoardPk;
		if(relatedBoardList == "") {
			relatedBoardPk = null;
		}else {
			relatedBoardPk = createRelatedBoard(relatedBoardList);
		}
		
		board.setRelatedBoard(relatedBoardPk);
		board.setHashtagList_pk(hashtagListPK);
		board = boardDao.createOne(board);
		Integer boardPk = board.getPk();
		
		updateInclude(boardPk, relatedBoardList);
	}


	@Override
	public String createOneAndFile(BoardDto board, String hashtagList, String fileName,String relatedBoardList) {
		String result = "";
		String[] hashtagArray = hashtagList.split(",");
		
		Integer hashtagListPK;
		if(hashtagList == "") {
			hashtagListPK = null;
		}else {
			for(String i : hashtagArray) {
				hashtagDao.createOne(i);				 
			}
			hashtagListPK = createHashtagTable(hashtagList);
		}
		
		Integer relatedBoardPk;
		if(relatedBoardList == "") {
			relatedBoardPk = null;
		}else {
			relatedBoardPk = createRelatedBoard(relatedBoardList);
		}
		
		board.setRelatedBoard(relatedBoardPk);
		board.setHashtagList_pk(hashtagListPK);
		board = boardDao.createOne(board);
		Integer boardPk = board.getPk();
		
		updateInclude(boardPk, relatedBoardList);
		
		Integer fileResult;
		if(fileName == "") {
			fileResult = 0;
		}else {
			String savedFileName = boardPk+"_"+fileName;
			fileResult = fileDao.createOne(fileName);
			String file_num = createFileNum(fileResult);
			fileDao.updateFile_num(file_num);
			
			result = savedFileName;
		}
			boardDao.updateFile(fileResult);
		
		return result;
	}
	
	public Integer createRelatedBoard(String relatedBoardList) {
		RelatedBoardDto relatedBoard = new RelatedBoardDto();
		
		relatedBoard.setBoardList(relatedBoardList);
		relatedBoard = relatedDao.createOne(relatedBoard);
		
		Integer relatedBoardPk = relatedBoard.getPk();
		return relatedBoardPk;
		
	}
	
	public Integer createHashtagTable(String hashtagList) {
		HashtagTableDto hashtagTable = new HashtagTableDto();
		
		hashtagTable.setHashtagList(hashtagList);
		hashtagTable = hashtagDao.createList(hashtagTable);
		
		Integer hashtagTablePk = hashtagTable.getPk();
		return hashtagTablePk;
		
	}
	
	public String createFileNum(Integer filePk) {
		String result = "D";
		String zero = "0";	
		
		for(int i = filePk.toString().length(); i<13 ; i++) {
			result = result + zero;
		}
		String file_num = result+filePk;
		
		return file_num;
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
	public void deleteOne(Integer pk) {
		boardDao.deleteOne(pk);
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

	@Override
	public List<BoardDto> searchList(String key, String text) {
		List<BoardDto> boardList = new ArrayList<>();
		
		switch (key) {
		case "title":
			boardList = boardDao.searchByTitle(text);
			break;
		case "content":
			boardList = boardDao.searchByContent(text);
			break;
		case "name":
			boardList = boardDao.searchByName(text);
			break;
		case "dept":
			boardList = boardDao.searchByDept(text);
			break;

		default:
			boardList = null;
			break;
		}
		return null;
	}

	@Override
	public void updateInclude(Integer boardPk,String relatedboardList) {
		
		String[] relatedArray = relatedboardList.split(",");
		String resultList;
		for(String i : relatedArray) {
			Integer targetBoard = Integer.parseInt(i);
			// 해당 board 의 rel list 를 읽어와서 없으면 만들어주고 있으면 가져온걸 수정해서 업데이트
			
			RelatedBoardDto relatedBoard = relatedDao.readBoardList(targetBoard);
			
			String list = relatedBoard.getBoardList();
			if(relatedBoard.getPk() == null) {
				relatedBoard.setBoardList(boardPk.toString());
				relatedBoard = relatedDao.createOne(relatedBoard);
				Integer relatedPk = relatedBoard.getPk(); 
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("boardPk", targetBoard);
				map.put("relatedBoard", relatedPk);
				boardDao.updateRelated(map);
			}else {
				String targetList = relatedBoard.getBoardList()+","+boardPk.toString();
				relatedBoard.setBoardList(targetList);
				relatedDao.updateRelated(relatedBoard);
			}
		}
	}

	
}