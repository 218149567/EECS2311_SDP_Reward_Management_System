package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);	
		
		panel.setLayout(null);
		JLabel inputprompt = new JLabel("Welcome!");
		inputprompt.setBounds(160, 0, 80, 25);
		panel.add(inputprompt);
		
		panel.setLayout(null);
		JLabel nameofuser = new JLabel("Name");
		nameofuser.setBounds(10, 30, 80, 25);
		panel.add(nameofuser);
		
		panel.setLayout(null);
		JLabel Userlabel = new JLabel("Username");
		Userlabel.setBounds(10, 70, 80, 25);
		panel.add(Userlabel);
		
		panel.setLayout(null);
		JLabel Passlabel = new JLabel("Password");
		Passlabel.setBounds(10, 110, 80, 25);
		panel.add(Passlabel);
		
		JTextField nameText = new JTextField(20);
		nameText.setBounds(100,30,165,25);
		panel.add(nameText);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100,70,165,25);
		panel.add(userText);
		
		
		JPasswordField startextpass = new JPasswordField();
		startextpass.setBounds(100, 110, 165, 25);
		panel.add(startextpass);
		
		JButton button = new JButton("Enter");
		button.setBounds(140, 150, 80, 25);
		panel.add(button);
		
		JButton gobackButton = new JButton("Back");
		gobackButton.setBounds(140, 180, 80, 25);
		panel.add(gobackButton);
		
		frame.setVisible(true);
		
	}
}