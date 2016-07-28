package backend.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import backend.DatabaseConnector;
import backend.Item;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("showItem")
public class ShowItem {
    
	@GET
	//@Path("/getList/")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(int id) {
		DatabaseConnector db = new DatabaseConnector();
		System.out.println("De db connector: " + db);
		Item item = db.getItem(id);
		System.out.println("dit is het: "+ item);
		return item;
	}
}