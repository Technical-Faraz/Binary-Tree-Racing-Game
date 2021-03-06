import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Game {
	//References
	private JFrame frmBinaryTreeRace;
	private NodeG dispNode;
	JRadioButton leftRB1;
	JRadioButton rightRB1;
	JRadioButton leftRB2;
	JRadioButton rightRB2;
	JLabel lblforp1; 
	JLabel lblforp2; 
	JLabel posShow1;
	JLabel posShow2; 
	JButton moveButton;
	ButtonGroup g1;
	ButtonGroup g2; 
	JLabel depth1;
	JLabel depth2;
	
	BinaryTree tree; 
	Node p1;
	Node p2;
	NodeG pd1;
	NodeG pd2;
	private JLabel message;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frmBinaryTreeRace.setVisible(true);
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
		JOptionPane.showMessageDialog(null, "This is the two player game in which the player, who can go into more depth of the binary tree can win the game",
	               "Welcome",1);
		frmBinaryTreeRace = new JFrame();
		frmBinaryTreeRace.setTitle("Binary Tree Race Game By Technical Faraz 19sw05");
		frmBinaryTreeRace.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Data\\Technical Faraz\\Technical Faraz LOGO\\TF simple.png"));
		tree = new BinaryTree();
		BinaryTreeGui BTree = new BinaryTreeGui(frmBinaryTreeRace);
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
		frmBinaryTreeRace.setBounds(100, 100, 1277, 656);
		frmBinaryTreeRace.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmBinaryTreeRace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBinaryTreeRace.getContentPane().setLayout(null);
		
		leftRB1 = new JRadioButton("LEFT");
		leftRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB1.setBounds(64, 239, 111, 23);
		frmBinaryTreeRace.getContentPane().add(leftRB1);
		
		rightRB1 = new JRadioButton("RIGHT");
		rightRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB1.setBounds(64, 265, 111, 23);
		frmBinaryTreeRace.getContentPane().add(rightRB1);
		
		lblforp1 = new JLabel("Player 1 is at Node ");
		lblforp1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblforp1.setBounds(64, 203, 172, 23);
		frmBinaryTreeRace.getContentPane().add(lblforp1);
		
		posShow1 = new JLabel("1");
		posShow1.setOpaque(true);
		posShow1.setBackground(Color.BLACK);
		posShow1.setForeground(Color.WHITE);
		posShow1.setHorizontalAlignment(SwingConstants.CENTER);
		posShow1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow1.setBounds(246, 201, 45, 23);
		frmBinaryTreeRace.getContentPane().add(posShow1);
		
		lblforp2 = new JLabel("Player 2 is at Node ");
		lblforp2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblforp2.setBounds(64, 375, 172, 23);
		frmBinaryTreeRace.getContentPane().add(lblforp2);
		
		posShow2 = new JLabel("1");
		posShow2.setOpaque(true);
		posShow2.setHorizontalAlignment(SwingConstants.CENTER);
		posShow2.setForeground(Color.WHITE);
		posShow2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow2.setBackground(Color.blue);
		posShow2.setBounds(246, 373, 45, 23);
		frmBinaryTreeRace.getContentPane().add(posShow2);
		
		leftRB2 = new JRadioButton("LEFT");
		leftRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB2.setBounds(64, 411, 111, 23);
		frmBinaryTreeRace.getContentPane().add(leftRB2);
		
		rightRB2 = new JRadioButton("RIGHT");
		rightRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB2.setBounds(64, 437, 111, 23);
		frmBinaryTreeRace.getContentPane().add(rightRB2);
		
		moveButton = new JButton("Move");
		moveButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		moveButton.setBounds(64, 520, 227, 51);
		frmBinaryTreeRace.getContentPane().add(moveButton);
		
		g1 = new ButtonGroup();
		g1.add(leftRB1);
		g1.add(rightRB1);
		
		g2 = new ButtonGroup();
		g2.add(leftRB2);
		g2.add(rightRB2);
		
		JLabel lblNewLabel_1 = new JLabel("depth : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(64, 297, 54, 23);
		frmBinaryTreeRace.getContentPane().add(lblNewLabel_1);
		
		depth1 = new JLabel("0");
		depth1.setFont(new Font("Tahoma", Font.BOLD, 18));
		depth1.setBounds(128, 297, 54, 23);
		frmBinaryTreeRace.getContentPane().add(depth1);
		
		JLabel lblNewLabel_1_1 = new JLabel("depth : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(64, 467, 54, 23);
		frmBinaryTreeRace.getContentPane().add(lblNewLabel_1_1);
		
		depth2 = new JLabel("0");
		depth2.setFont(new Font("Tahoma", Font.BOLD, 18));
		depth2.setBounds(128, 467, 54, 23);
		frmBinaryTreeRace.getContentPane().add(depth2);
		
		message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.PLAIN, 30));
		message.setBounds(64, 125, 430, 45);
		frmBinaryTreeRace.getContentPane().add(message);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Data\\Technical Faraz\\TF(MUET)\\FormatFactoryRoll #.png"));
		lblNewLabel_2.setBounds(522, 28, 546, 106);
		frmBinaryTreeRace.getContentPane().add(lblNewLabel_2);
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(((leftRB1.isSelected() || rightRB1.isSelected()) && 
							(leftRB2.isSelected() || rightRB2.isSelected())) ||
							(!leftRB1.isVisible() && !rightRB1.isVisible()) ||
							(!leftRB2.isVisible() && !rightRB2.isVisible()) ) {
						gameplay();
						display();
						
						
					}
					else {
						throw new Exception();
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(frmBinaryTreeRace, "Both player should select the path!",
				               "Can't Move", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	public static void incDepth(JLabel l) {
		int d = Integer.parseInt(l.getText());
		d++;
		l.setText(Integer.toString(d));
	}
	public void gameplay() {
		//Conditions for moving player 1
		if(leftRB1.isSelected()) {
			pd1 = pd1.left;
			p1 = p1.left;
			posShow1.setText(pd1.label.getText());
			incDepth(depth1);
		}
		else if(rightRB1.isSelected()) {
			pd1 = pd1.right;
			p1 = p1.right;
			posShow1.setText(pd1.label.getText());
			incDepth(depth1);
		}
		if(leftRB2.isSelected()) {
			pd2 = pd2.left;
			p2 = p2.left;
			posShow2.setText(pd2.label.getText());
			incDepth(depth2);
		}
		else if(rightRB2.isSelected()) {
			pd2 = pd2.right;
			p2 = p2.right;
			posShow2.setText(pd2.label.getText());
			incDepth(depth2);
		}
		g1.clearSelection();
		g2.clearSelection();
		
	}
	public static boolean isGreaterThan(JLabel l1 , JLabel l2) {
		int c = Integer.parseInt(l1.getText());
		int d = Integer.parseInt(l2.getText());
		return c > d;
	}
	public void display(){
		
		if(pd1.label.getText().equals(pd2.label.getText())) {	//then pd1==pd2 points at some gui node
			pd1.label.setBackground(Color.red);
			pd1.label.setForeground(Color.WHITE);
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
		if(p2.left == null && p2.right == null &&
				p1.left == null && p1.right == null) {
			if(isGreaterThan(depth1,depth2)) {
				message.setText("Player 1 won the Game!");
				JOptionPane.showMessageDialog(null, "Player 1 won the Game!",
			               "Thanks for Playing",1);

			}else if(isGreaterThan(depth2,depth1)) {
				message.setText("Player 2 won the Game!");
				JOptionPane.showMessageDialog(null, "Player 2 won the Game!",
			               "Thanks for Playing",1);

			}else {
				JOptionPane.showMessageDialog(null, "DRAW Game!",
			               "Thanks for Playing",1);

				message.setText("Draw the Game!");
			}
			tree.traverse(tree.n, dispNode);
			
			JOptionPane.showMessageDialog(null, "This game is created by Technical Faraz.Check my Website and Follow us on YouTube, linkedIn and Facebook Page for more informative material",
		               "Follow us on!",1);
			
		}
	}
}
