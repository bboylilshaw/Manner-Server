package com.hp.manner.controller.rest;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.manner.common.ResponseTemplate;
import com.hp.manner.common.TableName;
import com.hp.manner.repository.GroupRepository;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import com.hp.manner.service.IReportService;

@RestController
@RequestMapping(value="/api",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public class ReportCtrl {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	IReportService reportService;

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
		List<Object> listReport=reportService.retrieve(userId, date);
		response.addData(TableName.Report, listReport);
		return response;
	}
}
