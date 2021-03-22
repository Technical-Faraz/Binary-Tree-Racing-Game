import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class Game {

	private JFrame frame;

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
		initialize();
		BinaryTreeGui BTree = new BinaryTreeGui(frame);
		NodeG n = new NodeG(); 
		n = BTree.createTree(n, 0, 1, 800, 100);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1277, 656);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton leftRB1 = new JRadioButton("LEFT");
		leftRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB1.setBounds(64, 239, 111, 23);
		frame.getContentPane().add(leftRB1);
		
		JRadioButton rightRB1 = new JRadioButton("RIGHT");
		rightRB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB1.setBounds(64, 265, 111, 23);
		frame.getContentPane().add(rightRB1);
		
		JLabel lblNewLabel = new JLabel("Player 1 is at Node ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 203, 172, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel posShow1 = new JLabel("1");
		posShow1.setOpaque(true);
		posShow1.setBackground(Color.BLACK);
		posShow1.setForeground(Color.WHITE);
		posShow1.setHorizontalAlignment(SwingConstants.CENTER);
		posShow1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow1.setBounds(246, 201, 45, 23);
		frame.getContentPane().add(posShow1);
		
		JLabel lblPlayerIs = new JLabel("Player 2 is at Node ");
		lblPlayerIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerIs.setBounds(64, 375, 172, 23);
		frame.getContentPane().add(lblPlayerIs);
		
		JLabel posShow2 = new JLabel("1");
		posShow2.setOpaque(true);
		posShow2.setHorizontalAlignment(SwingConstants.CENTER);
		posShow2.setForeground(Color.WHITE);
		posShow2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		posShow2.setBackground(Color.BLACK);
		posShow2.setBounds(246, 373, 45, 23);
		frame.getContentPane().add(posShow2);
		
		JRadioButton leftRB2 = new JRadioButton("LEFT");
		leftRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftRB2.setBounds(64, 411, 111, 23);
		frame.getContentPane().add(leftRB2);
		
		JRadioButton rightRB2 = new JRadioButton("RIGHT");
		rightRB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightRB2.setBounds(64, 437, 111, 23);
		frame.getContentPane().add(rightRB2);
		
		JButton moveButton = new JButton("Move");
		moveButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		moveButton.setBounds(64, 520, 227, 51);
		frame.getContentPane().add(moveButton);
	}
}
