package com.hp.manner.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import com.hp.manner.common.Report;
import com.hp.manner.common.Role;
import com.hp.manner.common.Status;
@Service
public class ReportService implements IReportService {

	@Autowired
	Connection conn;
	
	PreparedStatement ps=null;
	
	/* (non-Javadoc)
	 * @see com.hp.manner.service.IReportService#retrieve(java.lang.Long, java.sql.Date)
	 */
	@Override
	public List<Object> retrieve(Long userId,Date date) {
		// TODO Auto-generated method stub
		List<Object> listReport=new ArrayList<Object>();
		String sql="select t_user.id,t_user.email,t_user.first_name,t_user.last_name,t_user.password,t_user.role,t_group.id as groupId,t_group.created_date,t_group.name as groupName,t_group.owner_id as groupOwnerId,t_item.owner_id as itemOwnerId,count(t_item.id) as itemCount,t_item.content,t_item.status from ((t_group join t_group_user on t_group.id=t_group_user.group_id) join t_user on t_group_user.user_id=t_user.id) join t_item on t_user.id=t_item.owner_id where t_item.completion_date>? and t_item.owner_id in (select id from t_user where id in(select user_id from t_group_user where group_id in (select id from t_group where owner_id=?)))  group by t_item.owner_id,t_item.status;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setLong(2, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Report report=new Report();
				report.setId(rs.getLong("id"));
				report.setEmail(rs.getString("email"));
				report.setFirstName(rs.getString("first_name"));
				report.setLastName(rs.getString("last_name"));
				report.setPassword(rs.getString("password"));
				int temp=rs.getInt("role");
				if(temp==0){
					report.setRole(Role.SUPER_ADMIN);
				}
				else if(temp==1){
					report.setRole(Role.ADMIN);
				}
				else if(temp==2){
					report.setRole(Role.USER);
				}
				report.setGroupId(rs.getLong("groupId"));
				report.setCreatedDate(rs.getDate("created_date"));
				report.setGroupName(rs.getString("groupName"));
				report.setGroupOwnerId(rs.getLong("groupOwnerId"));
				report.setItemOwnerId(rs.getLong("itemOwnerId"));
				report.setItemCount(rs.getInt("itemCount"));
				report.setContent(rs.getString("content"));
				temp=rs.getInt("status");
				if(temp==0){
					report.setStatus(Status.NEW);
				}
				else if(temp==1){
					report.setStatus(Status.WORK_IN_PROGRESS);
				}
				else if(temp==2){
					report.setStatus(Status.COMPLETE);
				}
				listReport.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listReport;
	}
	
}
