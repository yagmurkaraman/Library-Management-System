import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Staff extends Person {

	private int status=0;
	private int USER_SIZE=0;
	private int BOOK_ID=0;
	private int size=0;
	ArrayList<Book> libraryBooks=new ArrayList<>();
	ArrayList<Person> systemUsers=new ArrayList<>();
	
	
	/**
     * STAFF CONSTRUCTOR
    *
    * @param systemUsers - arraylist of person  
    */
	public Staff(ArrayList<Person> systemUsers){
		this.systemUsers=systemUsers;
	}
	/**
    * STAFF CONSTRUCTOR
    *
    * @param userName - username of staff
    * @param passWord - password off staff
    */
	public Staff(String userName, String passWord){	
        super(userName, passWord);
        this.USER_SIZE=USER_SIZE;
    }
    /**
    * STAFF CONSTRUCTOR
    *
    * @param staff - class of staff
    */
    public Staff(Staff staff){
    	super(staff);
    }
    /** 
	* get systemUsers
	* @return systemUsers
    */
    public List<Person> getSystemUsers(){
        return systemUsers;
    }
    /** 
	* get libraryBooks
	* @return libraryBooks
    */
    public List<Book> getLibraryBooks(){
        return libraryBooks;
    }
    /**
    * Bu method kutuphaneye yeni kitap ekler.
    *
    * @param newBook - add new book to library
    * @return void
    */
    public void addBook(Book newBook){

		getLibraryBooks().add(new Book(newBook));
		++size;
		//setSize(getSize()+1);
    }
    /**
    * This methods sets book size
    * @param bookSize - new size
    */
    public void setSize(int bookSize)
    {
    	size=bookSize;
    }
    /**
    * This methods gets size
    * @return size
    */
    public int getSize()
    {
    	return size;
    }
    /**
    * Bu method sisteme yeni kullanici ekler.
    *
    * @param newUser - add new user to system
    * @return boolean user addable
    */
    public boolean addUser(User newUser){

    	if (!getSystemUsers().contains(newUser)){
        	getSystemUsers().add(new User((User) newUser));
        	
        	return true;
    	}
    	return false;
    }
    /**
    * Bu method kutuphanede kitap arar.
    *
    * @param books - arraylist of library books
    * @param bookName - name book
    * @return boolean book search
    */
    @Override
    public boolean searchBook(ArrayList<Book> books, String bookName)
    {
    	for(int i=0; i<size; ++i)
    	{
    		if((books.get(i).getName()).equals(bookName))
    		{
    			return false;
    		}	
    	}
    	return true;	
    }
    /**
    * Bu method sistemde kullanici arar.
    *
    * @param systemUser - arraylist of system users
    * @param userName - username
    * @param passWord - password
    * @return boolean user search
    */
    public boolean searchUser(ArrayList<Person> systemUser,String userName, String passWord)
    {
    	for(int i=0; i<systemUser.size(); ++i)
    	{
    		if(systemUser.get(i).getName().equals(userName) && systemUser.get(i).getPassWord().equals(passWord))
    		{
    			return true;
    		}	
    	}
    	return false;	
    }
}