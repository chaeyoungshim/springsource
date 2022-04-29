package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.RegisterDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home"; //	/WEB-INF/views/home.jsp
	}
	
	//redirect 방식으로 움직일 때 값을 전송하는 방법
	//1) addAttribute("age", 10); : 주소줄에 age라는 이름으로 10 보내는 방식
	//	 http:// ~~~~~~~?age=10 형식으로, 앞에 뭐가 오든 상관없음, 뒤에만 저렇게
	//	 path += "?page="+page+"&amount="+amount...
	
	//2) addFlashAttribute("num", "15"); : 주소줄에 따라가지 않음, 세션 객체(일회성)에 담는 방식
	
	
	@GetMapping("/doB") //http://localhost:9090//doB 를 요청
	public String doB(RedirectAttributes rttr) {
		rttr.addAttribute("age", 10);
		rttr.addAttribute("addr", "서울");
		rttr.addAttribute("name", "홍길동");
		
		rttr.addFlashAttribute("num", "15"); 
		return "redirect:/"; //이 값을 반환해주니까 결국 home 으로 이동, home 보여줌
	}
	
	
	//예전 방식
	@GetMapping("/doC")
	public ModelAndView doC() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("num", 35); // == request.setAttribute()
		return mav;
	}
	
//	@GetMapping("/doD")
//	public RegisterDTO register() {
//		return new RegisterDTO();
//	}
	
	
}




















