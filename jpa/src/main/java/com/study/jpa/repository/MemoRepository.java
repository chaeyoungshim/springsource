package com.study.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.jpa.entity.Memo;

//Spring Data JPA 는 여러 종류의 인터페이스 기능을 통해서 JPA 관련 작업을 처리
//CRUD, 페이징, 정렬을 인터페이스 메소드만 호출하면 처리됨
//
//JpaRepository<Entity, Id 타입> 인터페이스

//MemoRepository 테스트

//자동으로 스프링 빈으로 등록 됨
public interface MemoRepository extends JpaRepository<Memo, Long> {
	//사용할 수 있는 여러개의 메소드들이 제공됨
	
	//새로운 메소드 생성도 가능함 : 쿼리 메소드 findBy~ / getBy~ 이런식으로 시작함
	//mno를 기준으로 between 구문 사용하고 order by 적용 => 최종으로 리스트로 반환할 예정(여러 개의 행이 조회)
	//select * from memotbl where mno between 10 and 20 order by mno desc
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
	
	Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
	
	//메소드 새성 + @Query
//	@Query("select mno from memotbl order by mno desc")
//	List<Memo> getListDesc();
//	
//	
//	@Query("update memotbl set memoText = :memoText where mno = :mno") //여기서 ?를 쓰지 않고 : 콜론으로 대신한다
//	int updateMemoText(@Param("mno") Long mno,@Param("memoText") String memoText);
//	
//	//Native SQL 처리 : 운래 sql 구문 그대로 사용하기
//	@Query(value = "select mno from memotbl order by mno desc", nativeQuery = true)
//	List<Memo> getNativeListDesc();
	
	
	
	
	
	
}











