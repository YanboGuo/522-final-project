package ss;
import java.util.ArrayList;
import java.util.Scanner;

public class shoppingSystem {
		 
	 public static ArrayList<account> arraylist;
	 
	 public shoppingSystem(){
			arraylist = new ArrayList<account>();
		}
	 	 
	 public void register(){
			String password_final = "None";
			String username = "None";
			
			//get the user name from console
			Scanner scan_register = new Scanner(System.in);
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
				account new_account = new account(username, password_final);
				arraylist.add(new_account);
				System.out.println(arraylist.size());
			}
			else{
				System.out.println("Username not available. Please select a new username ^-^");
				register();
			}

			//scan_register.close();
			
		}
		
		private boolean checkAvailability(String username){
			boolean Availability = false;
			for(account c1 : arraylist){
				if(c1.username.equals(username)){
					Availability = true;
					break;
				}
			}
			return Availability;
		}	     		
	 
	 public void login(){
		 
		 String username;
		 String password;
		 boolean redo1 = true;	
		 account c_temp = null;
		 Scanner kb = new Scanner(System.in);//input from keyboard
		 
		 
		while(redo1){
			
			System.out.println("Input Username:");
			username = kb.nextLine();
			
			System.out.println("Input password:");
	        password = kb.nextLine();
	        
	        account c = new account(username, password);
	        
	        if (c.find(username)){
	        	
	        	if (c.verify(password)){
	        		c_temp = c.find_account(username);
		            redo1 = false;
		            System.out.println("login successfully");
		            break;
		        
	        	}else{System.out.println("password not correct");}
	        	
	        }else{System.out.println("username not found");} 
				        
		}// end while
		
	 } 	 //end login		
}





