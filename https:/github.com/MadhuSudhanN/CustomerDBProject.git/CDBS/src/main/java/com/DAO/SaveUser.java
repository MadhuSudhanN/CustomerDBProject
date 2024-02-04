package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.CustomerEntity;
import com.entity.UserEntity;

public class SaveUser {
 public  static void saveUser(String user,String pass)
 {
	 Configuration con=	new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(UserEntity.class);
		SessionFactory sf= con.buildSessionFactory();
		Session s=sf.openSession();
		UserEntity u=new UserEntity(user,pass);
		s.save(u);
		s.beginTransaction().commit();
		
 }
}
