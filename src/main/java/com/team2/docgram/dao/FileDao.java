package com.team2.docgram.dao;

import com.team2.docgram.dto.FileDto;

/**  FileDao.java
 *   설명
 * 
 * @author JAY - 이재범
 * @since 2022. 5. 28.
 */
public interface FileDao {

	FileDto readFile(Long fileId);

	FileDto createFile(FileDto file);

	void updateFile(FileDto file);

}
