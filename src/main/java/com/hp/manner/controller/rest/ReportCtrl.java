package com.hp.manner.controller.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.manner.common.Report;
import com.hp.manner.common.ResponseTemplate;
import com.hp.manner.common.TableName;
import com.hp.manner.domain.Group;
import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import com.hp.manner.repository.GroupRepository;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;

@RestController
@RequestMapping(value="/api",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public class ReportCtrl {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	GroupRepository groupRepository;

	@RequestMapping(value="/report")
	public ResponseTemplate getReport(Long userId,Date date){
		ResponseTemplate response=new ResponseTemplate();
		if(userId==null){
			response.setSuccessful(false);
			response.setMessage("no userId");
			return response;
		}
		if(date==null){
			date=(Date) DateTime.now().toDate();
		}
		User owner=userRepository.findOne(userId);
		List<Object> listReport=new ArrayList<Object>();
		List<Group> listGroup=groupRepository.findByOwner(owner);
		for(Group group : listGroup){
			Report report=new Report();
			report.setGroupId(group.getId());
			report.setGroupName(group.getName());
			report.setGroupOwnerId(userId);
			Collection<User> listMember=group.getUsers();
			for(User user : listMember){
				report.setEmail(user.getEmail());
				report.setFirstName(user.getFirstName());
				report.setLastName(user.getLastName());
				report.setRole(user.getRole());
				Collection<Item> listItem=itemRepository.findByOwner(user);
				for(Item item : listItem){
					report.setContent(item.getContent());
					report.setItemOwnerId(user.getId());
					report.setItemCount(itemRepository.countByOwnerAndCompletionDateAfter(user, date));
				}
			}
			listReport.add(report);
		}
		response.addData(TableName.Report, listReport);
		return response;
	}
}
