package pck1;

class Node{
	final double value;
	Node[] child;
	
	Node(double value){
		this.value = value;
	}
	
	Node(double value, Node[] child){
		this.value = value;
		this.child = child;
	}
	
	public Node setChild(Node[] child) {
		this.child = child;
		return this;
	}
	
	public double getValue() {
		return value;
	}
	
	boolean hasChild() {
		if(this.child!=null) {
			return true;
		}
		return false;
	}
	
	void showContent() {
		// show All nodes that can be reachable by root
		System.out.println(value);
		
		if(child != null) {
			for(Node node: child) {
				System.out.println(node.getValue());
			}
		}
		
	}

	
	public double sumOfAllNumbers() {
	    double sum = value;
	    if (this.child != null) {
	        for (Node node : child) {
	            sum += node.sumOfAllNumbers();
	        }
	    }
	    return sum;
	}	
	
	public int getChildrenCount() {
		// The number of children in the tree / (Root is not a child)
		int count = 0;
	    if (this.child != null) {
	        for (Node node : child) {
	        	count++;
	            count += node.getChildrenCount();
	        }
	    }
	    return count;
	}
	
	
	public int printValueOfLeaf() {
		int count=0;
	    if (this.child != null) {
	        for (Node node : child) {
	        	if(node.child==null) {
	        		count++;
	        	}else
	        	count+=node.printValueOfLeaf();
	        }
	    }
	    return count;
	}
	
	
}


public class Test{
	public static void main(String[] args) {
		
		
		 Node[] child = {new Node(-1.0), new Node (4.0), new Node(7.0)};
		 Node[] grandChild1 = {new Node(1), new Node (2), new Node(3)};
		 child[1].setChild(grandChild1);
		 
		 
		 Node root = new Node(10.0, child);
		 
		
		root.showContent();
		System.out.println(root.sumOfAllNumbers());
		System.out.println(root.printValueOfLeaf());
		System.out.println(root.getChildrenCount());
	}
}
