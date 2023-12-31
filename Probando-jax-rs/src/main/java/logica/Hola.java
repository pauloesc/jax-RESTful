package logica;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hola")
public class Hola {

//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String hola() {
//    	return "<html>"
//    			+ "<title>Hello</title>"
//    			+ "<body>"
//    			+ "<h1>Hola a todos!</h1>"
//    			+ "<body>"
//    			+ "</html>";
//    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response hola() {
    	
    	String msn = "<html>"
					+ "<title>Hello</title>"
					+ "<body>"
					+ "<h1>Holadfdf a todos!</h1>"
					+ "<body>"
					+ "</html>";
    	return Response.ok(msn, MediaType.TEXT_HTML).build();
    
    }
	
	
	

}
