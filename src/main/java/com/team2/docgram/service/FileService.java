package com.team2.docgram.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**  FileService.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface FileService {

	void createFile(String savedFileName, MultipartFile file);

	ResponseEntity<Resource> readFile(Long fileId);

}
