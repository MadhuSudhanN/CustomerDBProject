package com.DAO;




import com.entity.CustomerEntity;

public interface CustomerDAORepo  {
	public  void insert(CustomerEntity cust);
	void delete(int cid);

}
