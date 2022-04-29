package com.study.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BookDTO;
import com.study.myapp.service.BookService;


public class BookMain {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		
		//자바코드
//		BookService service = new BookServiceImpl();
//		List<BookDTO> list = service.getList();
		
//		//도서 정보 삽입
//		BookDTO insertDto = new BookDTO(3003, "모두의 알고리즘 파이썬", "이승한", 28000);
//		System.out.println(service.bookInsert(insertDto)?"삽입성공":"삽입실패");
		
		
		//도서 정보 수정
		//System.out.println(service.bookUpdate(3002,9000)?"수정성공":"수정실패");
		
		//도서 삭제
		System.out.println(service.bookDelete(2020)?"삭제성공":"삭제실패");
		
		List<BookDTO> list = service.getList();
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
		
	}
}
