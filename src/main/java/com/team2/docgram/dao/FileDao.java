package com.team2.docgram.dao;

import com.team2.docgram.dto.FileDto;

public interface FileDao {

	FileDto readFile(Long fileId);

	FileDto createFile(FileDto file);

	void updateFile(FileDto file);

}
