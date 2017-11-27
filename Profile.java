import java.util.*;

public class Profile {
	private Scanner profilescanner = new Scanner(System.in);
	String username = null;
	private String password = null;
	String address = null;
	String phonenumber = null;	
	Payment payment = null;
	String email = null;
	account account;
	
	public Profile(String username, String password, account account){
		this.username = username;
		this.password = password;
		this.account = account;
	}
	public void list(){
	System.out.println("Please select a number about what you want to do:");
	System.out.println("1: Update your username");
	System.out.println("2: Update your address");
	System.out.println("3: Update your phone number");
	System.out.println("4: Update your email address");
	System.out.println("5: Change my password");
	System.out.println("6: View my Profile");
	System.out.println("7: Return to last page");
	
	if(profilescanner.hasNextInt()){
		
		int Number = profilescanner.nextInt();
		profilescanner.nextLine();
		if(Number == 1){
			System.out.println("Your current username is: " + this.username);
			System.out.println("Please provide your new username");
			String newusername = profilescanner.nextLine();
			updateUsername(newusername);
			
			
		}
		else if(Number == 2){
			System.out.println("Your current address is: " + this.address);
			System.out.println("Please provide your new address");
			String newaddress = profilescanner.nextLine();
			updateAddress(newaddress);
			
		}
		else if(Number == 3){
			System.out.println("Your current phone number is: " + this.phonenumber);
			System.out.println("Please provide your new phone number");
			String newphoneNo = profilescanner.nextLine();
			updateEmail(newphoneNo);
			
		}
		else if(Number == 4){
			System.out.println("Your current email address is: " + this.email);
			System.out.println("Please provide your new email address");
			String newemail = profilescanner.nextLine();
			updateEmail(newemail);
					
		}
		else if(Number == 5){ 
			updatePassword();
		}
		else if(Number == 6){
			viewMyProfile();
		}
		else if(Number == 7){
			account.list();
		}
		else{
			System.out.println("Please enter the right number");
			this.list();
		}
	}
	else{
		profilescanner.nextLine();
		System.out.println("Please enter the right number");
		this.list();
	}
	}
	
	
	public void updateUsername(String profilename){
		this.username = profilename;
		System.out.println("Username Updated");
		this.list();
		
	}
	public void updateAddress(String address){
		this.address = address;
		System.out.println("Address Updated");
		this.list();
	}
	public void updatePhone(String phonenumber){
		this.phonenumber = phonenumber;
		System.out.println("Phone number Updated");
		this.list();
	}
	public void updateEmail(String email){
		this.email = email; 
		System.out.println("Email Address Updated");
		this.list();
	}
	
	public void updatePassword(){
		
		System.out.println("Please provide your old password");
		String oldpassword = profilescanner.nextLine();
		
		if(oldpassword.equals(this.password)){
			boolean redo = true;
			while(redo){
				System.out.println("Please provide your new password");
				String newpassword1 = profilescanner.nextLine();
				System.out.println("Please re-enter your new password");
				String newpassword2 = profilescanner.nextLine();
				if(newpassword1.equals(newpassword2)){
					this.password = newpassword1;
					redo = false;
				}
			}
		}
		else{
			System.out.println("Password wrong. Cannot change your password");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		this.list();
	}
	public void viewMyProfile(){
		System.out.println("Your username is: " + this.username);
		System.out.println("Your address is: " + this.address);
		System.out.println("Your phone number is: " + this.phonenumber);
		System.out.println("Your email address is: " + this.email);
		this.list();

	}
	
	public void createProfile(){
		System.out.println("Please provide your phone number");
		String phonenumber = profilescanner.nextLine();
		this.phonenumber = phonenumber;
		System.out.println("Please provide your address");
		String address = profilescanner.nextLine();
		this.address = address;
		System.out.println("Please provide your email");
		String email = profilescanner.nextLine();
		this.email = email;
	}
	
}
