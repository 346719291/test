package com.xsp.stu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    public static Session getSession() {
    	 Session session=null;
    	 session=threadLocal.get();
	     //读取配置文件
		 Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 //得到sessonFactory,相当于数据库
	/*
		 SessionFactory sf = config.buildSessionFactory();*/
    	 
		 
    	/*hibernate4提倡用注册服务方式生成sessionFactory*/
    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    	 				.applySettings(config.getProperties())
    	 				.buildServiceRegistry();
    	 SessionFactory sf = config.buildSessionFactory(serviceRegistry);

    	 
		 //得到session,相当于jdbc的connection
		 if(null==session) {
			 session=sf.openSession();
			 threadLocal.set(session);
		 }
		
    	 return session;
    }
    
    public static void closeSesson() {
    	 Session session=threadLocal.get();
    	 if(session!=null) {
    		 threadLocal.set(null);
    		 session.close();
    	 }
    }
    
    
    
    
    
}
