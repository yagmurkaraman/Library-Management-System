import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements  PersonInterface{

	
	private String name=null;
    private String surName=null;
    private String userName=null;
    private String passWord=null;

    /**
    * Person constructor
    */
    public Person(){
    }
    /**
    * Person constructor
    * @param name - name of person
    * @param surName - surname of person
    * @param userName - username of person
    * @param passWord - password of person
    */
    public Person(String name, String surName, String userName, String passWord){

        this.name=name;
        this.surName=surName;
        this.userName=userName;
        this.passWord=passWord;
    }
    /**
    * Person constructor
	* @param userName - username of person
    * @param passWord - password of person
    */ 
    public Person(String userName, String passWord)
    {
    	this.userName=userName;
    	this.passWord=passWord;

    }
    /**
    * Person constructor
	* @param user - class of user
    */ 
    public Person(User user){

        this.name=user.getName();
        this.surName=user.getSurName();
        this.userName=user.getUserName();
        this.passWord=user.getPassWord();
    }
    /**
    * Person constructor
	* @param staff - class of staff
    */ 
    public Person(Staff staff){

        this.name=staff.getName();
        this.surName=staff.getSurName();
        this.userName=staff.getUserName();
        this.passWord=staff.getPassWord();
    }
    /** 
	* get name
	* @return name
    */
    public String getName(){
        return name;
    }
    /** 
	* get surname
	* @return surName
    */
    public String getSurName(){
        return surName;
    }
    /** 
	* get username
	* @return userName
    */
    public String getUserName(){
        return userName;
    }
    /** 
	* get password
	* @return passWord
    */
    public String getPassWord(){
        return passWord;
    }
    /**
    * This method sets name
    * @param name new name
    */
    public void setName(String name){
        this.name=name;
    }
    /**
    * This method sets surname
    * @param surName new surame
    */
    public void setSurName(String surName){
        this.surName=surName;
    }
    /**
    * This method sets username
    * @param userName new username
    */
    public void setUserName(String userName){
        this.userName=userName;
    }
    /**
    * This method sets password
    * @param passWord new password
    */
    public void setPassWord(String passWord){
        this.passWord=passWord;
    }
    public abstract boolean searchBook(ArrayList<Book> books, String bookName);
}	