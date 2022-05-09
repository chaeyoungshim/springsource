package com.study.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {

	@GetMapping("/uploadform")
	public void uploadForm() {
		log.info("upload 폼 요청");
	}
	
	// type=file 에 들어있는 값 가져오기(request로 못 가져오니까)
	@PostMapping("/uploadform")
	public void uploadFormPost(MultipartFile[] uploadFile) {//uploadform.jsp 의 name 과 이름 맞춘 것
		log.info("upload 요청");
		
		//업로드 폴더 지정
		String uploadPath = "d:\\upload";
		
		for(MultipartFile f : uploadFile) {
			log.info("파일명 : "+ f.getOriginalFilename());
			log.info("파일크기 : " + f.getSize());
			
			try {
				File save = new File(uploadPath, f.getOriginalFilename());
				//파일 저장
				f.transferTo(save);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 다운로드
	// 이미지,텍스트,비디오....+상태코드(얘도 같이 보낼 예정)
	
//	@GetMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public ResponseEntity<Resource> downloadFile(String fileName) {
//		log.info("다운로드 요청 "+fileName);
//		
//		Resource resource = new FileSystemResource("d:\\upload\\"+fileName);
//		String resourceName = resource.getFilename();
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			headers.add("Content-Disposition", 
//					"attachment;filename="+new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
	
	
}




















