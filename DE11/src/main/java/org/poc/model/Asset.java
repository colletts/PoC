package org.poc.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "location", "sumInsured"})
public class Asset extends Identification {

	private Location location;
	private BigDecimal sumInsured;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public BigDecimal getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}
	@Override
	public String toString() {
		return "Asset [location=" + location + ", sumInsured=" + sumInsured
				+ ", getId()=" + getId() + "]";
	}

	

	
}
