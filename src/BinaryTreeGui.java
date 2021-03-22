import java.awt.Color;

import javax.swing.*;

import java.util.Random;
class NodeG{
	JLabel number;
	NodeG left;
	NodeG right;
}
public class BinaryTreeGui{
	static JLabel[] l = new JLabel[32];
	static JFrame frame;
	public BinaryTreeGui(JFrame frame) {
		this.frame = frame;
	}
	public static NodeG createTree(NodeG parent, int depth, int data, int x, int y) {
		//If choice get 0 then no NodeG else if 1 or 2 then make new NodeG 
		//This is done to increase the probability of creating NodeG
		if(depth != 5) {
			parent = new NodeG();
			l[data] =new JLabel(Integer.toString(data), JLabel.CENTER);
			l[data].setSize(20, 20);
			l[data].setLocation(x, y);
			l[data].setOpaque(true);
			l[data].setBackground(Color.white);
			l[data].setVisible(false);
			frame.add(l[data]);
			parent.number = l[data] ;
			parent.left = createTree(parent.left,depth+1,data+data, x-10*(17/(depth*depth+1)), y+100);
			parent.right = createTree(parent.right,depth+1,data+data+1,x+10*(17/ (depth*depth+1)),y+100);
			return parent;
		}
		else {
			return null;
		}
	}
}

