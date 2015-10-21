 public class User {
	 
	 private String userFirstName;
	 private String userSurName;
	 private String userName;
	 private int ID;
	 private int numOfItemsBorrowed=0;
	 private static int nextID=100;
	 
	 public static final int MAX_USERS = 5;
	 public static final int MAX_ITEMS = 3;
	 

	public User(String userFirstName, String userSurName) 
	{
		
		 this.userFirstName = userFirstName;
		 this.userSurName = userSurName;
		 this.ID = ID;
		 this.numOfItemsBorrowed = numOfItemsBorrowed;
	}
		
		public String getName() 
		{
			userName = userFirstName + " " + userSurName;
			return userName;
			
		}
		
		
		public int getID() 
		{
			while (ID<6)
				{
				ID = nextID;
			nextID = nextID + 1;
				}
			return ID;
			
		}
		
		public int getnumOfItemsBorrowed()
		{
			
			return numOfItemsBorrowed;
			
		}
		
		// TODO Auto-generated constructor stub
	

	
	public void incrementItems() 
	{
		if (numOfItemsBorrowed == MAX_ITEMS) 
		{
			
			System.out.println("The user cannot borrow an item from the library because the user has already borrowed " + MAX_ITEMS + " items");
		}
		else 
		     {
			numOfItemsBorrowed = numOfItemsBorrowed + 1;
			System.out.println("The user now has " + numOfItemsBorrowed + " item(s)");
		     }
	return;
	}
	
	public void decrementItems()
	{
		if (numOfItemsBorrowed <= 0)
		    {
			System.out.println("The user cannot return an item to the library because the user has not borrowed any items");
			}
		
		else
        {
			numOfItemsBorrowed = numOfItemsBorrowed - 1;
			System.out.println("The user now has " + numOfItemsBorrowed + " item(s)");
		}
		return;
	}
}