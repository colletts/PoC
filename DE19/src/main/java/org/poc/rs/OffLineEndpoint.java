package org.poc.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class OffLineEndpoint {

    @POST
    @Path("/")
    public void receiveRequest(String object){

    }

}
