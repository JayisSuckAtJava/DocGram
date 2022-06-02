package com.team2.docgram;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class searchDto {
	String sel;
	String text;
	Long position;
	String fileName;
	String fileNum;
	String[] hashtagList;
	Long dateRange;
	Date start;
	Date end;
}