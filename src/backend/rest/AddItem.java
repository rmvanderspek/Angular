package backend.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import backend.DatabaseConnector;
import backend.Item;

import java.util.Date;

import javax.ws.rs.core.Response;

@Path("addItem")
public class AddItem {
    
	@POST
	@Produces("application/x-www-form-urlencoded")
	public Response addItem(
			@QueryParam("sender") String sender, 
			@QueryParam("receiver") String receiver,
			@QueryParam("subject") String subject,
			@QueryParam("message") String message){
		
		DatabaseConnector db = new DatabaseConnector();
		Date date = new Date();

		db.addItem(new Item(sender, receiver, subject, date, message));
		
		return Response.status(200)
				.entity("email was successfully added!")
				.build();
	}
}