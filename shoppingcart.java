import java.util.*;
public class shoppingcart {
	Map<products, Integer> SCmap;
	public shoppingcart(){
		SCmap = new HashMap<products, Integer>();
	}
	public void addtocart(products PD, int quantity){
		SCmap.put(PD, quantity);
	}
	public void editcart(){
		
	}
	public void viewcart(){
		
	}
	public void placeOrder(){
		
	}

}
