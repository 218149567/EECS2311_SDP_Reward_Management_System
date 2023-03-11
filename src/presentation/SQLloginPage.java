package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessLogic.*;

public class SQLloginPage {
	//Initialize UI components
	private JPanel SQLloginPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	private JLabel logoLabel;
	private JLabel welcomeLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel instructionsLabel;
	
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	private JButton logInButton;
	
	
	//Constructor calls initialize method to create log in page panel
	public SQLloginPage() throws Exception {
		initialize();
	}
	
	public void initialize() throws Exception {
		PersistenceInterface pInterface = new PersistenceInterface();
		
		SQLloginPanel = new JPanel();
		SQLloginPanel.setBackground(new Color(255, 255, 255));
		SQLloginPanel.setSize(800,500);
		SQLloginPanel.setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 295, 500);
		leftPanel.setBackground(new Color(55, 55, 55));
		leftPanel.setLayout(null);
		SQLloginPanel.add(leftPanel);
		
		logoLabel = new JLabel();
		logoLabel.setBounds(20, 105, 255, 250);
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/presentation/imgs/logo.PNG")));
		leftPanel.add(logoLabel);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(295, 0, 505, 500);
		rightPanel.setBackground(new Color(250, 250, 250));
		rightPanel.setLayout(null);
		SQLloginPanel.add(rightPanel);
		
		welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setBounds(83, 11, 351, 60);
		welcomeLabel.setForeground(new Color(0, 0, 0));
		welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 48));
		welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
		welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rightPanel.add(welcomeLabel);
		
		instructionsLabel = new JLabel("<html>Please enter your MySQL <br/>username and password</html>");
		instructionsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		instructionsLabel.setForeground(new Color(248, 125, 9));
		instructionsLabel.setBounds(83, 60, 412, 67);
		rightPanel.add(instructionsLabel);
		
		usernameLabel = new JLabel("User Name");
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		usernameLabel.setBounds(83, 145, 143, 32);
		rightPanel.add(usernameLabel);
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("Verdana", Font.PLAIN, 16));
		userNameField.setBounds(83, 178, 353, 32);
		rightPanel.add(userNameField);
		userNameField.setColumns(10);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		passwordLabel.setBounds(83, 238, 143, 32);
		rightPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 16));
		passwordField.setBounds(83, 270, 353, 32);
		rightPanel.add(passwordField);
		
		logInButton = new JButton("Log In");
		logInButton.setForeground(new Color(248, 125, 9));
		logInButton.setBackground(new Color(255, 255, 255));
		logInButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		logInButton.setBounds(83, 322, 351, 39);
		
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = userNameField.getText();
				String password = new String(passwordField.getPassword());
				
				try {
					LoginPage loginPage = new LoginPage();
					pInterface.setUp(username, password);
					MainFrame.frame.remove(SQLloginPanel);
					MainFrame.frame.add(loginPage.getPanel());
					loginPage.getPanel().revalidate();
					loginPage.getPanel().repaint();
					
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(SQLloginPanel, "Incorrect username or password.","Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		rightPanel.add(logInButton);
		
	}

	public JPanel getPanel() {
		return SQLloginPanel;
	}

}
