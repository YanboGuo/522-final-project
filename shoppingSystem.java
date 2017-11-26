import java.util.*;

public class shoppingSystem {
	 
	public static ArrayList<account> arraylist;
	private Scanner scan_register;
	
	public shoppingSystem(){
		arraylist = new ArrayList<account>();
	}
	 
	
	public boolean login(){
		Scanner kb = new Scanner(System.in);//input from keyboard
		
		String ID;
		String password;
		
		System.out.println("Input User ID:");
		ID = kb.nextLine();
		
		System.out.println("Input password:");
		password = kb.nextLine();

		boolean verification = true;
		
		return verification;		
	}
	
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
			new_account.list();
		}
		
		else{
			System.out.println("Username not available. Please select a new username ^-^");
			register();
		}
		//System.out.println(arraylist.size());
		//scan_register.close();
		
	}
	
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
