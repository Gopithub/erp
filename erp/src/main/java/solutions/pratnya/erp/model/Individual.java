package solutions.pratnya.erp.model;

import org.jdbi.v3.core.mapper.Nested;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Individual implements ErpModel {
	@ColumnName("ID")
	int id;
	@ColumnName("FirstName")
	String firstName;
	@ColumnName("LastName")
	String lastName;
	@Nested Organisation organisation;
	@ColumnName("Address1")
	String address1;
	@ColumnName("Address2")
	String address2;
	@Nested City city;
	@Nested Codes type;
}
