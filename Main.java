import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws FileNotFoundException{

		Scanner input=new Scanner(System.in);
		int mod,bookSize=0,newBookSize=0,index=0,index1=0,book=0;
		String name,surname,username,password,author;
		String who,select;
		int status=-1,flag=-1;
		ArrayList<Book> libraryBooks=new ArrayList<>();
		ArrayList<Person> systemUsers=new ArrayList<>();

  		System.out.println("########################################################");
  		System.out.println("#            WELCOME TO GTU LIBRARY SYSTEM!            #");
  		System.out.println("########################################################");

		System.out.print("Are you User? Are you Staff?  U/S : ");
		who=input.next();
		Staff newStaff=new Staff("Nur Banu","Albayrak");

		if(who.equals("S") || who.equals("s"))
		{
			System.out.println("Welcome to login of staff!\n");

			while(status==-1)
			{
				System.out.println("For User Register --> 1");
				System.out.println("For Add Book --> 2");
				System.out.println("For Remove Book --> 3");
				System.out.print("--> ");
				mod=input.nextInt();
				
				if(mod==1)
				{
					System.out.println("\nPlease Log İnformations About User!");	
					System.out.print("Name: ");
					name=input.next();
					System.out.print("Surname: ");
					surname=input.next();
					System.out.print("Username: ");
					username=input.next();
					System.out.print("PassWord: ");
					password=input.next();
					System.out.println("REGISTERED!");	
					
					if(newStaff.searchUser(systemUsers,username,password))
						System.err.println("This user already signed up!");
					
					else
					{
						User newUser=new User(name,surname,username,password);	
						systemUsers.add(newUser);
						newStaff.addUser(newUser);
						
						FileWriter fileUser=null;
						try{

							fileUser=new FileWriter("Users.csv",true);
					
							fileUser.append(systemUsers.get(index1).getName());
					    	fileUser.append(';');
					    	fileUser.append(systemUsers.get(index1).getSurName());
					    	fileUser.append(';');
					    	fileUser.append(systemUsers.get(index1).getUserName());
					    	fileUser.append(';');
					    	fileUser.append(systemUsers.get(index1).getPassWord());
					       	fileUser.append('\n');	
					       	fileUser.flush();
					       	++index1;

						}catch(IOException ex) {
					        ex.printStackTrace();
					    }
					}    
				}
				else if(mod==2)
				{
					System.out.println("\nPlease Log İnformations About Book!");
					System.out.print("Book Name: ");
					name=input.next();
					System.out.print("Author Name: ");
					author=input.next();

					Book newBook=new Book(name,author);
					libraryBooks.add(newBook);
					newStaff.addBook(newBook);
					System.out.println("ADDED!");

					FileWriter fileBook=null;
					try{

						fileBook=new FileWriter("Books.csv",true);
						
						fileBook.append(libraryBooks.get(index).getName());
				    	fileBook.append(';');
				    	fileBook.append(libraryBooks.get(index).getAuthor());
				    	fileBook.append(';');
				    	fileBook.append(String.valueOf(libraryBooks.get(index).getBookID()));
				       	fileBook.append('\n');	
				       	fileBook.flush();
				       	++index;

					}catch(IOException ex) {
				        ex.printStackTrace();
				    }
				}	
				else if(mod==3)
				{
					flag=-1;
					new File("Books.csv").delete();
				
					System.out.println("\nPlease Log İnformations About Book Which You Want Remove!");
					System.out.print("Book Name: ");
					name=input.next();
					System.out.print("Author Name: ");
					author=input.next();
					Book returnBook=new Book(name,author);
					FileWriter fileBook1=null;

					try{

						fileBook1=new FileWriter("Books.csv",true);	
						boolean find=newStaff.searchBook(libraryBooks,name);
						System.out.println("REMOVED!");
				
					}catch(IOException ex){
				   	    	ex.printStackTrace();
				    }
					
					++newBookSize;						
				}
				System.out.print("\nDo You Want Go MENU Again? Press 'Y' For YES, Press 'N' For NO : ");
				select=input.next();
				if(!(select.equals("Y") || select.equals("y")))
				{	
					System.out.println("GOOD DAYS!");
					status=0;
				}	
			}	
		}
		else if(who.equals("U") || who.equals("u"))
		{
			System.out.println("Welcome to login of user!");			
			//login yapp
			System.out.print("Username: ");
			name=input.next();
			System.out.print("Password: ");
			password=input.next();
			
			if(newStaff.searchUser(systemUsers,name,password))
			{	
				System.err.println("You don't register!");
			}	
			else
				System.out.println("Hi "+name+"!!");
			
			User newUser=new User(name,password);

			while(status==-1)
			{
				System.out.println("\nFor Borrow Book --> 1");
				System.out.println("For Return Book --> 2");
				System.out.print("--> ");
				mod=input.nextInt();
				if(mod==1)
				{
					System.out.println("\nPlease Log İnformations About Book!");
					System.out.print("Book name: ");
					name=input.next();
					boolean find=newUser.searchBook(libraryBooks,name);
					if(find)
					{
						System.out.println("Sorry! It's taken already.\n");	
					}
					else
						System.out.println("You're lucky, it is your for 30 day!");
				}
				else if(mod==2)
				{
					System.out.println("\nPlease Log İnformations About Book!");
					System.out.print("Book name: ");
					name=input.next();
					boolean find=newUser.searchBook(libraryBooks,name);
					
					if(find)
					{		
						System.out.println("It's already in system!");
					}
					else
					{
						Book returnBook=new Book(name," ");
						libraryBooks.add(returnBook);
						System.out.println("Successfully! You returned it.");

					}	
				}
				System.out.print("\nDo You Want Go MENU Again? Press 'Y' For YES, Press 'N' For NO : ");
				select=input.next();
				if(!(select.equals("Y") || select.equals("y")))
				{	
					System.out.println("GOOD DAYS!");
					status=0;
				}	
			}	
		}
	}
}
