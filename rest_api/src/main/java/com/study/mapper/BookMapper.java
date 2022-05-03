package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BookDTO;

public interface BookMapper { //dao 작업
	public List<BookDTO> select();
	public BookDTO get(int code);
	public int insert(BookDTO insertDto);
	public int update(@Param("code") int code, @Param("price") int price);
	public int delete(int code);
	public List<BookDTO> search(@Param("criteria") String criteria, @Param("keyword") String keyword);
}
