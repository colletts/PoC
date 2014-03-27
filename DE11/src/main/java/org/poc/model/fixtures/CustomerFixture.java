package org.poc.model.fixtures;

import org.poc.model.Customer;

public class CustomerFixture {

	public static final String FIRST_NAME = "Jane";
	public static final String LAST_NAME = "Smith";
	public static final String CUSTOMER_ID = "c882717";
	
	public static Customer getCustomer(){
		Customer customer = new Customer();
		customer.setAddress(LocationFixture.getLocation());
		customer.setPortfolios(PortfolioFixture.getPortfolios());
		customer.setFirstName(FIRST_NAME);
		customer.setLastName(LAST_NAME);
		customer.setId(CUSTOMER_ID);
		return customer;
	}
	
}
