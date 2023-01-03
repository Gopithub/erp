/**
 * @author GK
 * This is the service which handles the individual data object CRUD
 */

package solutions.pratnya.erp.resources;

import org.jdbi.v3.core.Jdbi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import solutions.pratnya.erp.db.ErpIndividualDao;
import solutions.pratnya.erp.model.Individual;

@Path("/erp")
@Produces(MediaType.APPLICATION_JSON)
public class ErpIndividual {
	private final Jdbi jdbi;
	public ErpIndividual(Jdbi jdbi){
		this.jdbi=jdbi;
	}
	@GET
	@Path("/individual/{id}")
	public Individual getIndividual(@PathParam("id") Integer id) {
		final ErpIndividualDao dao = jdbi.onDemand(ErpIndividualDao.class);
		return dao.findNameById(id);
	}
}
