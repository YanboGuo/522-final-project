import java.util.*;

public class Home {
	public ArrayList<products> productlist;
	private Scanner scanhome = new Scanner(System.in);
	public account Account = null;
	public Home(){
		productlist = new ArrayList<products>();
		
	}
	
	public void listproducts(){
		int n = 0;
		for(products p1: this.productlist){
			System.out.println("ID: " + n + "|| The product is: " + p1.name + "|| The price of " + p1.name + " is " + p1.unitprice);
			n++;}
		}
	public void buyproducts(){
		System.out.println("Please enter the product ID to add to shopping cart or enter B to return to Home page");
		if(scanhome.hasNextInt()){
			int ProdID = scanhome.nextInt();
			scanhome.nextLine();
			if(ProdID < productlist.size()){
				products NewPD = productlist.get(ProdID);		
				System.out.println("How many do you want?");
				int quantity = scanhome.nextInt();
				scanhome.nextLine();
				Account.SC.addtocart(NewPD, quantity);
				System.out.println("Are you done buying products? Please answer Y or N");
				String response = scanhome.nextLine();
				
				if(response.equals("N")){
					this.buyproducts();
				}
				else{
					this.list();
				}
				
			}
			else{
				System.out.println("Please enter the right number");
				this.list();
				
			}
		
		}
		
		else if(scanhome.nextLine().equals("B")){
			System.out.println("Returned to Home page.");
			System.out.println(" ");
			this.list();
		}
		else{
			
			scanhome.nextLine();
			System.out.println("Wrong input. Please select what you want to do");
			this.list();
		}
		
		
		
	}
			
	public void setaccount(account Acc){
		this.Account = Acc;
	}
	
	public void list(){
		System.out.println("Please select what you want to do:");
		System.out.println("1: Show products list");
		System.out.println("2: Return to account Page");
		System.out.println("3: Go to shopping cart");
		System.out.println("4: Sign out");
		
		if(scanhome.hasNextInt()){
			int Number = scanhome.nextInt();
			scanhome.nextLine();
			if(Number ==1){
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				this.listproducts();
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				this.buyproducts();
			}
			else if(Number == 2){
				this.Account.list();
			}
			else if(Number == 3){
				
			}
			else if(Number == 4){
				this.Account.Signout();
			}
			else {
				this.list();
			}
		}
		
		else{
			System.out.println("Please select the right number");
			this.list();
		}
	}
	public void addproduct(products newProd){
		this.productlist.add(newProd);
	}
}
