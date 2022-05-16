package com.study.thymeleaf.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.thymeleaf.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/sample")
public class SampleController {

	@GetMapping("/ex1")
	public void ex1(Model model) {
		log.info("ex1 요청");
		model.addAttribute("data","thymeleaf");
	}
	
	@GetMapping("/ex2")
	public void ex2(Model model) {
		log.info("ex2 요청");
		model.addAttribute("greeting","안녕하세요");
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model) {
		log.info("ex3 요청");
		//객체 생성 후 객체를 모델에 담기
		MemberDTO dto = new MemberDTO(100, "mem01", "mem01", 
				"홍길동", LocalDateTime.now());
		
		model.addAttribute("dto",dto);
	}
	
}















