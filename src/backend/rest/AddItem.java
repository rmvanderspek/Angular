package backend.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import backend.DatabaseConnector;
import backend.Item;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("addItem")
public class AddItem {
    
	@POST
	//@Path("/getList/")
	public Response addItem(
			@FormParam("sender") String sender, 
			@FormParam("receiver") String receiver,
			@FormParam("subject") String subject,
			@FormParam("dateString") String dateString,
			@FormParam("message") String message){
		
		DatabaseConnector db = new DatabaseConnector();
		DateFormat df = DateFormat.getInstance();
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.addItem(new Item(sender, receiver, subject, date, message));
		
		return Response.status(200)
				.entity("addUser is called, name : " + sender + ", age : " + receiver)
				.build();
	}
}