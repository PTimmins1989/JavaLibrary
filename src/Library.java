import java.util.ArrayList;
import java.util.Scanner;

public class Library {

	public static ArrayList<Book> books;  // an arrayList of books
	public static ArrayList<Item> items;  // an arrayList of items
	public static ArrayList<User> users;  // an arrayList of users
	
	private final static int MAX_USERS = User.MAX_USERS;
	private final static int MAX_CATALOGUE = 10;
	

	/**---------------------------------------------------------------
	 * @return 
	 * @return **/
	 static void initialiseLibrary () 
	 {

		books = new ArrayList<Book>(MAX_CATALOGUE);  
		items = new ArrayList<Item>(MAX_CATALOGUE);  
		users = new ArrayList<User>(MAX_USERS);  

		// Initialise the library catalogue with 5 sample books
		
		books.add(new Book
			("A Tale of Two Cities", "Charles", "Dickens",  11111111, 'F'));
		books.add(new Book
			("The Lord of the Rings", "John R. R.", "Tolkien", 22222222, 'F'));
		books.add(new Book
			("A Brief History of Time", "Stephen", "Hawking",  33333333, 'N'));
		books.add(new Book
			("Java Concepts", "Cay S.", "Horstmann",  44444444, 'N'));
		books.add(new Book
				("Moneyball", "Michael", "Lewis",  55555555, 'S'));
		
		
			
		// Initialise the library catalogue with 5 sample books		
		// Each item in the library catalogue should correspond with a book 
		// in the book array, and appear in the same order in both 
		// arraylists. 
		
		for (int i = 0; i < 5; i++)
		     {
			int bookID = books.get(i).getID();
			items.add(new Item(bookID));
		     } 
		
		// Initialise the library membership with 4 users
		users.add(new User("Joe", "Bloggs"));
		users.add(new User("Bill", "Gates"));		
		users.add(new User("Henry", "Ford"));
		users.add(new User("Grace", "Kelly"));	
	 }
	
	 



	/**---------------------------------------------------------------**/
	public static void main (String[] args) {
	
		initialiseLibrary();
		
	
		Scanner scan = new Scanner(System.in);
		int menuOption = 0;
	
		while (true) 
		     {
			
			clearConsole();	
			
			System.out.println("Please Make a selection:"); 		
			System.out.println("[1] Borrow item"); 			
			System.out.println("[2] Return item"); 
			System.out.println("[3] Search for item(s) in Library"); 			
			System.out.println("[4] Library Administration"); 
			System.out.println("[0] Exit"); 
		
			System.out.print("Enter your choice > "); 		

			menuOption = scan.nextInt();
			
			switch(menuOption) 
			          {
				case 0: System.exit(0);
					break;			
				case 1: borrowItemMenu();
					break;
				case 2: returnItemMenu();
					break;			
				case 3: searchItems();
					break;
				case 4: libraryAdminMenu();
					break;	
				default:
					System.out.print("You have inputted an invalid option. ");
					System.out.println("press enter to continue.");
				//	pauseMe();
					break;
			          }	
			
		      }	
		
	}
	
	private static void searchItems()
	{
	
    System.out.println("This option allows you to search for an item(s) whose title starts with a specific string.");
    System.out.println("Please enter the search string > ");
    Scanner sc = new Scanner(System.in);
    String search = sc.nextLine();
	boolean found = false;
    
	if(search != null && books != null) 
	{
        for (int i = 0; i < books.size(); i++) 
           {
         	if (books.get(i).getTitle().contains(search))
    	         {
    		 int index = i + 1;
    		 found = true;
    		 int ID = users.get(i).getID();
    		 System.out.println("Item " + index + " in library :");
    		 System.out.println(books.get(i).getTitle()); 
    	     System.out.println(books.get(i).getAuthor());
    		 System.out.println(books.get(i).getID());
    		 System.out.println(books.get(i).getCategory());
    		
    		 if(items.get(i).isOnLoan()==true)
    		               {
    		 System.out.println("This item is on loan to UserID : " + ID );
    		               }
    		 
    		    pauseMe();
    		     return;
    		     
    	           }
    	
		    } 
        
        
    if (found!=true)
        {
    	System.out.println("Sorry the title cant be found");
     	pauseMe();
	  return;
        }
	                                 }
	else 
	           {
		System.out.println("Sorry there are no items in the library");
		return;
	           }
	
	
	}

