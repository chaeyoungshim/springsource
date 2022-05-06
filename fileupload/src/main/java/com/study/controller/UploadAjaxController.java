package com.study.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.study.dto.AttachDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadAjaxController {
	
	
	@GetMapping("/uploadAjax")
	public String uploadAjaxForm() {
		log.info("ajax 업로드 폼 요청");
		return "uploadform_ajax";
	}
	
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("ajax 업로드 요청");
		
		
		List<AttachDTO> attachList = new ArrayList<AttachDTO>();
		
		
		//업로드 기본 폴더 지정
		String uploadBasicPath = "d:\\upload";
		//업로드 세부 폴더 지정 "2022\05\06"
		String uploadFolderPath = getFolder();
		//전체 업로드 패스 생성 d:\\upload\\2022\\05\\06
		File uploadPath = new File(uploadBasicPath,uploadFolderPath);
		
		if(!uploadPath.exists()) { //폴더가 없다면 폴더 여러개 만들기
			uploadPath.mkdirs(); 
		}
		
		//업로드 파일명
		String uploadFileName = "";
		File save = null;
		for(MultipartFile f : uploadFile) {
			
			// 파일명 가져오기
			String oriFileName = f.getOriginalFilename();
			
			// 중복 파일명 해결하기
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+oriFileName;
			
			
			// 업로드 파일 객체 생성
			AttachDTO attachDto = new AttachDTO();
			attachDto.setUploadPath(uploadFileName);
			attachDto.setFileName(oriFileName);
			attachDto.setUuid(uuid.toString());
			
			save = new File(uploadPath, uploadFileName);
			try {
				//파일 저장
				f.transferTo(save);
				
				if(checkImageType(save)) { //true 라면
					attachDto.setFileType(true);
				}
				
				attachList.add(attachDto);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<List<AttachDTO>>(attachList,HttpStatus.OK);
	}
	
	//이미지 파일 여부 확인
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image"); //image/jpeg, image/gif, image/bmp, image/png
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	//폴더 생성 메소드
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//오늘 날짜 구하기
		Date date = new Date(); //Wed Dec 08 16:04:05 KST 2022
		
		String str = sdf.format(date); //"2022-05-06"
		
		// windows : \, unix : /
		return str.replace("-", File.separator); //"2022\05\06"
	}
}





















