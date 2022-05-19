package com.study.guestbook.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//화면에서 전달되는 목록 데이터
//페이지번호, 페이지 내 보여줄 목록수, 검색타입, 검색어 ==> Criteria 비슷한 객체

@AllArgsConstructor
@Builder
@Data
public class PageRequestDTO {
	
	private int page; //현재 페이지 번호
	private int size; //페이지 내 보여줄 목록 수
	
	//검색을 위한 정보 끌고가기
	private String type; //검색 종류(내용, 작성자, 제목...)
	private String keyword; //검색어
	
	
	
	
	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		
		// 시작페이지 0 이기 때문에
		
		return PageRequest.of(page-1, size, sort); 
	}
	
}





















