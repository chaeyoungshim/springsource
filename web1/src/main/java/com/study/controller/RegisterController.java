package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.RegisterDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/*")
public class RegisterController {
	
	//register.jsp 보여주는 컨트롤러 생성
	@GetMapping("/register")
	public void registerGet() {
		log.info("register.jsp 폼 보여주기");
	}
	
	//register.jsp 에서 post 들어오는 요청
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("register") RegisterDTO register) { //객체 담아주기
		log.info("회원가입정보" + register);
		//로그인 페이지 보여주기
		return "redirect:/login"; //forward는 값을 유지시켜주기 때문에 회원가입 때는 sendRedirect로 이동시키기(주소 바뀌게), 회원가입 시는 정보 유지 x
	}
	
}
