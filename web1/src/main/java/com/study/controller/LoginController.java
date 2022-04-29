package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	//@RequestMapping(path = "/login", method = RequestMethod.GET) 
	//http://localhost:9090/sample/login
	@GetMapping("/login")
	public String login() {
		log.info("login...."); //	/WEB-INF/views/sample/login.jsp
		
		return "sample/login"; //이 경로로 가라
	}
	
	
	//@RequestMapping(path = "/login", method = RequestMethod.POST) //http://localhost:9090/sample/login, 경로는 같아도 됨, 대신 method가 달라야함, 그럼 에러 안나고 잘됨
//	@PostMapping("/login")
//	public void loginPost(String userid, String password, String addr, int age) { //name 맞춰주면 됨
//		log.info("login POST...." + userid + " " + password + " " + addr + " " + age); //	/WEB-INF/views/sample/login.jsp
//	}
	
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("user") UserDTO userDto) { //name 맞춰주면 됨
		log.info("login POST...." + userDto.getUserid() + " " + userDto.getPassword() + " " + userDto.getAddr() + " " + userDto.getAge()); //	/WEB-INF/views/sample/login.jsp
		
		return "sample/logout";
		//
		
		//return "home"; //근데 주소는 http://localhost:9090/login 임, forward
		//		 redirect: => snedRedirect
		//return "redirect:/"; // 이렇게 해야 주소가 바뀜(가야 할 경로 지정), http://localhost:9090/
	}
	
	
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest request) { //name 맞춰주면 됨
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String addr = request.getParameter("addr");
//		String age = request.getParameter("age");
//		log.info("login POST...." + userid + " " + password + " " + addr + " "+ age); //	/WEB-INF/views/sample/login.jsp
//	}
	
}
