package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.dto.SampleDTO;

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
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@ResponseBody //jsp 찾지마
	@GetMapping("/test")
	public String read() {
		return "success";
	}
	
	@ResponseBody
	@GetMapping(path = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleDTO modify() {
		return new SampleDTO("1234", "park", "seoul");
	}
	
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> list() {
		return new ResponseEntity<SampleDTO>(new SampleDTO("4321","kim","경기"), HttpStatus.OK);
	}
}















