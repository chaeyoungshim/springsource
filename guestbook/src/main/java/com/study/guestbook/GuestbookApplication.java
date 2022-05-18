package com.study.guestbook;

import javax.persistence.EntityListeners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing  //Entity 클래스의 @EntityListeners(AuditingEntityListener.class) 활성화
@SpringBootApplication
public class GuestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookApplication.class, args);
	}

}
