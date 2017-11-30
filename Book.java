import java.util.ArrayList;
import java.util.List;

public class Book{

    private String name;
    private static int bookID=0;
    private String author;
    int size=0;

    public Book(){ }
    /**
    * Book constructor
    * @param name - name of book
    * @param author - author of book
    */
	public Book(String name, String author){
        
        this.name=name;
        this.author=author;
        ++bookID;
        setBookID(bookID);
        ++size;
    }
    /**
    * Book Bopy constructor
    * @param bookCopy - class of book
    */
    public Book(Book bookCopy){

    	this.name=bookCopy.name;
    	this.author=bookCopy.author;
    	this.bookID=bookCopy.bookID;
    }
    /** 
	* get name
	* @return name
    */
    public String getName(){
        return name;
    }
    /**
    * This method sets name
    * @param name - new name
    */
    public void setName(String name){
        this.name=name;
    }
    /** 
	* get author
	* @return author
    */
    public String getAuthor(){
        return author;
    }
    /**
    * This method sets author
    * @param author - new author
    */
    public void setAuthor(String author){
        this.author=author;
    }
    /** 
	* get size
	* @return size
    */
    public int getSize()
    {
    	return size;
    }
     /** 
	* get book Id
	* @return bookID
    */
	public int getBookID(){
        return bookID;
    }
    /**
    * This method sets book Id
    * @param bookID - new bookID
    */
    public void setBookID(int bookID){
        this.bookID=bookID;
    }
}