package com.hp.manner.common;

import java.sql.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Report {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Role role;
	private Long groupId;
	private Date createdDate;
	private String groupName;
	private Long groupOwnerId;
	private Long itemOwnerId;
	private int itemCount;
	private String content;
	private Status status;
}
