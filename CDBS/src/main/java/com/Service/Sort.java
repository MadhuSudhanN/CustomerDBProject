package com.Service;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.entity.CustomerEntity;

public class Sort {
	public static List<CustomerEntity> ms()
	{
		Configuration con=	new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(CustomerEntity.class);
		SessionFactory sf= con.buildSessionFactory();
		Session s=sf.openSession();
		Query<CustomerEntity> q=s.createQuery("from EmpEntity") ;
		
		List<CustomerEntity> list=q.getResultList();
		
		
		return list;

	}
}
