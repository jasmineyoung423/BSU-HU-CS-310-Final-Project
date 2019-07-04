import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/** Command Line Interface for the database
 * @author Jasmine Young*/
public class Project {
	//XXX MAIN METHOD
	public static void main(String[] args){

		if (args[0].equals("CreateItem")) {
			if(args.length == 4)
			{
				String itemCode = args[1];
				String description = args[2];
				double price = Double.parseDouble(args[3]);
				tryCreateItem(itemCode, description, price);
        	}
			else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
		} else if (args[0].equals("CreatePurchase")) {
			if(args.length == 3)
			{
				String itemCode = args[1];
				int quantity = Integer.parseInt(args[2]);
				tryCreatePurchase(itemCode, quantity);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
		} else if (args[0].equals("CreateShipment")) {
        	if(args.length == 4)
        	{
        		String itemCode = args[1];
        		int quantity = Integer.parseInt(args[2]);
        		String date = args[3];
        		tryCreateShipment(itemCode, quantity, date);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
		} else if (args[0].equals("GetItems")) {
			if(args.length == 2)
        	{
        		String itemCode = args[1];
	            tryGetItems(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("GetPurchases")) {
        	if(args.length == 2)
        	{
	            String itemCode = args[1];
	            tryGetPurchases(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("GetShipments")) {
        	if(args.length == 2)
        	{
	            String itemCode = args[1];
	            tryGetShipments(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("ItemsAvailable")) {
        	if(args.length == 2)
        	{
	            String itemCode = args[1];
	            tryItemsAvailable(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        }else if (args[0].equals("UpdateItem")) {
        	if(args.length == 3)
        	{
	            String itemCode = args[1];
	            double price = Double.parseDouble(args[2]);
		        tryUpdateItem(itemCode, price);

        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("DeleteItem")) {
        	if(args.length == 2)
        	{
        		String itemCode = args[1];
        		tryDeleteItem(itemCode);

        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("DeletePurchase")) {
        	if(args.length == 2)
        	{
        		String itemCode = args[1];
   	         	tryDeletePurchase(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	}
        } else if (args[0].equals("DeleteShipment")) {
        	if(args.length == 2)
        	{
        		String itemCode = args[1];
   	         	tryDeleteShipment(itemCode);
        	}
        	else
        	{
        		System.out.println("Incorrect number of arguments. See README for usage instructions.");
        	} // args length
        }
        else
        {
        	System.out.println("Invalid Command. See README for usage instructions");
        }
    } // main
	
   //XXX TRY METHODS
	
	/**tryCreateItem has try catch and print results of createItem
	 * @param String code (the item code)
	 * @param String description (the item description)
	 * @param double price (price of the item)*/
	public static void tryCreateItem(String code, String description, double price)
	{
		try
		{
			Item item = createItem(code, description, price);
			System.out.println(item.toString());
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to create item.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryCreatePurchase has try catch and print results of createPurchase
	 * @param String code (the item code)
	 * @param int quantity (quantity of the purchase)*/
	public static void tryCreatePurchase(String code, int quantity)
	{
		try
		{
			Purchase purchase = createPurchase(code, quantity);
			System.out.println(purchase.toString());
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to create purchase.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryCreateShipment has try catch and print results of createShipment
	 * @param String code (the item code)
	 * @param int quantity (quantity of the shipment)
	 * @param String date (date of the shipment YYYY-MM-DD)*/
	public static void tryCreateShipment(String code, int quantity, String date)
	{
		try
		{
			Shipment shipment = createShipment(code, quantity, date);
			System.out.println(shipment.toString());
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to create shipment.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryGetItems has try catch and print results of getItems and getAllItems
	 * @param String code (the item code)*/
	public static void tryGetItems(String code)
	{
		try
		{
			if(code.equals("%"))
			{
				List<Item> items = getAllItems();
				for(Item i : items)
				{
					System.out.println(i.toString());
				}
			}
			else
			{
				Item item = getItems(code);
				System.out.println(item.toString());
				
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to get items.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryGetPurchases has try catch and print results of getPurchases and getAllPurchases
	 * @param String code (the item code)*/
	public static void tryGetPurchases(String code)
	{
		try
		{
			if(code.equals("%"))
			{
				List<Purchase> purchases = getAllPurchases();
				for(Purchase p : purchases)
				{
					System.out.println(p.toString());
				}
			}
			else
			{
				List<Purchase> purchases = getPurchases(code);
				for(Purchase p: purchases)
				{
					System.out.println(p.toString());
				}
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to get purchases.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryGetShipments has try catch and print results of getShipments and getAllShipments
	 * @param String code (the item code)*/
	public static void tryGetShipments(String code)
	{
		try
		{
			if(code.equals("%"))
			{
				List<Shipment> shipments = getAllShipments();
				for(Shipment s : shipments)
				{
					System.out.println(s.toString());
				}
			}
			else
			{
				List<Shipment> shipments = getShipments(code);
				for(Shipment s : shipments)
				{
					System.out.println(s.toString());
				}
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to get shipments.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryItemsAvailable has try catch and print results of getItemsAvailable and getAllItemsAvailable
	 * @param String code (the item code)*/
	public static void tryItemsAvailable(String code)
	{
		try
		{
			if(code.equals("%"))
			{
				List<Available> availables = getAllItemsAvailable();
				for(Available a : availables)
				{
					System.out.println(a.toString());
				}
			}
			else
			{
				Available available = getItemsAvailable(code);
				System.out.println(available.toString());
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to find available items.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryUpdateItem try catch of updateItem
	 * @param String code (the item code)
	 * @param double price (new price of the item)*/
	public static void tryUpdateItem(String code, double price)
	{
		try
		{
			updateItem(code,price);
			System.out.println("Updated Item: " + getItems(code).toString());
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to update item.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryDeleteItem has try catch of deleteItem
	 * @param String code (the item code)*/
	public static void tryDeleteItem(String code)
	{
		try
		{
			deleteItem(code);
			System.out.println("Deleted Item");
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to delete item.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryDeletePurchase has try catch of deletePurchase
	 * @param String code (the item code)*/
	public static void tryDeletePurchase(String code)
	{
		try
		{
			deletePurchase(code);
			System.out.println("Deleted Purchase");
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to delete purchase.");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**tryDeleteShipment has try catch of deleteShipment
	 * @param String code (the item code)*/
	public static void tryDeleteShipment(String code)
	{
		try
		{
			deleteShipment(code);
			System.out.println("Deleted Shipment");
		}
		catch(SQLException sqle)
		{
			System.out.println("Unable to delete shipment.");
			System.out.println(sqle.getMessage());
		}
	}
	
	//XXX PROCEDURE METHODS
	
	/**createItem creates a new ITEM row in the database
	 * @param String code (the item code)
	 * @param String description (the item description)
	 * @param double price (the item price)
	 * @return Item*/
	public static Item createItem(String code, String description, double price) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("INSERT INTO ITEM (ItemCode, ItemDescription, Price) VALUES ('%s','%s','%s');",code,description,price);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		int id = result.getInt(1);
		connection.close();
		return new Item(id,code,description,price);
	}
	
	/**createPurchase creates a new PURCHASE row in the database
	 * @param String code (the item code)
	 * @param int quantity (quantity of the purchase)
	 * @return Purchase*/
	public static Purchase createPurchase(String code, int quantity) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		int itemID = getItems(code).getID();
		String sql = String.format("INSERT INTO PURCHASE (ItemID, Quantity) VALUES ('%s','%s');",itemID,quantity);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		int id = result.getInt(1);
		connection.close();
		return new Purchase(id,itemID,quantity);
	}
	
	/**createShipment creates a new SHIPMENT row in the database
	 * @param String code (the item code)
	 * @param int quantity (quantity of the shipment)
	 * @param String date (date of the shipment YYYY-MM-DD)
	 * @return Shipment*/
	public static Shipment createShipment(String code, int quantity, String date) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		int itemID = getItems(code).getID();
		String sql = String.format("INSERT INTO SHIPMENT (ItemID, Quantity, ShipmentDate) VALUES ('%s','%s','%s');",itemID,quantity,date);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		int id = result.getInt(1);
		connection.close();
		return new Shipment(id,itemID,quantity, date);
	}
	
	/**getItems gets ITEM row from the database based on code param
	 * @param String code (the item code)
	 * @return Item*/
	public static Item getItems(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL get_Item('%s');",code);
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		result.next();
		int id = result.getInt(1);
		String description = result.getString(3);
		double price = result.getDouble(4);	
		connection.close();
		return new Item(id,code,description,price);
	}
	
	/**getAllItems gets all ITEM rows from the database
	 * @return List<Item>*/
	public static List<Item> getAllItems() throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = "SELECT * FROM ITEM;";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		List<Item> items = new ArrayList<Item>();
		while(result.next())
		{
			int id = result.getInt(1);
			String code = result.getString(2);
			String description = result.getString(3);
			double price = result.getDouble(4);
			Item item = new Item(id,code,description,price);
			items.add(item);
		}
		connection.close();
		return items;
	}
	
	/**getPurchases gets all PURCHASE rows from the database based on code param
	 * @param String code (the item code)
	 * @return List<Purchase>*/
	public static List<Purchase> getPurchases(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL get_Purchases('%s');",code);
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		List<Purchase> purchases = new ArrayList<Purchase>();
		while(result.next())
		{
			int id = result.getInt(1);
			int itemID = result.getInt(2);
			int quantity = result.getInt(3);
			String date = result.getString(4);
			Purchase purchase = new Purchase(id,itemID,quantity,date);
			purchases.add(purchase);
		}
		connection.close();
		return purchases;
	}
	
	/**getAllPurchases gets all PURCHASE rows from the database
	 * @return List<Purchase>*/
	public static List<Purchase> getAllPurchases() throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = "SELECT * FROM PURCHASE;";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		List<Purchase> purchases = new ArrayList<Purchase>();
		while(result.next())
		{
			int id = result.getInt(1);
			int itemID = result.getInt(2);
			int quantity = result.getInt(3);
			String date = result.getString(4);
			Purchase purchase = new Purchase(id,itemID,quantity,date);
			purchases.add(purchase);
		}
		connection.close();
		return purchases;
	}
	
	/**getShipments gets all SHIPMENT rows from the database based on code param
	 * @param String code (the item code)
	 * @return List<Shipment>*/
	public static List<Shipment> getShipments(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL get_Shipments('%s');",code);
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		List<Shipment> shipments = new ArrayList<Shipment>();
		while(result.next())
		{
			int id = result.getInt(1);
			int itemID = result.getInt(2);
			int quantity = result.getInt(3);
			String date = result.getString(4);
			Shipment shipment = new Shipment(id,itemID,quantity,date);
			shipments.add(shipment);
		}
		connection.close();
		return shipments;
	}
	
	/**getAllShipments gets all SHIPMENT rows from the database
	 * @return List<Shipment>*/
	public static List<Shipment> getAllShipments() throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = "SELECT * FROM SHIPMENT";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		List<Shipment> shipments = new ArrayList<Shipment>();
		while(result.next())
		{
			int id = result.getInt(1);
			int itemID = result.getInt(2);
			int quantity = result.getInt(3);
			String date = result.getString(4);
			Shipment shipment = new Shipment(id,itemID,quantity,date);
			shipments.add(shipment);
		}
		connection.close();
		return shipments;
	}
	
	/**getItemsAvailable gets Item code and description as well has the quantity of shipments-quantity of purchases of item with code param
	 * @param String code (the item code)
	 * @return List<Available>*/
	public static Available getItemsAvailable(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL get_Available('%s');",code);
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		result.next();
		String description = result.getString(2);
		int quantity = result.getInt(3);	
		connection.close();
		return new Available(code,description,quantity);
	}
	
	/**getItemsAvailable gets all Item code and description as well has the quantity of shipments-quantity of purchases
	 * @return List<Available>*/
	public static List<Available> getAllItemsAvailable() throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL get_All_Available();");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		List<Available> available = new ArrayList<Available>();
		while(result.next())
		{
			String code = result.getString(1);
			String description = result.getString(2);
			int quantity = result.getInt(3);
			Available avail = new Available(code,description,quantity);
			available.add(avail);
		}
		connection.close();
		return available;
	}
	
	/**updateItem updates the price of the item in the database based on code param
	 * @param String code (the item code)
	 * @param double price (new price of the item)*/
	public static void updateItem(String code, double price) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL update_Item('%s','%s');",code,price);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
	}
	
	/**deleteItem deletes the item in the database based on code param
	 * @param String code (the item code)*/
	public static void deleteItem(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("DELETE FROM ITEM WHERE ITEM.ItemCode = '%s';",code);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
	}
	
	/**deletePurchase deletes the most recent Purchase in the database based on code param
	 * @param String code (the item code)*/
	public static void deletePurchase(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL delete_Purchases('%s');",code);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
	}
	
	/**deleteShipment deletes the most recent Shipment in the database based on code param
	 * @param String code (the item code)*/
	public static void deleteShipment(String code) throws SQLException
	{
		Connection connection = null;
		connection = MySqlDatabase.getDatabaseConnection();
		String sql = String.format("CALL delete_Shipments('%s');",code);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
	}
}
