
class Node{
	int number;
	Node left;
	Node right;
}

public class BinaryTree {
	public static Node createTree(Node parent, int depth, int data) {
		if(depth != 5) {
			parent = new Node();
			parent.number = data;
			parent.left = createTree(parent.left,depth+1,data+data);
			parent.right = createTree(parent.right,depth+1,data+data+1);
			return parent;
		}
		else {
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node();
		n = createTree(n, 0, 1);
		int x = n.right.left.left.number;
		System.out.println(x);
		
	}
}
