package solutions.pratnya.erp.resources;

import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/erp")
public class ErpResource {
	
	@GET
	@Path("/Hello")
	public String areYouThere() {
		return "I am here @ "+new Date();
	}
	
}
