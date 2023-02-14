package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupGUI {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);	
		
		panel.setLayout(null);
		JLabel inputprompt = new JLabel("Sign Up");
		inputprompt.setBounds(180, 0, 80, 25);
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
		
		panel.setLayout(null);
		JLabel Passlabel2 = new JLabel("Password Again");
		Passlabel2.setBounds(10, 150, 800, 25);
		panel.add(Passlabel2);
		
		JTextField nameText = new JTextField(20);
		nameText.setBounds(120,30,165,25);
		panel.add(nameText);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(120,70,165,25);
		panel.add(userText);
		
		JTextField firstPasswordtextbox = new JTextField(20);
		firstPasswordtextbox.setBounds(120, 110, 165, 25);
		panel.add(firstPasswordtextbox);
		
		JPasswordField secondpasswordBox = new JPasswordField();
		secondpasswordBox.setBounds(120, 150, 165, 25);
		panel.add(secondpasswordBox);
		
		JButton signUp = new JButton("Sign Up");
		signUp.setBounds(160, 180, 80, 25);
		panel.add(signUp);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(160, 210, 80, 25);
		panel.add(backButton);
		
		
		frame.setVisible(true);

		
	}
}
