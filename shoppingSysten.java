//import java.lang.*;
import java.util.*;


public class shoppingSysten {
	public static void main(String args[]){
	boolean redo = true;
	Scanner systeminput = new Scanner(System.in);
	shoppingSystem shoppingSysteminstance = new shoppingSystem();
	
	System.out.println("Welcome to the New Era online shopping system");
	System.out.println("Please Select your status: Input 'R' for Register and 'S'for Sign in ");
	while(redo){
	String input = systeminput.nextLine();
	if (input.equals("R")){
		System.out.println("Register");
		shoppingSysteminstance.reister();
		redo = false;
	}
	else if (input.equals("S")){
		System.out.println("Sign in");
		redo = false;
		}
	else{
		System.out.println("wrong input, please re-select 'R' for register or 'S' for sign in");
	}
	}
	systeminput.close();
	}
}
