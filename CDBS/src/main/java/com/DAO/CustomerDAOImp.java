package com.DAO;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.entity.CustomerEntity;
import com.validate.StringFormat;

public  class  CustomerDAOImp  implements CustomerDAORepo{
	//Add customer Detail into db .
	public  void insert(CustomerEntity cust)
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=	s.beginTransaction();
		s.save(cust);
		tx.commit();
	}
	//remove customer using its id.
	@Override
	public void delete(int cid) {
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=	s.beginTransaction();
		CustomerEntity e=s.get(CustomerEntity.class,cid);
		s.delete(e);
		tx.commit();

	}
	//update customer using customer id
	public  void  update(int id,String fname,String lname,String street,String address,String city ,String state,String email,String phone  )
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=	s.beginTransaction();
		CustomerEntity c =s.get(CustomerEntity.class, id);
		if (!fname.isEmpty()) {
			c.setFname(StringFormat.stringF(fname));
		}
		if (!lname.isEmpty()) {
			c.setLname(StringFormat.stringF(lname));
		}
		if (!street.isEmpty()) {
			c.setStreet(StringFormat.stringF(street));
		}
		if (!address.isEmpty()) {
			c.setAddress(StringFormat.stringF(address));;
		}
		if (!city.isEmpty()) {
			c.setCity(StringFormat.stringF(city));
		}
		if (!state.isEmpty()) {
			c.setState(StringFormat.stringF(state));
		}
		if (!email.isEmpty()) {
			c.setEmail(StringFormat.stringF(email));
		}
		if (!phone.isEmpty()) {
			c.setPhone(StringFormat.stringF(phone));
		}
		System.out.println("After: "+c.getCid()+"  "+c.getFname()+" "+c.getLname()+" "+c.getStreet()+" "+c.getAddress()+" "+c.getCity()+" "+c.getEmail()+" "+c.getPhone());
		tx.commit();

	}
	//get all customers in list formatte
	public static List<CustomerEntity> featch(){
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from CustomerEntity") ;
		return q.list();

	}
	// search customers  based on email,phone,name etc
	public static List<CustomerEntity> search(String search,String name){
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
		Session s=sf.openSession();
		Query q = null;
		if(search.equals("SearchByName")) {
			q=s.createQuery("from CustomerEntity where fname like\'%"+name+"%\' or lname like\'%"+name+"%\'") ;
		}
		else if(search.equals("SearchById"))
		{
			q=s.createQuery("from CustomerEntity where cid="+name) ;
		}
		else if(search.equals("SearchByEmail"))
		{
			q=s.createQuery("from CustomerEntity where email=\'"+StringFormat.stringF(name)+"\'") ;
		}
		else if(search.equals("SearchByPhone"))
		{
			q=s.createQuery("from CustomerEntity where phone="+StringFormat.stringF(name)+"") ;
		}
		else  
		{
			q=s.createQuery("from CustomerEntity") ;
		}
		return q.list();

	}


}
