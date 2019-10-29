package com.xsp.stu.test;

import java.util.List;

import com.xsp.stu.dao.userDao;
import com.xsp.stu.dao.impl.userDaoimpl;
import com.xsp.stu.entity.User;

public class TestUser {
	public static void main(String[] args) {
		userDao users=new userDaoimpl();
		User user=new User(0,"李小白");
		//users.save(user);
		int s= users.save(user);
		if(1==s) {
			System.out.println("成功");
		}else
			System.out.println("失败");
		
		/*
		userDao users=new userDaoimpl();
		List<User> list= users.Query();
		for(User listd :list) {
			System.out.println(listd);
		}*/
	}
}
