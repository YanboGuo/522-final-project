import java.util.*;
public class account {
	private Scanner accountscanner = new Scanner(System.in);
	public String username = null;
	public String password = null;
	public Profile profile = null;
	public shoppingcart SC = null;
	
	
	public account(String username, String password){
		this.username= username;
		this.password = password;
		this.profile = new Profile(username, password, this);
		this.SC = new shoppingcart();
	}
	
	public boolean verify(String pd){
		boolean answer = false;
		if(this.password.equals(pd)){
			answer = true;
		}
		return answer;		
	}

   public void list(){
	   	System.out.println("Please select a number");
		System.out.println("1: Profile");
		System.out.println("2: Order");
		System.out.println("3: Shopping Cart");
		System.out.println("4: Payment Method");
		System.out.println("5: Home");
		System.out.println("6: Sign out");
		if(accountscanner.hasNextInt()){
			int Number = accountscanner.nextInt();
			accountscanner.nextLine();
			if(Number == 1){
				this.profile.list();}
			else if(Number == 2){			
				}
			else if(Number == 5){
				shoppingSystem.web.list();
			}
		
			else if(Number == 6){
				this.Signout();
				}
			
					
			else{ 
				
				System.out.println("Please enter the right number");
				this.list();
				
				}
		}
		
		else{
			accountscanner.nextLine();
			System.out.println("Please enter the right number");
			this.list();
		}

   }
   public void Signout(){
		System.out.println("Thank you for choosing us!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("----------------------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
