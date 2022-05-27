package com.team2.docgram.dao;

import com.team2.docgram.dto.RelatedBoardDto;

public interface RelatedBoardDao {

	String readList(Integer relatedBoard_pk);

	RelatedBoardDto createOne(RelatedBoardDto relatedBoard);

	RelatedBoardDto readBoardList(Integer targetBoard);

	void updateRelated(RelatedBoardDto relatedBoard);


}
