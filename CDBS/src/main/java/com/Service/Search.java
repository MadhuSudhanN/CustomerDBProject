package com.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.CustomerEntity;
import com.validate.StringFormat;


public class Search {
	public static List nameSearch(String name){

		Configuration con=	new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(CustomerEntity.class);
		SessionFactory sf= con.buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from EmpEntity where name like '%".concat(StringFormat.stringF(name))+"%'") ;
		List<CustomerEntity> l=q.list();
		return l;

	}
	public static List emailSearch(String email){

		Configuration con=	new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(CustomerEntity.class);
		SessionFactory sf= con.buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from EmpEntity where name like '%".concat(StringFormat.stringF(email))+"%'") ;
		List<CustomerEntity> l=q.list();
		return l;

	}
}
