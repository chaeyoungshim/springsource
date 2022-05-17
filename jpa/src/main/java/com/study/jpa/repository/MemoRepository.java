package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.Memo;

//Spring Data JPA 는 여러 종류의 인터페이스 기능을 통해서 JPA 관련 작업을 처리
//CRUD, 페이징, 정렬을 인터페이스 메소드만 호출하면 처리됨
//
//JpaRepository<Entity, Id 타입> 인터페이스

//MemoRepository 테스트

//자동으로 스프링 빈으로 등록 됨
public interface MemoRepository extends JpaRepository<Memo, Long> {
	//사용할 수 있는 여러개의 메소드들이 제공됨
	
	//새로운 메소드 생성도 가능함
	
}
