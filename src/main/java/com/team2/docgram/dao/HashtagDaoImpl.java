package com.team2.docgram.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** HashtagDaoImpl.java
 *   해시태그 DB에 연결되는 DAO 객체 구현체
 * 
 * @author JAY - 이재범
 * @since 2022-05-19
 */
@Repository
public class HashtagDaoImpl implements HashtagDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String mapper = "hashtag.";

	
	/** 입력받은 hashtagList를
	 *  // ++ 강사님은 쿼리문 서브퀴리나 sql 분리 같은건 나중에 기능 발전에 투자하길 바라십.
	 * @param
	 * @return
	 *
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public Integer createList(String hashtagList) {
		return sqlSession.insert(mapper+"", hashtagList);
	}


	/** 
	 *  Hashtag 테이블에 입력받은 hashtag를 insert
	 * 
	 *@param tag_name 해당 태그 이름
	 *
	 *@author JAY - 이재범
	 *@since 2022-05-24
	 */
	@Override
	public void createOne(String tag_name) {
		sqlSession.insert(mapper+"", tag_name);
	}


	 /**
	 * board에 저장된 pk 로 hashtagList 반환
	 * 
	 * @param hashtagNum board 에서 가져온 fk
	 * @return 해당 hashtagList ( String )
	 * 
	 * @author JAY - 이재범
	 * @since 2022-05-24
	 */
	@Override
	public String readList(Integer hashtagNum) {
		return sqlSession.selectOne(mapper+"readHashtagList", hashtagNum);
	}
	
	
	
	
	
	

}
