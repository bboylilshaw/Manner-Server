package com.hp.manner.controller.rest;

import com.hp.manner.common.ResponseTemplate;
import com.hp.manner.common.TableName;
import com.hp.manner.repository.GroupRepository;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import com.hp.manner.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

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
	Connection conn;
	@Autowired
	IReportService reportService;

	@RequestMapping(value="/report")
	public ResponseTemplate getReport(Long userId,Date date){
		List<Object> listReport=reportService.retrieve(userId, date);
		ResponseTemplate response=new ResponseTemplate();
		response.addData(TableName.Report, listReport);
		return response;
	}
}
