package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.AttachDTO;
import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.dto.PageDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	//	/board/list 컨트롤러 작성
	
	@GetMapping("/list")
	public void listGet(Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("전체 리스트 요청" + cri);
		
		List<BoardDTO> list = service.getList(cri);
		//전체 게시물 개수
		int total = service.getTotalCnt(cri);
		
		model.addAttribute("pageDto", new PageDTO(cri, total));
		model.addAttribute("list",list);
	}
	
	// /board/register 컨트롤러 작성
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("register 폼 요청");
	}
	
	// register post로 작성
	@PostMapping("/register")
	public String registerPost(BoardDTO insertDto, Criteria cri ,RedirectAttributes rttr) {
		log.info("글 등록 요청 " + insertDto);
		
		service.insert(insertDto);
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("result", insertDto.getBno()); //insertDto 에 있는 bno도 같이 보내주기
		return "redirect:/board/list";
	}
	
	// /board/read + bno
	// bno에 해당하는 게시물 읽어온 후 read.jsp 보여주기
	@GetMapping({"/read","/modify"}) //modify 하려면 read 페이지 그대로 가져와야 하기 때문에 같이 써주기  {} 로 묶어서
	public void readGet(int bno,@ModelAttribute("cri") Criteria cri ,Model model) {
		log.info("게시글 읽어오기"+bno);
		log.info("게시글 읽어오기 - cri"+cri);
		
		BoardDTO dto = service.getRow(bno);
		model.addAttribute("dto",dto);
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO updateDto,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr) {
		log.info("게시물 수정 요청"+updateDto);
		log.info("게시물 수정 요청 - cri"+cri);
		
		service.update(updateDto);
		
		//수정 성공 시 수정된 게시물 보여줘야 하니까
		rttr.addAttribute("bno",updateDto.getBno()); //read로 이동할 때 해당 bno를 가지고 이동해야 일치하는 bno에 대한 게시물을 다시 한 번 보옂루 수 있음
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/read";
	}
	
	// /board/remove + bno
	@GetMapping("/remove")
	public String remove(int bno, Criteria cri ,RedirectAttributes rttr) {
		log.info("게시물 삭제 요청"+bno);
		log.info("게시물 삭제 요청"+cri);
		
		service.delete(bno);
		
		//주소줄에 딸려보내는 방식 => 이걸 딸려보내야 삭제하고도 그 페이지, 양 그대로 남겨져 위치가 그대로가 되니까
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		//세션을 이용한 방식
		rttr.addFlashAttribute("result","success");
		
		return "redirect:/board/list"; //jsp로 가는게 아니기에 ModelAttribute 안 해도 됨
	}
	
	
	
	//첨부파일 가져오기
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachDTO>> getAttachList(int bno) {
		log.info("첨부파일 "+bno);
		return new ResponseEntity<List<AttachDTO>>(service.attachList(bno),HttpStatus.OK);
	}
	
}





















