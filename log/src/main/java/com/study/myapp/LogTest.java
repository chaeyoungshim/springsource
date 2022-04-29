package com.study.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {
	 //이걸 로그 처리할 것이라고 지정, 롬복으로 해서 어노테이션 추가해줘도 잘 돌아감
	//private static final Logger log=LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("trace"); //아직 안 나옴
	}
}	