	private static boolean isItemInLibrary(int itemID)
	{
		for (int i=0;i<books.size();i++) 
		{
			if (books.get(i).getID()==itemID)
			     {
		         return true;
			     }
		}
		return false;
		
	}
	
	
	private static boolean isUserInLibrary(int userID)
	{
		for (int i=0;i<users.size();i++) 
		{
			if (users.get(i).getID()==userID)
			      {
		          return true;
			      }
					}
		return false;		
	}


	/**---------------------------------------------------------------**/
	private static void clearConsole() 
	{
		for (int i=0; i < 100; i++)
		{
			System.out.println("");
		}
	}	
	
	/**---------------------------------------------------------------**/
	private static void pauseMe()
	{
		Scanner scan = new Scanner(System.in);		
		System.out.println("press enter to continue.");		
		scan.nextLine();
				
	}

	/**---------------------------------------------------------------**/
	public static void borrowItemMenu()
	{
	
		if (users.size() <= 0)
		{
		clearConsole();
		System.out.println("The library membership is empty. ");	
		pauseMe();
		return;
		}
		
		if (items.size() <= 0) 
		      {
			clearConsole();
			System.out.println("The library catalogue is empty. ");	
			System.out.println("There are no items available to lend. ");
			pauseMe();
			return;
		      }
		
		Scanner scan = new Scanner(System.in);
		int menuOption = 0;

		while (true) 
		  {		
			clearConsole();
			System.out.println("Please Make a selection:"); 		
			System.out.println("1.[1] Borrow item from Library "); 
			System.out.println("1.[2] List all items in Library"); 	
			System.out.println("1.[3] Return to previous menu"); 		
			System.out.print("Enter your choice > "); 			

			menuOption = scan.nextInt();
			
			switch(menuOption) 
			       {	
				case 1: borrowItemFromLibrary();
					break;
				case 2: printItems();
					break;			
				case 3: return;
				default:
					System.out.print("You have inputted an invalid option. ");
					pauseMe();
					break;
					
			       }
				 	
		   }
		
	}

	private static void borrowItemFromLibrary()
	{
		Scanner sc = new Scanner(System.in);
		int IDindex = 0;
		// TODO Auto-generated method stub
		System.out.println("Enter Item ID of item to borrow>");
		int ItemID = sc.nextInt();
		System.out.println("Enter User ID of user (borrower)>");
		int userID = sc.nextInt();
		
		isItemInLibrary(ItemID);
		items.get(IDindex).isOnLoan();
		isUserInLibrary(userID);
		
		  for (int i=0;i<items.size();i++)
   	        {
   	         if (items.get(i).getID()==ItemID)
   	              {
   	               IDindex = i; 
   	              }
   	   
   	       }
		
		if(isItemInLibrary(ItemID)==true && isUserInLibrary(userID)==true)
		         {
		          if (items.get(IDindex).isOnLoan()==false)
		                {
		            items.get(IDindex).borrowItem(userID);
		            users.get(IDindex).incrementItems();
		                      }
		          
		                  else 
		                      {
		             System.out.println("Item cannot be borrowed because it is already on loan");
		                      }
		
				pauseMe();
	             }
		  return;	
	}
		
	





	private static void printItems() 
	{
		
		int size = books.size();
		System.out.println("The Library has " + size + " items.");
		System.out.println("");
				
		for (int i = 0; i < size; i++)
		     {
	        String title = books.get(i).getTitle();
	          String author = books.get(i).getAuthor();
			  int bookID = books.get(i).getID();
			  char category = books.get(i).getCategory();
			  int index = i + 1;
			  System.out.println("Item " + index + " in library:");
			  System.out.println(title); 
			  System.out.println(author);
			  System.out.println(bookID);
			  System.out.println(category);
					pauseMe();
		      }
      return;

     }


	/**---------------------------------------------------------------**/
	public static void returnItemMenu()
	{
	
		if (users.size() <= 0)
		{
			clearConsole();
			System.out.print("The library membership is empty. ");	
			System.out.println("Therefore, there are no items to return. ");
			pauseMe();
			return;
		}
		
		if (items.size() <= 0)
		    {
			clearConsole();
			System.out.println("The library catalogue is empty. ");	
			System.out.println("Therefore, there are no items to return. ");
			pauseMe();
			return;
		    }		
		
		Scanner scan = new Scanner(System.in);
		int menuOption = 0;

		while (true)
		   {		
			clearConsole();
			System.out.println("Please Make a selection:"); 		
			System.out.println("2.[1] Return item to Library."); 
			System.out.println("2.[2] List all items in Library."); 	
			System.out.println("2.[3] Return to previous menu."); 		
			System.out.print("Enter your choice > "); 			

			menuOption = scan.nextInt();
		
			switch(menuOption)
			       {	
				case 1: returnItemToLibrary();
					break;
				case 2: printItems();
					break;			
				case 3: return;
				default:
					System.out.print("You have inputted an invalid option. ");
					pauseMe();
					break;
					
					}
					
		    }
		
	}		
	
