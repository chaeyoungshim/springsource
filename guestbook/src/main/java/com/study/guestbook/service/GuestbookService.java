package com.study.guestbook.service;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;

public interface GuestbookService {
	//등록
	Long register(GuestbookDTO insertDto);
	
	//목록
	PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);
	
	
	//Entity(Guestbook) => DTO(GuestbookDTO) 로 변환
	default GuestbookDTO entityToDto(Guestbook entity) {
		GuestbookDTO dto = GuestbookDTO.builder()
										.gno(entity.getGno())
										.title(entity.getTitle())
										.content(entity.getContent())
										.writer(entity.getWriter())
										.regDate(entity.getRegDate())
										.updatedate(entity.getUpdateDate())
										.build();
		
		return dto;
	}
	
	
	
	//DTO(GusetbookDTO) -> Entity(Guestbook) 로 변환
	default Guestbook dtoToEntity(GuestbookDTO dto) {
		Guestbook entity = Guestbook.builder()
									.title(dto.getTitle())
									.content(dto.getContent())
									.writer(dto.getWriter())
									.build();
		
		return entity;
	}
}























