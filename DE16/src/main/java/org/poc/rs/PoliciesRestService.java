package org.poc.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class PoliciesRestService {

    @GET
    @Path("/policy/{id}")
    public String getPolicyById(@PathParam("id")String id){    	    	
    	return null;    	
    }

    @POST
    @Path("/policy/{id}")
    public String createPolicyById(@PathParam("id")String id){    	    	
    	return null;    	
    }
    
    
}
