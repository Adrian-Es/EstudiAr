package com.estudiar.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.estudiar.dto.ItemInfo;
import com.estudiar.dto.ItemRegister;
import com.estudiar.model.Category;
import com.estudiar.model.Item;

public class ItemMapper {

	//toEntity
	public static Item ItemRegisterToItem(ItemRegister itemRegister, Category category) {
		return new Item(itemRegister.getName(),itemRegister.getDefinition(),category);
	}
	
	//toDto
	public static ItemInfo itemToItemInfo(Item item) {
		if(item == null) return null;
		return new ItemInfo(item.getId(), item.getName(), item.getDefinition());
	}
	
	//EntitySet to DtoSet
	public static Set<ItemInfo> toItemInfoSet(Set<Item> items){
		if(items == null) return null;
		
		Set<ItemInfo> itemsInfo = new HashSet<ItemInfo>();
		
		items.forEach(t -> {
			itemsInfo.add(itemToItemInfo(t));
		});
		
		return itemsInfo;
	}
	
	//EntityList to DtoList
	public static List<ItemInfo> toItemInfoList(List<Item> items){
		if(items == null) return null;
		
		List<ItemInfo> itemsInfo = new ArrayList<ItemInfo>();
		
		items.forEach(t -> {
			itemsInfo.add(itemToItemInfo(t));
		});
		
		return itemsInfo;
	}
	
}
