package es.soteck.uoc.iscsd.pra2.api;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestService {

	@EJB
	private CategoryLocal categoryLocal;


	@GET
	@Path("/")
	public Response listAll() {
		return Response.ok(categoryLocal.list()).build();
	}

	@POST
	@Path("/")
	public Response insertItem(
			MultivaluedMap<String, String> formParams) {
		String name = formParams.getFirst("name");
		String description = formParams.getFirst("description");
		return Response.ok(categoryLocal.add(name, description)).build();
	}

	@PUT
	@Path("/{primaryKey}")
	public Response updateItem(
			MultivaluedMap<String, String> formParams,
			@PathParam("primaryKey") String primaryKey) {
		String description = formParams.getFirst("description");
		return Response.ok(categoryLocal.update(primaryKey, description)).build();
	}


	@DELETE
	@Path("/{primaryKey}")
	public Response deleteItem(
			@PathParam("primaryKey") String primaryKey) {
		categoryLocal.delete(primaryKey);
		return Response.ok().build();
	}
}
