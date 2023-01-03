/**
 * @Author GK
 * This is the DAO for Individual.
 */
package solutions.pratnya.erp.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import solutions.pratnya.erp.model.City;
import solutions.pratnya.erp.model.Codes;
import solutions.pratnya.erp.model.Individual;
import solutions.pratnya.erp.model.Organisation;
@RegisterBeanMapper(value = Individual.class, prefix = "i") 
@RegisterBeanMapper(value = Organisation.class, prefix = "o")
@RegisterBeanMapper(value = City.class, prefix = "ci")
@RegisterBeanMapper(value = Codes.class, prefix = "c")
public interface ErpIndividualDao extends ErpInterface {
	  @SqlUpdate("insert into individual (id, FirstName) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);
	  @UseRowMapper(IndividualMapper.class)
	  @SqlQuery("SELECT i.*,o.*,c.*,ci.*  FROM individual i, organisation o, codes c, city ci WHERE i.City=ci.ID AND i.Organization=o.ID AND i.Type=c.ID AND i.id = :id and c.Type=1;")
	  Individual findNameById(@Bind("id") int id);
	  public class IndividualMapper implements RowMapper<Individual> {

		    private Individual individual;

		    // this mapping method will get called for every row in the result set
			@Override
			public Individual map(ResultSet rs, StatementContext ctx) throws SQLException {
				return individual = new Individual(rs.getInt("i.ID"), rs.getString("i.FirstName"), rs.getString("i.LastName"), new Organisation(rs.getInt("o.ID"), rs.getString("o.name"), rs.getString("o.address1"), rs.getString("o.address2"), new City(null, null, null, null, 0)), rs.getString("i.Address1"),rs.getString("i.Address2"),new City(rs.getString("ci.Name"), rs.getString("ci.state"),rs.getString("ci.country"),rs.getString("ci.pincode"), rs.getInt("ci.ID")), new Codes(rs.getInt("c.id"),rs.getInt("c.NumericValue"),rs.getString("c.value"), rs.getInt("c.type")));
			}
		}
}