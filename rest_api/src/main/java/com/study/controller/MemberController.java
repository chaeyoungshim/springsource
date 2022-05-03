package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;
import com.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	//컨트롤러가 보내는 모든 값은 데이터
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//	/member/new + POST + body(json 데이터)
	
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody MemberDTO register) { //원하는 MemberDTO 로 변환해줘 => @RequestBody
		log.info("회원가입 요청");
		
		return service.register(register)?new ResponseEntity<String>("success",HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	
	//	/member/id + 수정데이터(json) + PUT
	@PutMapping("/{id}") //써먹을거라면 중괄호 안에 넣어주면 됨
	public ResponseEntity<String> update(@PathVariable("id") String userid,@RequestBody ChangeDTO changeDto) { 
		return service.changePwd(changeDto)?new ResponseEntity<String>("success",HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
}



















