package solutions.pratnya.erp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Codes implements ErpModel {
	int id;
	int type;
	String value;
	int numericValue;
}
