package com.study.thymeleaf.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private Timestamp regdate;
}
