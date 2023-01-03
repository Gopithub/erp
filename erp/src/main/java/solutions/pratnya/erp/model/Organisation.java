package solutions.pratnya.erp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Organisation implements ErpModel {
	int id;
	String name;
	String address1;
	String address2;
	City city;
}
