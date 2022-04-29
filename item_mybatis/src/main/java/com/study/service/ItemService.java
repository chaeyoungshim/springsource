package com.study.service;

import java.util.List;

import com.study.dto.ItemDTO;

public interface ItemService {
	public boolean insertItem(ItemDTO insertDto); //삽입
	public ItemDTO selectItem(int num); //하나 조회
	public boolean deleteItem(int num); //삭제
	public boolean updateItem(int num,String psize,int price); //수정
	public List<ItemDTO> selectAllItem(); //전체 조회
}
