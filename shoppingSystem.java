import java.util.*;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class shoppingSystem {
	 
	public static ArrayList<account> arraylist;
	public static Home web = new Home();
	private Scanner scan_register;
	
	public shoppingSystem(){
		arraylist = new ArrayList<account>();
	}
	
public void runSystem(){
	
	products p1 = new products("Apple",2.0);
	products p2 = new products("Orange",3.6);
	products p3 = new products("Pear",4.3);
	products p4 = new products("Grape",2.7);
	products p5 = new products("Watermelon",2.6);
	products p6 = new products("Peach",5.8);
	web.addproduct(p1);
	web.addproduct(p2);
	web.addproduct(p3);
	web.addproduct(p4);
	web.addproduct(p5);
	web.addproduct(p6);
}
	 // ////////////////////////////////////////////

 public void login(){
		 
		 String username;
		 String password;
		 boolean redo1 = true;	
		 account c_temp = null;
			 
		 
		while(redo1){
			
			System.out.println("Input Username:");
			username = scan_register.nextLine();
			
			System.out.println("Input password:");
	        password = scan_register.nextLine();
	        
	       c_temp = find(username);
	        if (c_temp != null){	        	
	        	if (c_temp.verify(password)){	        		
		            redo1 = false;
		            System.out.println("login successfully");
		            web.setaccount(c_temp);
		            c_temp.list();
		        
	        	}else{System.out.println("password not correct");
	        			c_temp = null;
	        			}
	        	
	        }else{System.out.println("username not found");} 
				        
		}// end while
		
	 } 	 //end login	
  @Requires("checkuser != null")
  @Ensures("arraylist != null")
 	public account find(String checkuser){
 		account findaccount = null;
 		for(account c : arraylist){
 			if(c.username.equals(checkuser)){
 				findaccount = c;
 			} 			
 		}
 		
 		return findaccount;
 	}
	// //////////////////////////////////////////////////
 	@Requires("true")
 	@Ensures({"arraylist.size() = old(arralylist.size()) + 1 "})
	public void register(){
		String password_final = "None";
		String username = "None";
		
		scan_register = new Scanner(System.in);
		boolean usernameconfirm = false;
		while(!usernameconfirm){
			System.out.print("Please provide a username:");
			username = scan_register.nextLine();
		
			boolean entercorrect = false;
			while(!entercorrect){
				System.out.println("Do you confrim your username as:" + username +"?" + "Please answer 'Y' for yes or 'N' for no");
				String checkinput = scan_register.nextLine();
					if(checkinput.equals("Y")){
						usernameconfirm = true;
						entercorrect = true;
					}
					else if(checkinput.equals("N")){
						entercorrect = true;
					}
					else{
						System.out.println("Wrong input. Do you confirm your username? Please enter 'Y' or 'N'.");
					
					}
				}
			}

		
		//get the password from console
		boolean passwordcorrect = false;
		while(!passwordcorrect){
			System.out.println("Please provide a password");
			String password_first = scan_register.nextLine(); 
			System.out.println("Please reenter your password");
			String password_second = scan_register.nextLine();
			if(password_second.equals(password_first)){
				passwordcorrect = true;
				password_final = password_second;
				}
			else{
				System.out.println("Two password don't match. Please enter your password again");
			}
		}
		
		//create new account.
		if(checkAvailability(username) == false){
			System.out.println("New Account created");
			account new_account = new account(username, password_final);
			arraylist.add(new_account);
			new_account.profile.createProfile();
			web.setaccount(new_account);
			new_account.list();
		}
		
		else{
			System.out.println("Username not available. Please select a new username ^-^");
			register();
		}
		//System.out.println(arraylist.size());
		//scan_register.close();
		
	}
	
	
	 @Requires({"username != null","arraylist != null" })
	 @Ensures("type(result) == boolean")
	private boolean checkAvailability(String username){
		boolean Availability = false;
		for(account c1 : arraylist){
			if(c1.username.equals(username)){
				System.out.println(c1.username);
				Availability = true;
				break;
			}
		}
		return Availability;
	}
	
	
}
