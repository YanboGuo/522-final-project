//CSE 522: Homework 1, Part 2

  class BST_Part2 {

	  public static void main(String[] args) {
			AbsTree tr = new DupTree(100);
			 tr.insert(50);
			 tr.insert(125);
			 tr.insert(150);
			 tr.insert(25);
			 tr.insert(75);
			 tr.insert(20);	
			 tr.insert(90);
			 tr.insert(50);
			 tr.insert(125);
			 tr.insert(150);
			 tr.insert(25);
			 tr.insert(75);
			 tr.insert(20);	
			 tr.insert(90);
	
			 tr.delete(20);
			 tr.delete(20);
			 tr.delete(20);
			 tr.delete(150);
			 tr.delete(100);
			 tr.delete(150);
			 tr.delete(125);
			 tr.delete(125);
			 tr.delete(50);
			 tr.delete(50);
			 tr.delete(25);
			 tr.delete(50);
			 tr.delete(75);
			 tr.delete(90);
			 tr.delete(25);
			 tr.delete(50);
			 tr.delete(75);
			 tr.delete(90);
		}
  }
  
   abstract class AbsTree {

	public AbsTree(int n) {
		value = n;
		left = null;
		right = null;
	}

	public void insert(int n) {
		if (value == n)
			count_duplicates();
		else if (value < n)
			if (right == null)
				right = add_node(n);
			else
				right.insert(n);
		else if (left == null)
			left = add_node(n);
		else
			left.insert(n);
	}
	
	public void delete(int n) { // assume > 1 nodes in tree
		AbsTree t = find(n);
		
		if (t == null) {  
			System.out.println("Unable to delete " + n + " - - Not in the Tree");
			return;
			// print out error message and return
		}
		
		if(t.get_count() > 1){
			((DupTree)t).count--;
		}
		else{
		
		if (t.left == null && t.right == null) { 
			if (t == this){
				System.out.println("Unable to delete " + n + " - - Tree will become empty");
				return;}
			else {
				case1(t, this);
			    return;}
			// do case1 and return
		}
		
		if (t.left == null || t.right == null) {  
			if (t != this) { 
				case2(t, this);
				return;
				// do case2 and return
			} else {
				if (t.left == null){ 
					case3(t, "right");
				}
				else if (t.right == null){				
					case3(t, "left");
				}
				return;// do case3 and return
			}
		}
		
		if(t.right == null)
			case3(t, "left");
		else
			case3(t,"right");
		return;
		
		}
		// adapt Part 1 solution here
	}
	
	protected void case1(AbsTree t, AbsTree root) {  
		AbsTree t_parent = t.FindParent(root);
		
		if (t_parent.left == t)
			t_parent.left = null;
		else
			t_parent.right = null;
		t.left = null;
		t.right = null;
	}
	
	protected void case2(AbsTree t, AbsTree root) {  
		AbsTree t_parent = t.FindParent(root);
		if (t_parent.left == t)
			t_parent.left = (t.right == null)? t.left : t.right;
		else
			t_parent.right = (t.left == null)? t.right : t.left;
		t.left = null;
		t.right = null;
		
	}
	
	protected void case3(AbsTree t, String side) {  
		if (side == "left"){
			AbsTree max = t.left.max();
			AbsTree max_parent = max.FindParent(t);
			t.value = max.value;
			t.set_count(max.get_count());
			if(max.left == null && max.right == null){
				case1(max, max_parent);
			}
			else{
				case2(max, max_parent);
				max.left = null;
				max.right = null;
			}
			
			
		}
		else{
			AbsTree min = t.right.min();
			AbsTree min_parent = min.FindParent(t);
			t.value = min.value;
			t.set_count(min.get_count());
			if(min.right == null && min.left == null){
				case1(min, min_parent);
			}
			else{
				case2(min, min_parent);
				min.left = null;
				min.right = null;
			}
			
		}
	}

	protected AbsTree find(int n) {
		AbsTree t = this;
		AbsTree t_return = this;
		
		while (t != null){
			t_return = t;
			if (n == t_return.value)
				return t_return;
			else if (n > t_return.value)
				t = t_return.right;
			else
				t = t_return.left;
			}	
		return null;
	}
	
	public AbsTree min() {
		AbsTree t_min = this;
		while (t_min.left != null)
			t_min = t_min.left;		
		return t_min;
	}

	public AbsTree max() {
		AbsTree t_max = this;
		while(t_max.right != null)
			t_max = t_max.right;
		return t_max;
	}
	
	public AbsTree FindParent(AbsTree root) {
		
		AbsTree parent = root;
		while (parent.left != this && parent.right != this){
			
			if (parent.value > this.value){
				parent = parent.left;
			}
			else if (parent.value < this.value){
				parent = parent.right;
			}
			
		}
		return parent;
			
		
		// returns the Tree node which is the parent of Tree node calling this method
	}

	
	protected int value;
	protected AbsTree left;
	protected AbsTree right;

	// Protected Abstract Methods
	
	protected abstract AbsTree add_node(int n);
	protected abstract void count_duplicates();
	protected abstract int get_count();
	protected abstract void set_count(int n);

	// additional protected abstract methods, as needed
}


class Tree extends AbsTree {

	public Tree(int n) {
		super(n);
	}

	protected AbsTree add_node(int n) {
		return new Tree(n);
	}

	protected void count_duplicates() {
		;
	}
	
	protected int get_count(){
		return 1;
	}
	protected void set_count(int n){
		;
	}
	
	// additional protected methods, as needed

}

class DupTree extends AbsTree {

	public DupTree(int n) {
		super(n);
		count = 1;
	};

	protected AbsTree add_node(int n) {
		return new DupTree(n);
	}

	protected void count_duplicates() {
		count++;
	}
	
	protected int get_count(){
		return count;		
			
	}
	protected void set_count(int n){
		count = n;
	}

	// additional protected methods, as needed

	protected int count;
}