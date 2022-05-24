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

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDao fileDaoImpl;

	private String root = "C:\\ProjectTeam2\\file\\";
	
	@Override
	public void createOne(String savedFileName,MultipartFile file) {
		File path = new File(root+savedFileName);
		
		try {
			file.transferTo(path);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			System.out.println(" 파일 저장에 실패 하였습니다. ");
		}
	}

	@Override
	public ResponseEntity<Resource> readOne(Integer filePk) {
		FileDto file =fileDaoImpl.readOne(filePk);
		String fileName = file.getFile_title();
		
		try {
			return download(fileName);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

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
