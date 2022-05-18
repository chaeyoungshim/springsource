package com.study.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

// 페이지 결과 처리
// 페이지 처리 결과 넘어오는 객첸ㄴ Page<Entity> 형애임
// 서비스 계층에서 넘어오는 형태의 변경을 위해서 사용

@Data
public class PageResultDTO<DTO, EN> { //Entity 이기만 하면 돼 라는 뜻
	
	//게시물 리스트
	private List<DTO> dtoList;
	
	//현재 페이지 번호
	private int page;
	//목록 사이즈
	private int size;
	
	//시작 페이지 번호
	private int start;
	//끝 페이지 번호
	private int end;
	
	//이전, 다음
	private boolean prev, next;
	
	//페이지 번호 목록
	private List<Integer> pageList;
	
	//총 페이지 번호
	private int totalPage;
	
	
	public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
		
		dtoList = result.stream().map(fn).collect(Collectors.toList());
		totalPage = result.getTotalPages();
		makePageList(result.getPageable());
		
	}
	
	private void makePageList(Pageable pageable) {
		this.page = pageable.getPageNumber() + 1;
		this.size = pageable.getPageSize();
		
		int tempEnd = (int)(Math.ceil(page/10.0)) * 10;
		start = tempEnd - 9;
		prev = start > 1;
		end = totalPage > tempEnd ? tempEnd:totalPage;
		next = totalPage > tempEnd;
		
		pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
	}
	
	
}
