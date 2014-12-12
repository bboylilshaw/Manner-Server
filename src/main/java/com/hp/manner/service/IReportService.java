package com.hp.manner.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.hp.manner.common.Report;

public interface IReportService {
	public List<Object> retrieve(Long userId,Date date);
}
