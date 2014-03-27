package org.poc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"firstName", "lastName", "address", "portfolios" })
@XmlRootElement(name = "customer")
public class Customer extends Identification {

	List<Portfolio> portfolios;	
	String firstName;
	String lastName;
	Location address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Location getAddress() {
		return address;
	}
	public void setAddress(Location address) {
		this.address = address;
	}
	public List<Portfolio> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}
	@Override
	public String toString() {
		return "Customer [portfolios=" + portfolios + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address
				+ ", getId()=" + getId() + "]";
	}


	
}
