import java.util.ArrayList;
import java.util.List;

public class User extends Person{

	protected static int TOTAL_USER_ID = 0;
	private int status=-1;
	ArrayList<Book> borrowedBooks=new ArrayList<>();

	/**
    * User constructor
    * @param name - name of user
    * @param surName - surname of user
    * @param userName - username of user
    * @param passWord - password of user
    */
	public User(String name, String surName, String userName, String passWord){	
        super(name, surName, userName, passWord);
        ++TOTAL_USER_ID;
    }
    /**
    * User copy constructor
    * @param user - class of user
    */
    public User(User user){
    	super(user);
    }
    /**
    * User constructor
    * @param userName - username of person
    * @param passWord - password of person
    */
    public User(String userName, String passWord)
    {
    	super(userName,passWord);
    }
    /**
    * Bu method kitabin borrow yapilabilirligini kontrol eder.
    *
    * @param book - class of book
    * @return boolean borrow book
    */
    public boolean borrowBook(Book book){

    	/* arraylistimde sorun oldugu icin yazamadim */
    	return true;
    }
    /**
    * Bu method kitabin return yapilabilirligini kontrol eder.
    *
    * @param book - class of book
    * @return boolean return book
    */
    public boolean returnBook(Book book){

    	return true;
    }
    /**
    * Bu method kutuphanede kitap arar.
    *
    * @param books - arraylist of books
    * @param bookName - name of book
    * @return boolean search book
    */
    @Override
    public boolean searchBook(ArrayList<Book> books,String bookName)
    {
    	for(int i=0; i<books.size(); ++i)
    	{
    		if(books.contains(bookName))
    		{	
    			Book borrow=new Book(books.get(i).getName(),books.get(i).getAuthor());
    			borrowedBooks.add(borrow);
    			books.remove(i);
    			return true;
    		}
    	}	
    	return false;
    }
    /**
    * Bu method kitap ID ile arama yapar.
    *
    * @param book - class of book
    * @param bookName - name book
    * @param bookID - ID book
    * @return boolean search book
    */
    public int searchBookwID(ArrayList<Book> books,String bookName,int bookID)
    {
    	for(int i=0; i<books.size(); ++i)
    	{
    		if(books.get(i).getName().equals(bookName) && books.get(i).getBookID()==(bookID))
    		{	
    			return -1;
    		}
    	}	
    	return 1;
    }
}