package org.poc.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class RequestRestServiceAV29 {

    @GET
    @Path("/av29/{key}")
    public String lookupString(@PathParam("key")String key){    	    	
    	return null;    	
    }

    
}
