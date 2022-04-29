package com.study.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BoardDTO;
import com.study.myapp.service.BoardService;

public class BoardApp {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService) ctx.getBean("service");
		
		//게시글 등록
//		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프링 게시판10");
//		insertDto.setContent("스프링 게시판 작성하기10");
//		insertDto.setWriter("홍길동10");
//	
//		System.out.println(service.boardInsert(insertDto)?"삽입성공":"삽입실패");
	
		//게시글 수정
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setBno(7);
//		updateDto.setTitle("먹고싶다");
//		updateDto.setContent("서브웨이");
//		System.out.println(service.boardUpdate(updateDto)?"수정성공":"수정실패");
		
		//게시글 삭제
//		System.out.println(service.boardDelete(7)?"삭제성공":"삭제실패");
		
		//게시글 조회
//		System.out.println(service.getRow(5));
		
		//게시글 전체 목록 가져오기
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto:list) {
			System.out.println(dto);
		}
		
		
	}
}
