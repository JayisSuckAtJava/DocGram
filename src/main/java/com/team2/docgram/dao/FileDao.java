package com.team2.docgram.dao;

import com.team2.docgram.dto.FileDto;

public interface FileDao {

	Integer createOne(String fileName);

	FileDto readOne(Integer filePk);

	void updateFile_num(String file_num);

}
