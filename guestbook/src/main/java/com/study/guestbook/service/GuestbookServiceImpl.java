package com.study.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.repository.GuestbookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	private GuestbookRepository repository;
	
	@Override
	public Long register(GuestbookDTO insertDto) {
		log.info("service register "+insertDto);
		
		//entity 변환
		Guestbook entity = dtoToEntity(insertDto);
		
		log.info("entity "+entity);
		
		//db 작업
		repository.save(entity);
		
		return entity.getGno();
	}

	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
		
		//Sort 기준
		Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
		
		//findAll 호출
		Page<Guestbook> result = repository.findAll(pageable);
		
		//Guestbook 타입의 매개변수를 받아 GuestbookDTO로 리턴해줌
		Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		
		return new PageResultDTO<GuestbookDTO, Guestbook>(result, fn);
	}

}























