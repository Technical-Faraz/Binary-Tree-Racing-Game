import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

import java.util.Random;
class Node{
	JLabel number;
	Node left;
	Node right;
}
public class BinaryTreeGui extends JFrame{
	static JLabel[] l = new JLabel[32];
	static JFrame frame;
	public static Node createTree(Node parent, int depth, int data, int x, int y) {
		//If choice get 0 then no node else if 1 or 2 then make new node 
		//This is done to increase the probability of creating node
		if(depth != 5) {
			parent = new Node();
			l[data] =new JLabel();
			l[data].setSize(20, 20);
			l[data].setText(Integer.toString(data));
			l[data].setLocation(x, y);
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
	MyFrame(){
		this.setTitle("JFrame title goes here");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(420,420);
		this.setVisible(true);
		
		ImageIcon image = new ImageIcon("f.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(200,200,200));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setTitle("JFrame title goes here");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);		//580,550
		frame.setVisible(true);
		frame.setLayout(null);
		Node n = new Node();
	
		n=createTree(n,0,1,700,0);
			
//		JLabel l1 =new JLabel();
//		l1.setSize(20, 20);
//		l1.setText("1");
//		l1.setLocation(290, 0);
//		JLabel l2 =new JLabel();
//		l2.setSize(20, 20);
//		l2.setText("2");
//		l2.setLocation(270, 20);
//		frame.add(l1);
//		frame.add(l2);
//		l1.setVisible(true);
	}	

}