	private static void returnItemToLibrary()
	{
		
		int IDindex = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter item ID of item to return:");
		int ItemID = scan.nextInt();
				
		isItemInLibrary(ItemID);
		
		 for (int i=0;i<items.size();i++)
	   	   {
	   	     if (items.get(i).getID()==ItemID)
	   	        {
	   	       IDindex = i; 
	   	        }
	   	   }
		 
		  items.get(IDindex).isOnLoan();
		  
		if(isItemInLibrary(ItemID)==true && items.get(IDindex).isOnLoan()==true);
		        {		  
		         items.get(IDindex).returnItem();
		         users.get(IDindex).decrementItems();
			 		
		          pauseMe();
	            }
		
		return;	
		
	}





	/**---------------------------------------------------------------**/
	public static void libraryAdminMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int menuOption = 0;

		while (true)
		{		
			clearConsole();
			System.out.println("Please Make a selection:"); 		
			System.out.println("4.[1] Add Item."); 
			System.out.println("4.[2] Delete Item."); 
			System.out.println("4.[3] List Items."); 
			System.out.println("4.[4] List Users."); 				
			System.out.println("4.[5] Return to previous menu."); 		
			System.out.print("Enter your choice > "); 			

			menuOption = scan.nextInt();
			
			switch(menuOption) 
			   {	
				case 1: 	addItem();
					break;
				case 2: 	deleteItem();
					break;	
				case 3: 	printItems();
					break;
				case 4: 	printUsers();
					break;
				case 5: return;					
				default:
					System.out.print("You have inputted an invalid option. ");
					pauseMe();
					break;
			   }
			
		  }
		
	}





	private static void deleteItem() 
	{
				
		if (items != null)
		  {
				
		     Scanner sc = new Scanner(System.in);
		     System.out.println("Enter ID of item to be deleted >");
		     int ID = sc.nextInt();
		
		
			isItemInLibrary(ID);
			
	    	if (isItemInLibrary(ID)==true)
	    	      {
	    		
	    		   for (int i=0;i<items.size();i++)
	    		       {
	    		     if(items.get(i).getID()==ID | books.get(i).getID()==ID )
	    		              {
	    		         items.remove(i);
	    	             books.remove(i);
	    		              }
	    		        }
	    	       }
	    	
	    
			
			
		     System.out.println("Item " + ID + " was successfully deleted.");
		     System.out.println("");
		     
			 pauseMe();
		 }
			  else 
			   {
			System.out.println("The library catalogue is empty.");
			   }
		return;
	 }
	




	private static void addItem()
	{
				
		if (items.size()>=MAX_CATALOGUE)
		                   {
			System.out.println("The library catalogue is full. The library limit is " + MAX_CATALOGUE + " Items.");
		                   }
		else
		{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter title of Item >");
		String title = scan.nextLine();
		System.out.println("Enter first name of author >"); 
		String fname = scan.nextLine();
		System.out.println("Enter surname of author >"); 
		String lname = scan.nextLine();
		System.out.println("Enter Item ID >");
		int ID = scan.nextInt();
		System.out.println("Enter category of item [F]iction,[N]on-fiction,[B]iography,[S]ort >"); 				
		char category = scan.next().charAt(0);
		
		books.add(new Book
				(title,fname,lname,ID,category));
		
		System.out.println("Item " + ID + " successfully added to library"); 		
		pauseMe(); 
		
		}
	return;
	}





	private static void printUsers() 
	    {
	
		int size = users.size();
		System.out.println("The Library has " + size + " items.");
		System.out.println("");
				
		for (int i = 0; i < users.size(); i++) 
		      {
	          String name = users.get(i).getName();
	          int ID = users.get(i).getID();
			  int borroweditems = users.get(i).getnumOfItemsBorrowed();
			  int index = i + 1;
			  
			  System.out.println("User: " + index + " in library:");
			  System.out.println("Name: " + name); 
			  System.out.println("ID: " + ID);
			  System.out.println("Number of Borrowed Items: " + borroweditems);
			  System.out.println(" ");
			
					pauseMe();
					
			  }
		return;
	
	     }
		
}



	
	
	// Your code goes here...
	
	

