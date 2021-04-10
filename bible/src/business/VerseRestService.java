package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Verse;

@RequestScoped
@Path("/verses")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class VerseRestService {

	@Inject 
	VerseBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verse> getOrdersAsJson(){
		return service.getVerses();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Verse[] getOrdersAsXml() {
		List<Verse> orders = service.getVerses();
		return orders.toArray(new Verse[orders.size()]);
	}
	
}
