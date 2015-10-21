public class Item {

	private int id;
	private boolean onLoan;
	private int userID;
	
	
	public Item(int bookID)
	{
		
		id=bookID;
		onLoan=false;
		userID=0;
		
		// TODO Auto-generated constructor stub
	}
	
	public int getID()
	{
		return id;		
	}
	
	public boolean isOnLoan()
	{
		return onLoan;		
	}
	
	public int getUserID()
	{
		return userID;		
	}
	
	public void borrowItem(int userID)
	{
		if(onLoan==true)
		     {
			System.out.println("Item cannot be borrowed because it is already on loan");
		     }
		else 
		{
			onLoan=true;
			this.userID=userID;
			this.id=id;
			
			System.out.println("Item " + id + " has been successfully borrowed by user " + userID);
	    }
	}
public void returnItem()
    {
		if(onLoan==false)
		      {
			System.out.println("This item cannot be returned because it is not on loan.");
		      } 
		
		else
		{
			System.out.println("User " + userID + " has successfully returned the item " + id);
			onLoan=false;
			userID=0;			
		}
		return;
	}
}