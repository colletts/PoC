package org.poc.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PolicyEndpoint {

  public String getPolicy(@WebParam(name="getPolicyId") String policyId);
  
  public String createPolicy(@WebParam(name="policy") String policy);
  
  public String deletePolicy(@WebParam(name="deletePolicyId") String policyId);
  
  public String updatePolicy(@WebParam(name="updatePolicyId") String policyId, @WebParam(name="policy") String policy);
  
}
