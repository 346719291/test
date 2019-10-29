package com.xsp.stu.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xsp.stu.dao.userDao;
import com.xsp.stu.entity.User;
import com.xsp.stu.util.HibernateUtils;

public class userDaoimpl implements userDao{

	@Override
	public int save(User user) {
		/*Session session=HibernateUtils.getSession();
		String hql="insert into user values user.su_name:su_name";
		Query squery= session.createQuery(hql);
		squery.setParameter("su_name", user.getSu_name());
		return 1;*/
		
		int rows=-1;
		//1、读取配置文件
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		//2、创建sessionFactory对象
		SessionFactory sessionFactory = conf.buildSessionFactory(); 
		//3、创建session连接
	    Session session = sessionFactory.openSession();   
        //4、开启事务
	    Transaction tx = session.beginTransaction(); 
	    //5、存取操作
	    session.save(user);
	    tx.commit(); 
	    session.close();
		return rows;
		
	}

	@Override
	public List<User> Query() {
		Session session=HibernateUtils.getSession();
		String hql="select user from User user";
		Query squery= session.createQuery(hql);
		List<User> list=squery.list();
		return list;
	}

}
