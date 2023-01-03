package solutions.pratnya.erp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class City implements ErpModel {
	String state;
	String country;
	String pinCode;
	String cityName;
	int id;
}
