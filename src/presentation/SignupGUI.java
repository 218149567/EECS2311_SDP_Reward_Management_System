package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupGUI {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField nameText;
	private JTextField userText;
	private JPasswordField firstPasswordTextbox;
	private JPasswordField secondPasswordBox;
	
	public SignupGUI() {
		frame = new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.add(panel);	
		
		panel.setLayout(null);
		JLabel inputPrompt = new JLabel("Sign Up");
		inputPrompt.setBounds(180, 0, 80, 25);
		panel.add(inputPrompt);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 30, 80, 25);
		panel.add(nameLabel);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 70, 80, 25);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(10, 110, 80, 25);
		panel.add(passLabel);
		
		JLabel passLabel2 = new JLabel("Password Again");
		passLabel2.setBounds(10, 150, 800, 25);
		panel.add(passLabel2);
		
		nameText = new JTextField(20);
		nameText.setBounds(120,30,165,25);
		panel.add(nameText);
		
		userText = new JTextField(20);
		userText.setBounds(120,70,165,25);
		panel.add(userText);
		
		firstPasswordTextbox = new JPasswordField(20);
		firstPasswordTextbox.setBounds(120, 110, 165, 25);
		panel.add(firstPasswordTextbox);
		
		secondPasswordBox = new JPasswordField(20);
		secondPasswordBox.setBounds(120, 150, 165, 25);
		panel.add(secondPasswordBox);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(160, 180, 80, 25);
		signUpButton.addActionListener(e -> signUp());
		panel.add(signUpButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(160, 210, 80, 25);
		backButton.addActionListener(e -> show(false));
		panel.add(backButton);
		
		frame.setVisible(false);
	}
	
	public void show(boolean b) {
		frame.setVisible(b);
	}
	
	private void signUp() {
		String name = nameText.getText();
		String username = userText.getText();
		char[] password1 = firstPasswordTextbox.getPassword();
		char[] password2 = secondPasswordBox.getPassword();
		if (name.isEmpty() || username.isEmpty() || password1.length == 0 || password2.length == 0) {
			// Display an error message
			System.out.println("Please fill in all fields.");
		} else if (!new String(password1).equals(new String(password2))) {
			// Display an error message
			System.out.println("Passwords do not match.");
		} else {
			// Create a new user account
			// You can put your account creation code here
			System.out.println("Account created successfully.");
			// Clear the input fields
			nameText.setText("");
			userText.setText("");
			firstPasswordTextbox.setText("");
			secondPasswordBox.setText("");
			// Hide the signup window
			show(false);
		}
	}
}

	

