package org.poc.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.poc.model.Customer;
import org.poc.model.Location;



@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface LookupEndpoint {

  public Customer getCustomerByName(String name);
  
  public Customer getCustomerByPortfolio(String id);
  
  public Location getLocationByPostCode(String postcode);
  
  
  
  
}
