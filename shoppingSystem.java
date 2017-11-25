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

		
		
		return verify();		
	}
	
	
}





