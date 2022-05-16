package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> select(Criteria cri);
	public int insert(BoardDTO insertDto);
	public BoardDTO read(int bno);
	public int update(BoardDTO updateDto);
	public int delete(int bno);
	public int totalCnt(Criteria cri);
	public int updateReplyCnt(@Param("bno") int bno,@Param("amount") int amount);
}
