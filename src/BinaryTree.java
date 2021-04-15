import java.util.Random;
class Node{
	int number;
	Node left;
	Node right;
}

public class BinaryTree {
	static Random r;
	Node n;
	BinaryTree(){
		r = new Random();
		n = createTree(n, 0, 1, 1);
	}
	public static Node createTree(Node parent, int depth, int data, int choice) {
		//If choice get 0 then no node else if 1 or 2 then make new node 
		//This is done to increase the probability of creating node
		//when choice == 0 then don't create a node
		//if choice == 1 OR 2 then create new node	1/3 and 2/3 chances of no node or a node respectively.
		if(depth != 5) {
			if(choice == 0) {
				return null;
			}
			else {
				parent = new Node();
				parent.number = data;
				parent.left = createTree(parent.left,depth+1,data*2, r.nextInt(3));
				parent.right = createTree(parent.right,depth+1,data*2+1, r.nextInt(3));
				return parent;
			}
		}
		else {
			return null;
		}
	}
	public static void traverse(Node parent, NodeG dispNode) {
		//System.out.println(parent.number);
		dispNode.label.setVisible(true);
		if(parent.left != null) {
			traverse(parent.left,dispNode.left);
		}
		if(parent.right != null) {
			traverse(parent.right,dispNode.right);
		}
	}
}
