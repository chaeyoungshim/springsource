package com.study.guestbook.entity;

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

/*
 * create table guestbook(
 * 	gno number(20) not null,
 *  title varchar2(100) not null,
 *  content varchar2(1500) not null,
 *  writer varchar2(50) not null,
 *  regdate timestamp not null,
 *  updatedate timestamp not null,
 *  primary key(gno));
 *  
 *  create sequence guest_seq;
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="guestbook") //필수 아님
public class Guestbook extends BaseEntity {
	
	@SequenceGenerator(name = "guest_seq_gen", allocationSize = 1, sequenceName = "guest_seq") //이렇게 해주기
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq_gen") //이렇게만 하면 기본 시퀀스 써워야 해서 바로 위에 
	@Id
	private Long gno;
	
	@Column(length = 100, nullable = false) //길이는 100, not null
	private String title;
	
	@Column(length = 1500, nullable = false)
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	
}
