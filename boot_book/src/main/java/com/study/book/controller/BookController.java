package com.study.book.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.book.dto.BookDTO;
import com.study.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;
	
	//전체 리스트 보여주기
	@GetMapping("/list")
	public void list(Model model) {
		log.info("도서 전체 목록 요청");
		
		//서비스 호출 
		List<BookDTO> list = service.getList();
		
		//list 담기
		model.addAttribute("list" ,list); //setAttribute 와 같은 개념
	}
	
	//도서 입력 폼 보여주기
	@GetMapping("/insert")
	public void insertGet() {
		log.info("도서 입력 폼 보여주기");
	}
	
	//도서 입력 요청
	@PostMapping("/insert")  //post로 요청하기
	public String insertPost(BookDTO insertDto, RedirectAttributes rttr) {
		log.info("도서 정보 가져오기");
		
		try {
			if(service.bookInsert(insertDto)) { //성공하면
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error","코드를 확인하세요");
			return "redirect:/book/insert";
		}
		
		return "redirect:/book/insert";
	}
	
	@GetMapping("/delete")
	public void deleteGet() {
		log.info("도서 삭제 폼 보여주기");
	}
	
	//도서 삭제 폼 요청
	@PostMapping("/delete")
	public String deletePost(int code) {
		log.info("도서 정보 삭제하기" + code);
		if(service.bookDelete(code)) { //성공하면
			return "redirect:/book/list";
		}
		return "redirect:/book/delete";
	}
	
	//도서 수정 폼 요청
	@GetMapping("/update")
	public void updateGet() {
		log.info("도서 수정 폼 보여주기");
	}
	
	@PostMapping("/update")
	public String updatePost(int code,int price) {
		log.info("도서 정보 수정" +code+"-"+price);
		
		if(service.bookUpdate(code, price)) {
			return "redirect:/book/list";
		}
		
		return "redirect:/book/update";
	}
	
	@GetMapping("/search")
	public void searchGet() {
		log.info("도서 정보 폼 보여주기");
	}
	
	@PostMapping("/search")
	public String searchPost(String criteria, String keyword, Model model) {
		log.info("검색 요청" +criteria+" "+keyword);
		
		List<BookDTO> list = service.getSearchList(criteria, keyword); // 리스트라 객체 담아주기
		
		model.addAttribute("list" ,list); //객체 담아서 호출해서 쓸 수 있도록 list를 사용했으니까 list에 담아주기
		///WEB-INF/views/book/list.jsp 로 가라는 것
		return "/book/list"; //얘는 값을 살려야하기 때문에 redirect: 를 쓰면 절대 안됨, 그리고 list로 담아줬던거 그대로 얘도 담아주기, 이건 forward 방식
		//return "redirect:/book/search"; //이거는 /WEB-INF/views/book/list.jsp 가라는게 아니라 컨트롤러 get(/book/list) 가는 것
	}
	
}











