package com.study.mapper;

import java.util.List;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;

public interface BoardMapper {
	public List<BoardDTO> select(Criteria cri);
	public int insert(BoardDTO insertDto);
	public BoardDTO read(int bno);
	public int update(BoardDTO updateDto);
	public int delete(int bno);
	public int totalCnt(Criteria cri);
}
