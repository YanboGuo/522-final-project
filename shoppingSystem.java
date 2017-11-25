import java.util.Scanner;

public class shoppingSystem {
	
	 public String ID;
	 public String password;
    
	 Scanner kb = new Scanner(System.in);//input from keyboard
	 
	 
	
	public boolean login(){
		
		System.out.println("Input User ID:");
		ID = kb.nextLine();
		
		System.out.println("Input password:");
		password = kb.nextLine();

		boolean verification = true;
		
		return verification;		
	}
	
	public void reister(){
		String password_final = "None";
		String username = "None";
		
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
		
		System.out.println(username+" "+ password_final);
		scan_register.close();
		
	}
}
