package com.study.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BoardDTO;

@Repository //객체 생성하기
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(BoardDTO insertDto) {
		
		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";
		
		int result = jdbcTemplate.update(sql, insertDto.getTitle(),insertDto.getContent(),insertDto.getWriter());
		
		return result;
	}
	
	public List<BoardDTO> select() {
		String sql = "select * from spring_board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	
	//update - bno가 일치하면 title, content, updatedate(sysdate) 수정
	public int update(BoardDTO updateDto) {
		
		String sql = "update spring_board set title=?,content=?,updatedate=sysdate where bno=?";
		int result = jdbcTemplate.update(sql,updateDto.getTitle(),updateDto.getContent(),updateDto.getBno());
		return result;
	}
	
	//bno 일치 시 삭제
	public int delete(int bno) {
		String sql = "delete from spring_board where bno=?";
		return jdbcTemplate.update(sql, bno);
	}
	
	
	public BoardDTO selectOne(int bno) {
		
		String sql = "select * from spring_board where bno=?";
		
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper(), bno);
	}
	
	
}






























