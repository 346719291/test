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
	     //��ȡ�����ļ�
		 Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 //�õ�sessonFactory,�൱�����ݿ�
	/*
		 SessionFactory sf = config.buildSessionFactory();*/
    	 
		 
    	/*hibernate4�ᳫ��ע�����ʽ����sessionFactory*/
    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    	 				.applySettings(config.getProperties())
    	 				.buildServiceRegistry();
    	 SessionFactory sf = config.buildSessionFactory(serviceRegistry);

    	 
		 //�õ�session,�൱��jdbc��connection
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
