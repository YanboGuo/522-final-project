
public class account {
  
	public String ID;
	public String password;
	
	public boolean verify(String pd){
		password = pd;
		
		return false;
		
	}
	
   public boolean find(String id){
		ID = id;
		//search in the tree
		return false;
		
	}
}
