public class Book {
   
	 private String title;
	 private String authorFirstName;
	 private  String authorSurName;
	 private String authorName;
	 private int ID;
	 private char category;
	 
	 
	 public Book(String title, String authorFirstName, String authorSurName, int ID, char category) 
	   {
			
		 this.title = title;
		 this.authorFirstName = authorFirstName;
		 this.authorSurName = authorSurName;
		 this.ID = ID;
		 this.category = category;
		
	   }
	
	public String getTitle() 
	{
		return title;		
	}
	
	
	public String getAuthor()
	     {
		authorName = authorFirstName + " " + authorSurName;
		return authorName;		
	     }
	

	public int getID() 
	{
		return ID;
	}
	
	
    public char getCategory()
              {
	return category;				
              }
	
	
}