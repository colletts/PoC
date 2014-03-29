package org.poc.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PortfolioEndpointDE16 {

  public String getPortfolio(String portfolioId);
  
}
