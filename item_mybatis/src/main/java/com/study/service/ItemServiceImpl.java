package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.ItemDTO;
import com.study.mapper.ItemMapper;

@Service("service")
public class ItemServiceImpl implements ItemService {
	
	@Autowired 
	private ItemMapper mapper;
	
	@Override
	public boolean insertItem(ItemDTO insertDto) {
		return mapper.insert(insertDto)==1?true:false;
	}

	@Override
	public ItemDTO selectItem(int num) {
		return mapper.select(num);
	}

	@Override
	public boolean deleteItem(int num) {
		return mapper.delete(num)==1?true:false;
	}
	
	@Override
	public boolean updateItem(int num, String psize, int price) {
		return mapper.update(num, psize, price)==1?true:false;
	}
	
	@Override
	public List<ItemDTO> selectAllItem() {
		return mapper.selectAll();
	}


}



