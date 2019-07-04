/** Item holds one row of the SHIPMENT Table in the database
 * @author Jasmine Young*/
public class Shipment
{
	int ID;
	int itemID;
	int quantity;
	String date;
	
	public Shipment(int ID, int itemID, int quantity, String date)
	{
		this.ID = ID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.date = date;
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
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	@Override
	public String toString()
	{
		return(String.format("ID: %s \tItemID: %s \tQuantity: %s \tDate: %s",this.ID,this.itemID,this.quantity,this.date));
	}
}
