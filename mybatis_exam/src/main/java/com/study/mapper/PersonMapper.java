package com.study.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.study.dto.PersonDTO;

public interface PersonMapper {
	
	//#{id}, #{name} => ?, ? 부분
	//insert into person(id,name) values(?,?)
//	@Insert("insert into person(id,name) values(#{id},#{name})")
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	
	
	public int insert(@Param("id") String id, @Param("name") String name);
	public int update(@Param("id") String id, @Param("name") String name);
	public int delete(String id);
	public PersonDTO select(String id);
}
