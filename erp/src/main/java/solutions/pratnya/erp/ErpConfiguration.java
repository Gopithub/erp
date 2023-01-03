/**
*This is the configuration class creating the database handle. 
*Not very clear whats the use of setting it in the registration. So have commented it out in run. 
*
 * @author GK
 *
*/

package solutions.pratnya.erp;

import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class ErpConfiguration extends Configuration {

	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();
	/* This is the setter for
	 * @param  DataSourceFactory 
	* @return      void
	* */
	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory factory) {
		this.database = factory;
	}
	/* This is the getter for
	 * @param  None 
	* @return  DataSourceFactory
	* */
	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
}