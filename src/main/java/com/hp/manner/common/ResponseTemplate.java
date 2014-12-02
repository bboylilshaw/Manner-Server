package com.hp.manner.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class ResponseTemplate {
	@NotEmpty
	private boolean successful;
	@NotEmpty
	private String submitter;
	@NotEmpty
	private Date submitDate;
	private String message;
	private Map<TableName,List<Object> >data=new HashMap<TableName,List<Object>>();
	private int pageSize;
	private int pageIndex;
	
	public void addData(TableName tableName,List<Object> listObject){
		data.put(tableName, listObject);
	}
}
