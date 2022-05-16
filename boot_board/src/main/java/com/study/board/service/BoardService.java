package com.study.board.service;

import java.util.List;

import com.study.board.dto.AttachDTO;
import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);
	public void insert(BoardDTO insertDto);
	public BoardDTO getRow(int bno);
	public boolean update(BoardDTO updateDto);
	public boolean delete(int bno);
	public int getTotalCnt(Criteria cri);
	
	//첨부파일
	public List<AttachDTO> attachList(int bno);
}
