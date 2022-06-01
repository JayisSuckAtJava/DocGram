package com.team2.docgram.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.team2.docgram.dao.FileDao;
import com.team2.docgram.dto.FileDto;

/**  FileServiceImpl.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDao fileDao;

	private String root = "C:\\ProjectTeam2\\file\\";
	
	/** 파일을 Root 에 저장하는 메소드
	 * 
	 * @param savedFileName 저장할 파일명 ( service에서 처리 후 넘어옴 )
	 * @param file 업로드 한 실체 파일
	 *
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public void createFile(String savedFileName,MultipartFile file) {
		File path = new File(root+savedFileName);
		
		try {
			file.transferTo(path);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			System.out.println(" 파일 저장에 실패 하였습니다. ");
		}
	}

	/** 입력받은 file의 PK로 해당 객체 조회 후 download 메소드 사용 파일 다운로드 객체 리턴
	 * 
	 * @param filePk file의 저장 이름 조회를 위한 FILE 객체 PK 
	 * @return ResponseEntity 해당 파일의 다운로드
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public ResponseEntity<Resource> readFile(Long fileId) {
		FileDto file = fileDao.readFile(fileId);
		String fileName = file.getName();
		
		try {
			return download(fileName);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** FileName으로 Root 에 저장된 file 다운로드
	 * 
	 * @param fileName 저장된 file명으로 조회하여 파일 생성
	 * @return ResponseEntity 를 리턴하여 바로 다운로드 받을수 있게 함
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	private ResponseEntity<Resource> download(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		
		File file = new File(root+fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		Integer underbar = fileName.indexOf("_");
		String fileOriginalName = fileName.substring(underbar+1);
		return ResponseEntity.ok().header("content-disposition","filename=" + URLEncoder.encode(fileOriginalName, "utf-8"))
				 .contentLength(file.length())
				 .contentType(MediaType.parseMediaType("application/octet-stream"))
				 .body(resource);
	}
	
	
}
