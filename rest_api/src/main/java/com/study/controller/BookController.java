package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book/*") //이거는 폴더 경로 기준,/가 붙었으니 앞에 다 자르고 9090/book이라는거고, /*이니 뒤에 뭘 오든 간에 모든 것을 뜻함, 이게 기본 경로로 설정됨
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/index")
	public String insert() {
		return "/book/book_test";
	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE) //리스트를 JSON 형태로 바꿔서 보내기
	public ResponseEntity<List<BookDTO>> list() { //list 형태로 bookDTO 담아서 보낼건데 상태코드랑 같이 전송할 예정
		List<BookDTO> list = service.getList();
		
		return new ResponseEntity<List<BookDTO>>(list,HttpStatus.OK); //성공 시 200
	}
	
	// /book/1000 + GET
	
	@GetMapping(path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDTO> get(@PathVariable("code") int code) {
		
		return new ResponseEntity<BookDTO>(service.getRow(code),HttpStatus.OK);
	}
	
	// /book/1000 + DELETE => 성공시 success, 실패시 fail
	//문자 같이 보낼거라 String형으로
	@DeleteMapping(path = "/{code}")
	public ResponseEntity<String> delete(@PathVariable("code") int code) {
		
		return service.bookDelete(code)? new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	// /book/1000 + PUT + body(수정내용-JSON형태) => 성공시 success, 실패시 fail
	
	@PutMapping(path="/{code}")
	public ResponseEntity<String> update(@PathVariable("code") int code,@RequestBody BookDTO dto){// /book/1000/2500 => @PathVariable 받아서 해도 되긴 함
		return service.bookUpdate(code,dto.getPrice())? new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	
	
	// /book/new + POST + body ==> 신규도서 입력
	
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody BookDTO insertDto) { //book_test.jsp에서 insert 부분에, contentType:"application/json"/ data:JSON.stringify(param) 에서 넘어오는 json 객체 insertDto로 담아달라는 @RequestBody 의 의미
		return service.bookInsert(insertDto)? new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	// 비동기식으로 클라이언트로부터 데이터를 가져올 때 객체에 담고자 한다면?
	
	@PostMapping("/new2")
	public ResponseEntity<String> insert2(BookDTO insertDto) {
		
		log.info("입력 "+insertDto);
		
		return service.bookInsert(insertDto)? new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	
	
}












