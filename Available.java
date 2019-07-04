/** Item holds one row of the results of the ItemsAvailable function
 * @author Jasmine Young*/
public class Available
{
	private String code;
	private String description;
	private int quantity;
	
	public Available(String code, String description, int quantity)
	{
		this.code = code;
		this.description = description;
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString()
	{
		return(String.format("ItemCode: %s \tDescription: %s \tUnits Available: %s",this.code,this.description,this.quantity));
	}
}
