package com.study.mapper;

import java.util.List;

import com.study.dto.AttachDTO;

public interface AttachMapper {
	//첨부파일 삽입
	public int insert(AttachDTO attach);
	public List<AttachDTO> list(int bno);
}
