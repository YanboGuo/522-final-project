//import java.lang.*;
import java.util.*;
//import java.io.*;

public class shoppingSysten {
	static shoppingSystem shoppingSysteminstance = new shoppingSystem();
	private static Scanner systeminput;
	public static void main(String args[]){
		while(true){
		systeminput = new Scanner(System.in);
		boolean redo = true;
					
		
		System.out.println("Welcome to the New Era online shopping system");
		System.out.println("Please Select your status: Input 'R' for Register and 'S'for Sign in ");
				
		redo= true;
		while(redo){
			System.out.println("-----------");			
			String input = systeminput.nextLine();
			if (input.equals("R")){
				System.out.println("Register");
				shoppingSysteminstance.register();
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
	
		}
		
		
	}
}
