package com.validate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.CustomerEntity;
import com.entity.UserEntity;

public class Validate {
	static 	public boolean  validateUser(String  user ,String  pass)
	{
		SessionFactory sf=new	 Configuration().configure().addAnnotatedClass(UserEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from UserEntity where user='"+user+"' and  pass='"+pass+"'");
		List l=q.list();
		return (l.size()>0)?true:false;
	}
	public static boolean validateID(int id)
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(UserEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=	s.beginTransaction();
		Query r=s.createQuery("from customerEntity where id='"+id+"'");
		List<CustomerEntity> l=r.list();
		return  l.size()>0?true:false;
	}
}
