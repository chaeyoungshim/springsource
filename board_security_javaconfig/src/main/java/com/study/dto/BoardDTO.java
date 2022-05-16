package com.study.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	private int replycnt;
	
	//첨부파일 정보
	private List<AttachDTO> attachList;
}
