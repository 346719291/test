package com.xsp.stu.dao;

import java.util.List;

import com.xsp.stu.entity.User;

public interface userDao {
	//�������
	public int save(User user);
	//��ѯ����
	public List<User> Query();
	
}
