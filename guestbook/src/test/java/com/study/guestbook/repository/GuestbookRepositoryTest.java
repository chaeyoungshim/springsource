package com.study.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.entity.QGuestbook;
import com.study.guestbook.repository.GuestbookRepository;

@SpringBootTest
public class GuestbookRepositoryTest {
	
	@Autowired
	private GuestbookRepository repository;
	
//	@Test
//	public void insert() {
//		
//		IntStream.rangeClosed(1, 300).forEach(i -> {
//			
//			GuestBook guestbook = GuestBook.builder()
//											.title("Guest Title..."+i)
//											.content("Guest Content..."+i)
//											.writer("user"+(i%10))
//											.build();
//			System.out.println(repository.save(guestbook));
//		});
//		
//	}
	
//	@Test
//	public void update() {
//		//600번 찾은 후 수정
//		repository.findById(600L).ifPresent(guest -> { //ifPresent : 존재한다면
//			guest.setTitle("Changed Title...");
//			guest.setContent("Changed Content");
//			
//			System.out.println(repository.save(guest));
//		});
//	}
	
	
	//querydsl 테스트 
	//검색할 때 사용
	//단일 항목으로 검색하는 경우(제목, 내용, 작성자) - 개별로
	//혼합 항목으로 검색하는 경우(제목+내용, 내용+작성자, 제목+작성자, 제목+내용+작성자) - 섞어서
	
//	@Test
//	public void searchQuery() {
//		
//		//페이지 나누기
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending()); //gno 중심으로 내림차순으로 하기
//		
//		//Q도메인 클래스 이용
//		QGuestBook qGuestbook = QGuestBook.guestBook;
//		
//		//title 에 1 이 들어가있는 게시물을 검색   where title like '%1%'
//		String keyword = "1";
//		
//		//where 절에 들어가는 조건들을 넣어주는 컨테이너
//		BooleanBuilder builder = new BooleanBuilder(); //먼저 생성해주기
//		
//		BooleanExpression expression = qGuestbook.title.contains(keyword); //title like '%1%' 에 해당,  where 절 끝
//		
//		builder.and(expression);
//		
//		// 페이지 나구기 + 생성해 낸 where
//		Page<GuestBook> result = repository.findAll(builder, pageable); //무조건 리턴타입은 Page임 무조건임
//		
//		result.stream().forEach(guestbook -> {
//			System.out.println(guestbook);
//		});
//		
//	}
	
	@Test
	public void searchQuery() {
		
		//페이지 나누기
		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending()); //gno 중심으로 내림차순으로 하기
		
		//Q도메인 클래스 이용
		QGuestbook qGuestbook = QGuestbook.guestbook;
		
		//제목 혹은 내용에 1 이라는 키워드가 있고 gno가 0보다 크다 -> 조건 걸어보기
		//where  gno>0 and (title like '%1%' or content like '%1%')
		String keyword = "1";
		
		//where 절에 들어가는 조건들을 넣어주는 컨테이너
		BooleanBuilder builder = new BooleanBuilder(); //먼저 생성해주기
		
		BooleanExpression expTitle = qGuestbook.title.contains(keyword);
		BooleanExpression expContent = qGuestbook.content.contains(keyword);
		
		BooleanExpression expAll = expTitle.or(expContent); //title과 content가 서로 or 관걔라는 것을 명시
		
		builder.and(expAll);
		
		builder.and(qGuestbook.gno.gt(0L)); //gno가 0보다 크면 조건 성립 구문
		
		// 페이지 나구기 + 생성해 낸 where
		Page<Guestbook> result = repository.findAll(builder, pageable); //무조건 리턴타입은 Page임 무조건임
		
		result.stream().forEach(guestbook -> {
			System.out.println(guestbook);
		});
		
	}
	
	
	
	
}













