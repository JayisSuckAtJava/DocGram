package com.team2.docgram.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	void createOne(String savedFileName, MultipartFile file);

	ResponseEntity<Resource> readOne(Integer filePk);

}
