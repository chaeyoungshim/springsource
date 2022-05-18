package com.study.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.service.GuestbookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookService service;
	
	@GetMapping({"/","/list"})
	public String list(PageRequestDTO requestDTO, Model model) {
		log.info("list 요청 "+requestDTO);
		
		//목록 리스트 생성 - PageResultDTO<GuestbookDTO, Guestbook> 
		model.addAttribute("result", service.getList(requestDTO));
		
		return "/guestbook/list";
	}
}
