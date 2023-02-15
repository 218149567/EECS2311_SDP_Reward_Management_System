package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandingPageUser {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);	
		//
		frame.setVisible(true);
		//
		panel.setLayout(null);
		JLabel typeofviewuser = new JLabel("Userss View");
		typeofviewuser.setBounds(220, 0, 80, 25);
		panel.add(typeofviewuser);
		
		JButton lPageButtonUser = new JButton("button");
		lPageButtonUser.setBounds(350, 50, 80, 25);
		panel.add(lPageButtonUser);

	}
}
