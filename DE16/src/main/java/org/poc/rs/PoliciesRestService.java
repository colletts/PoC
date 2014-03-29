package org.poc.rs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class PoliciesRestService {

    @GET
    @Path("/policy/{id}")
    public String getPolicyById(@PathParam("id")String id){    	    	
    	return null;    	
    }

    @POST
    @Path("/policy")
    public String createPolicy(String policy){    	    	
    	return null;    	
    }

    @PUT
    @Path("/policy/{id}")
    public String updatePolicy(@PathParam("id")String id, String policy){    	    	
    	return null;    	
    }
    
    @DELETE
    @Path("/policy/{id}")
    public String deletePolicyById(@PathParam("id")String id){    	    	
    	return null;    	
    }        
    
}
