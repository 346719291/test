package com.xsp.stu.dao;

import java.util.List;

import com.xsp.stu.entity.User;

public interface userDao {
	//添加数据
	public int save(User user);
	//查询数据
	public List<User> Query();
	
}
