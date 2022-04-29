package com.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller //컨트롤러라고 지정해주기
@Slf4j
@RequestMapping("/sample/*") //http://localhost:9090/sample/** (http://localhost:9090/ 이건 무조건 고정, 그 뒤에 붙음)
public class SampleController {
	
	// 앞쪽 고정 : /WEB-INF/views
	// 뒤쪽 고정 : .jsp
	
	// 컨트롤러의 리턴 타입이 void
	// http://localhost:9090/ 다음 부분이 jsp 페이지를 찾는데 사용됨
	
	// 컨트롤러의 리턴 타입이 String인 경우
	// return 값만 가지고 jsp 페이지를 찾음
	
	
	//@RequestMapping(path = "/basic", method= RequestMethod.GET) //@RequestMapping 이거는 무조건 주소, http://localhost:9090/sample/basic
	@GetMapping("/basic")
	public void basic(@ModelAttribute("page") int page, Model model) { //http://localhost:9090/sample/basic?page=10
		log.info("basic...."); ///WEB-INF/views/sample/basic.jsp
		
		//page 변수값을 jsp 보여주기 : Model에 담아서 하기
		//model.addAttribute("page", page); // 이거가 request.setAttribute 와 같은 개념, 담아놓으면 다른 곳에서 호출 시 값 불러오기
	}
	
	
	//@RequestMapping("/login") :  GET + POST 둘 다 허용
	//@RequestMapping(path = "/login", method = RequestMethod.GET) : GET 만 허용
	
	
	
	
//	 Controller 파라미터 수집
//	1) 변수명 사용
//	2) ~DTO 객체 사용(jsp 에서 값이 유지)
//	3) HttpServletRequest 객체 사용( 필요한 경우만 - 대부분 사용 잘 안 함)
	
	
	// @RequestParam("이름") : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우 사용
	
	

	
	
	
	
	//@RequestMapping(path = "/doA", method = RequestMethod.GET) //	http://localhost:9090/sample/doA
	@GetMapping("/doA")
	public void doA(String userid) {
		log.info("doA...." + userid); //	/WEB-INF/views/sample/doA.jsp
	}
	
	//@RequestMapping(value = "/insert", method = RequestMethod.GET) //	http://localhost:9090/sample/insert
	@GetMapping("/insert")
	public String insert(@RequestParam("ids") ArrayList<String> ids) { //@RequestParam("ids") 이거 안 넣으면 에러는 없는데 값이 담기질 않음 
		log.info("insert...." + ids); // /WEB-INF/views/insert.jsp
		return "insert";
	}
}





















