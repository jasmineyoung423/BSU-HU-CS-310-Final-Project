/** Item holds one row of the PURCHASE Table in the database
 * @author Jasmine Young*/
public class Purchase
{
	int ID;
	int itemID;
	int quantity;
	String datetime;
	
	public Purchase(int ID, int itemID, int quantity, String datetime)
	{
		this(ID, itemID, quantity);
		this.datetime = datetime;
	}
	public Purchase(int ID, int itemID, int quantity)
	{
		this.ID = ID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.datetime = "DEFAULT";
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getItemID()
	{
		return itemID;
	}
	
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public String getDatetime()
	{
		return datetime;
	}
	
	public void setDatetime(String datetime)
	{
		this.datetime = datetime;
	}
	
	@Override
	public String toString()
	{
		return(String.format("ID: %s \tItemID: %s \tQuantity: %s \tDate: %s",this.ID,this.itemID,this.quantity,this.datetime));
	}
}
