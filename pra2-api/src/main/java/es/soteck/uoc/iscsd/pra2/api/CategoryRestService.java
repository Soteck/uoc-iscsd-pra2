package es.soteck.uoc.iscsd.pra2.api;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryRestService {

	@EJB
	private CategoryLocal categoryLocal;


	@GET
	@Path("/")
	public Response listAllCategories() {
		return Response.ok(categoryLocal.list()).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response insertCategory(
			MultivaluedMap<String, String> formParams) {
		String name = formParams.getFirst("name");
		String description = formParams.getFirst("description");
		return Response.ok(categoryLocal.add(name, description)).build();
	}

	@PUT
	@Path("/{primaryKey}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateCategory(
			MultivaluedMap<String, String> formParams,
			@PathParam("primaryKey") String primaryKey) {
		String description = formParams.getFirst("description");
		return Response.ok(categoryLocal.update(primaryKey, description)).build();
	}


	@DELETE
	@Path("/{primaryKey}")
	public Response deleteCategory(
			@PathParam("primaryKey") String primaryKey) {
		categoryLocal.delete(primaryKey);
		return Response.ok().build();
	}
	@GET
	@Path("/{primaryKey}")
	public Response getategory(
			@PathParam("primaryKey") String primaryKey) {
		return Response.ok(categoryLocal.findByName(primaryKey)).build();
	}
}
