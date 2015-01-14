package com.hp.manner.controller.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.manner.common.ResponseTemplate;
import com.hp.manner.common.TableName;
import com.hp.manner.domain.Group;
import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import com.hp.manner.repository.GroupRepository;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;

@RestController
@RequestMapping(value="/rest",produces=MediaType.APPLICATION_JSON_VALUE)
public class ItemCtrl {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	GroupRepository groupRepository;
	
	@RequestMapping(value="/items",method=RequestMethod.POST)
	public ResponseTemplate addItem(@RequestBody Item item,Long userId,Long groupId){
		ResponseTemplate response=new ResponseTemplate();
		System.out.println("xxx1="+item.getCreatedDate());
		User user=userRepository.findOne(userId);
		Group group=groupRepository.findOne(groupId);
		item.setOwner(user);
		item.setCreatedBy(user);
		item.setLastModifiedBy(user);
		item.setGroup(group);
		item=itemRepository.save(item);
		System.out.println("xxx1="+item.getCreatedDate());
		Map<TableName,List<Object>> map=new HashMap<TableName,List<Object>>();
		List<Object> list=new ArrayList<Object>();
		list.add(item);
		map.put(TableName.Item, list);
		response.setSuccessful(true);
		response.setData(map);
		return response;
	}
	@RequestMapping(value="/items/{id}",method=RequestMethod.PUT)
	public ResponseTemplate updateItem(@PathVariable(value="id")String itemId,@RequestBody Item item,Long userId,Long groupId){
		ResponseTemplate response=new ResponseTemplate();
		if(item.getId().equals(itemId)){
			response.setSuccessful(false);
			return response;
		}
		System.out.println("xxx1="+item.getCreatedDate());
		User user=userRepository.findOne(userId);
		Group group=groupRepository.findOne(groupId);
		item.setOwner(user);
		item.setCreatedBy(user);
		item.setLastModifiedBy(user);
		item.setGroup(group);
		item=itemRepository.save(item);
		System.out.println("xxx2="+item.getCreatedDate());
		response.setSuccessful(true);
		Map<TableName,List<Object>> map=new HashMap<TableName,List<Object>>();
		List<Object> list=new ArrayList<Object>();
		list.add(item);
		map.put(TableName.Item, list);
		response.setSuccessful(true);
		response.setData(map);
		return response;
	}
}
