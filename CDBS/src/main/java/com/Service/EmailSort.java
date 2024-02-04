package com.Service;

import java.util.Comparator;

import com.entity.CustomerEntity;

public class EmailSort implements  Comparator<CustomerEntity>
{

	@Override
	public int compare(CustomerEntity o1, CustomerEntity o2) {
		String n1=o1.getEmail();
		String n2=o2.getEmail();
		
		return n1.compareTo(n2);
	}
	
}
