package com.study.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 데이터베이스 Entity
// 데이터베이스 상에서 데이터로 관리하는 대상
// 상품, 회사, 직원 등과 같이 명사이면서 업무와 관련된 데이터
// 테이블

@Builder
@Setter
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="memotbl")
@SequenceGenerator(name = "mem_seq_gen", sequenceName = "mem_seq", allocationSize = 1)
@Entity //일반 클래스가 아니고 클래스가 Entity 임을 명시(Entity Manager가 관리)
public class Memo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq_gen")
	@Id
	private Long mno; //mno 는 pk
	
	@Column(length = 200, nullable = false)
	private String memoText;
	
}


// @Table : @Entity 와 같이 사용, 엔티티 클래스를 어떤 테이블로 생성할 것인가?

// @Entity가 붙은 클래스는 primary key에 해당하는 특정 필드를 @Id로 지정해야만 함
// @GeneratedValue(strategy  = GeneratedType.SEQUENCE, generator = "") ==> pk를 어떤 방식으로 삽입할 것인지
// @Id : PK 지정

// GeneratedType.SEQUENCE
// GeneratedType.IDENTITY : 사용하는 데이터베이스가 키 생성을 결정(MySQL, Maria)
// GeneratedType.AUTO (default) : 특정 데이터베이스(MySQL, Maria)에 맞게 자동으로 생성됨
// GeneratedType.TABLE : 키 생성 전용 테이블 사용, @TableGenerator 과 함께 사용


// @SequenceGenerator(name = "mem_seq_gen", sequenceName = "mem_seq", allocationSize = 1)
// name=시퀀스 제너레이터 명(필수)
// sequenceName=시퀀스명(옵션)
// allocationSize=1(옵션-지정 안 하면 50씩 증가됨)
// initialValue=1(default)

















