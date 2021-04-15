import java.awt.Color;

import javax.swing.*;

import java.util.Random;
class NodeG{
	JLabel label;
	NodeG left;
	NodeG right;
}
public class BinaryTreeGui{
	static JFrame frame;
	static JLabel[] l = new JLabel[31];
	public BinaryTreeGui(JFrame frame) {
		this.frame = frame;
	}
	public static NodeG createTree(NodeG parent, int depth, int data, int x, int y) {
		if(depth != 5) {
			parent = new NodeG();
			l[data-1] =new JLabel(Integer.toString(data), JLabel.CENTER);
			l[data-1].setSize(20, 20);
			l[data-1].setLocation(x, y);
			l[data-1].setOpaque(true);
			l[data-1].setBackground(Color.white);
			l[data-1].setVisible(false);
			frame.add(l[data-1]);
			parent.label = l[data-1] ;
			parent.left = createTree(parent.left,depth+1,data*2, x-10*(20/(depth*depth+1)), y+100);
			parent.right = createTree(parent.right,depth+1,data*2+1,x+10*(20/ (depth*depth+1)),y+100);
			return parent;
		}
		else {
			return null;
		}
	}
	public static void main(String[] args) {
		JFrame treeFrame = new JFrame();
		treeFrame.setBounds(100, 100, 1277, 656);
		treeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		treeFrame.getContentPane().setLayout(null);
		
		BinaryTreeGui testTree = new BinaryTreeGui(treeFrame);
		NodeG dispNode = new NodeG();
		dispNode = createTree(dispNode, 0, 1, 500, 10);
		frame.setVisible(true);
		
	}
}

