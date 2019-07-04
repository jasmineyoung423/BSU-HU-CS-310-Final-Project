/** Item holds one row of the ITEM Table in the database
 * @author Jasmine Young*/
public class Item 
{
	private int ID;
	private String code;
	private String description;
	private double price;
	
	public Item(String code, String description, double price)
	{
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	public Item(int ID, String code, String description, double price)
	{
		this(code, description, price);
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return(String.format("ID: %s \tItemCode: %s \tDescription: %s \tPrice: %s",this.ID,this.code,this.description,this.price));
	}
}
