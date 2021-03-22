import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game {
	//References
	private JFrame frame;
	private NodeG dispNode;
	JRadioButton leftRB1;
	JRadioButton rightRB1;
	JRadioButton leftRB2;
	JRadioButton rightRB2;
	JLabel lblNewLabel; 
	JLabel lblPlayerIs; 
	JLabel posShow1;
	JLabel posShow2; 
	JButton moveButton;
	ButtonGroup g1;
	ButtonGroup g2; 
	
	BinaryTree tree; 
	Node p1;
	Node p2;
	NodeG pd1;
	NodeG pd2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		frame = new JFrame();
		tree = new BinaryTree();
		BinaryTreeGui BTree = new BinaryTreeGui(frame);
		dispNode = new NodeG();
		dispNode = BTree.createTree(dispNode, 0, 1, 800, 150);
		dispNode.label.setVisible(true);
		initialize();
//		tree.traverse(tree.n, dispNode);
		p1 = tree.n;
		p2 = tree.n;
		pd1 = dispNode;
		pd2 = dispNode;
		display();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 1277, 656);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		leftRB1 = new JRadioButton("LEFT");
		leftRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB1.setBounds(64, 239, 111, 23);
		frame.getContentPane().add(leftRB1);
		
		rightRB1 = new JRadioButton("RIGHT");
		rightRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB1.setBounds(64, 265, 111, 23);
		frame.getContentPane().add(rightRB1);
		
		lblNewLabel = new JLabel("Player 1 is at Node ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 203, 172, 23);
		frame.getContentPane().add(lblNewLabel);
		
		posShow1 = new JLabel("1");
		posShow1.setOpaque(true);
		posShow1.setBackground(Color.BLACK);
		posShow1.setForeground(Color.WHITE);
		posShow1.setHorizontalAlignment(SwingConstants.CENTER);
		posShow1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow1.setBounds(246, 201, 45, 23);
		frame.getContentPane().add(posShow1);
		
		lblPlayerIs = new JLabel("Player 2 is at Node ");
		lblPlayerIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerIs.setBounds(64, 375, 172, 23);
		frame.getContentPane().add(lblPlayerIs);
		
		posShow2 = new JLabel("1");
		posShow2.setOpaque(true);
		posShow2.setHorizontalAlignment(SwingConstants.CENTER);
		posShow2.setForeground(Color.WHITE);
		posShow2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow2.setBackground(Color.blue);
		posShow2.setBounds(246, 373, 45, 23);
		frame.getContentPane().add(posShow2);
		
		leftRB2 = new JRadioButton("LEFT");
		leftRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB2.setBounds(64, 411, 111, 23);
		frame.getContentPane().add(leftRB2);
		
		rightRB2 = new JRadioButton("RIGHT");
		rightRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB2.setBounds(64, 437, 111, 23);
		frame.getContentPane().add(rightRB2);
		
		moveButton = new JButton("Move");
		moveButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		moveButton.setBounds(64, 520, 227, 51);
		frame.getContentPane().add(moveButton);
		
		g1 = new ButtonGroup();
		g1.add(leftRB1);
		g1.add(rightRB1);
		
		g2 = new ButtonGroup();
		g2.add(leftRB2);
		g2.add(rightRB2);
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay();
				display();
			}
		});
	}
	public void gameplay() {
		//Conditions for moving player 1
		if(leftRB1.isSelected()) {
			pd1 = pd1.left;
			p1 = p1.left;
			posShow1.setText(pd1.label.getText());
		}
		else if(rightRB1.isSelected()) {
			pd1 = pd1.right;
			p1 = p1.right;
			posShow1.setText(pd1.label.getText());
		}
		if(leftRB2.isSelected()) {
			pd2 = pd2.left;
			p2 = p2.left;
			posShow2.setText(pd2.label.getText());
		}
		else if(rightRB2.isSelected()) {
			pd2 = pd2.right;
			p2 = p2.right;
			posShow2.setText(pd2.label.getText());
		}
		g1.clearSelection();
		g2.clearSelection();
		
	}
	public void display() {
		
		if(pd1.label.getText().equals(pd2.label.getText())) {
			pd1.label.setBackground(Color.red);
			pd1.label.setForeground(Color.WHITE);
			pd2.label.setBackground(Color.red);
			pd2.label.setForeground(Color.WHITE);

		}else {
			if(pd1.label.getText().equals(Integer.toString(p1.number)) ) {
				pd1.label.setOpaque(true);
				pd1.label.setBackground(Color.black);
				pd1.label.setForeground(Color.WHITE);
			}
			if(pd2.label.getText().equals(Integer.toString(p2.number))) {
				pd2.label.setBackground(Color.blue);
				pd2.label.setForeground(Color.WHITE);
			}
		}
		//Conditions to in display if there is way for p1
		if(p1.left != null) {
			pd1.left.label.setVisible(true);
			leftRB1.setVisible(true);
		}else {
			leftRB1.setVisible(false);
		}
		if(p1.right != null) {
			pd1.right.label.setVisible(true);
			rightRB1.setVisible(true);
		}else {
			rightRB1.setVisible(false);
		}
		//Conditions to in display if there is way for p2
		if(p2.left != null) {
			pd2.left.label.setVisible(true);
			leftRB2.setVisible(true);
		}else {
			leftRB2.setVisible(false);
		}
		if(p2.right != null) {
			pd2.right.label.setVisible(true);
			rightRB2.setVisible(true);
		}else {
			rightRB2.setVisible(false);
		}
	}
}
