import java.util.Random;
class Node{
	int number;
	Node left;
	Node right;
}

public class BinaryTree {
	static Random r;
	public static Node createTree(Node parent, int depth, int data, int choice) {
		//If choice get 0 then no node else if 1 or 2 then make new node 
		//This is done to increase the probability of creating node
		if(depth != 5) {
			if(choice == 0) {
				return null;
			}
			else {
				parent = new Node();
				parent.number = data;
				parent.left = createTree(parent.left,depth+1,data+data, r.nextInt(3));
				parent.right = createTree(parent.right,depth+1,data+data+1, r.nextInt(3));
				return parent;
			}
		}
		else {
			return null;
		}
	}
	public static void traverse(Node parent) {
		System.out.println(parent.number);
		if(parent.left != null) {
			traverse(parent.left);
		}
		if(parent.right != null) {
			traverse(parent.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		r = new Random();
		Node n = new Node();
		n = createTree(n, 0, 1, 1);
//		int x = n.right.left.left.number;
//		System.out.println(x);
		traverse(n);
	}
}
