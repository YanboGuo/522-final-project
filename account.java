package ss;
import java.util.ArrayList;
import ss.shoppingSystem.*;

public class account {
  
	public String username;
	public String password;
		

	public account(String username, String password){
	       this.username = username;
	       this.password = password;
	}
	
	public boolean verify(String pd){
		this.password = pd;
		boolean t = false;
		new shoppingSystem();
		for(account c1 : shoppingSystem.arraylist){
			  if(c1.username == username){
				 if(c1.password == password){
					t = true;
				 }
			  }
		}  	
		return t;		
	}
	
   public boolean find(String id){
		this.username = id;
		boolean t = false;
		
		new shoppingSystem();
		for(account c1 : shoppingSystem.arraylist){
			 t = (c1.username == username) ;							
		}		
		return t;
   }
 
   
   
   
   
}