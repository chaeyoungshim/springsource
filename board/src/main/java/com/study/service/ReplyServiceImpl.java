package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;
import com.study.dto.ReplyPageDTO;
import com.study.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public boolean replyInsert(ReplyDTO insertDto) {
		return mapper.insert(insertDto)==1?true:false;
	}

	@Override
	public ReplyDTO replyRow(int rno) {
		return mapper.read(rno);
	}

	@Override
	public boolean replyUpdate(ReplyDTO updateDto) {
		return mapper.update(updateDto)==1?true:false;
	}

	@Override
	public boolean replyDelete(int rno) {
		return mapper.delete(rno)==1?true:false;
	}

	@Override
	public ReplyPageDTO getList(Criteria cri, int bno) {
		return new ReplyPageDTO(mapper.getCountBno(bno), mapper.select(cri, bno));
	}

	

}



























