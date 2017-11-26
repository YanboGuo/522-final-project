package ss;
import java.util.ArrayList;
import java.util.Scanner;

import ss.shoppingSystem.*;

public class account {
  
	public String username;
	public String password;
	private Scanner accountscanner = new Scanner(System.in);	
	public Profile profile = null;	

	public account(String username, String password){
	       this.username = username;
	       this.password = password;
	       this.profile = new Profile(username, password, this);
	}
	
	public boolean verify(String pd){
		this.password = pd;
		boolean t = false;
		
		for(account c1 : shoppingSystem.arraylist){	    
			  if(c1.username.equals(username)){
				 if(c1.password.equals(password)){
					t = true;
					break;
				 }
			  }
		}  	
		return t;		
	}
	
   public boolean find(String id){
		this.username = id;
		boolean t = false;
		
		//new shoppingSystem();
		for(account c1 : shoppingSystem.arraylist){
			 if(c1.username.equals(username) ){				 
				 t = true;
				 break;
			 };							
		}		
		return t;
   }

   public account find_account(String id){
		account c = null;										
	for(account c1 : shoppingSystem.arraylist){
		 if(c1.username.equals(id) ){				 
			c = c1;
			 break;
		 };							
	}		
	return c;
  }
  
   public void list(){
	   	System.out.println("Please select a number");
		System.out.println("1: Profile");
		System.out.println("2: Order");
		System.out.println("3: Shopping Cart");
		System.out.println("4: Payment Method");
		System.out.println("5: Home");
		System.out.println("6: Sign out");
		int Number = accountscanner.nextInt();
		switch(Number){
		case 1: this.profile.list();
				break;
		case 2: 
				break;
		case 3: 
				break;
		case 4: 
				break;
		case 5: 
				break;
		case 6: this.Signout();
				break;
		default: this.list();
				break;
		}
		accountscanner.nextLine();

  }
  public void Signout(){
		System.out.println("Thank you for choosing us!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("----------------------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
   
   
   
   
}