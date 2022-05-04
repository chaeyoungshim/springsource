package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;

public interface ReplyMapper {
	public int insert(ReplyDTO insertDto);
	public ReplyDTO read(int rno);
	public int update(ReplyDTO updateDto);
	public int delete(int rno);
	public List<ReplyDTO> select(@Param("cri") Criteria cri,@Param("bno") int bno);
	public int getCountBno(int bno);
}
