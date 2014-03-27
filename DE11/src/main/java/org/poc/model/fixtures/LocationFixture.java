package org.poc.model.fixtures;

import org.poc.model.Location;

/**
 * Test class to return test data 
 * 
 *
 */
public class LocationFixture {

	public static final String ADDRESS_1="12";
	public static final String ADDRESS_2="Queen Street";
	public static final String ADDRESS_3="Brisbane"; 
	public static final String COUNTRY="Australia";
	public static final String POSTCODE="4000";
	public static final String STATE="QLD";
	
	
	
	public static Location getLocation(){
		Location location = new Location();
		location.setAddress1(ADDRESS_1);
		location.setAddress2(ADDRESS_2);
		location.setAddress3(ADDRESS_3);
		location.setCountry(COUNTRY);
		location.setPostCode(POSTCODE);
		location.setState(STATE);
		return location;
	}
	
}
