package presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import businessLogic.PersistenceInterface;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUpPage {

	//Initialize UI components
	private JPanel signUpPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;

	private JLabel logoLabel;
	private JLabel welcomeLabel;
	private JLabel fullNameLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel logInLabel;

	private JTextField fullNameField;
	private JTextField userNameField;
	private JPasswordField passwordField;

	private JButton signUpButton;
	private JButton logInButton;


	//Constructor calls initialize method to create sign up page panel
	public SignUpPage() {
		initialize();
	}

	public void initialize() {
		PersistenceInterface pInterface = new PersistenceInterface();

		signUpPanel = new JPanel();
		signUpPanel.setBackground(new Color(255, 255, 255));
		signUpPanel.setSize(800,500);
		signUpPanel.setLayout(null);

		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 295, 500);
		leftPanel.setBackground(new Color(250, 250, 250));
		signUpPanel.add(leftPanel);
		leftPanel.setLayout(null);

		logoLabel = new JLabel();
		logoLabel.setBounds(20, 105, 255, 250);
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/presentation/imgs/logo.PNG")));
		leftPanel.add(logoLabel);

		rightPanel = new JPanel();
		rightPanel.setBounds(295, 0, 505, 500);
		rightPanel.setBackground(new Color(55, 55, 55));
		rightPanel.setLayout(null);
		signUpPanel.add(rightPanel);

		welcomeLabel = new JLabel("Sign Up Here");
		welcomeLabel.setBounds(83, 44, 351, 60);
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 48));
		welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
		welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rightPanel.add(welcomeLabel);


		fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setForeground(Color.WHITE);
		fullNameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		fullNameLabel.setBounds(83, 122, 143, 32);
		rightPanel.add(fullNameLabel);

		fullNameField = new JTextField();
		fullNameField.setFont(new Font("Verdana", Font.PLAIN, 16));
		fullNameField.setColumns(10);
		fullNameField.setBounds(81, 155, 353, 32);
		rightPanel.add(fullNameField);

		usernameLabel = new JLabel("User Name");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		usernameLabel.setBounds(83, 198, 143, 32);
		rightPanel.add(usernameLabel);

		userNameField = new JTextField();
		userNameField.setFont(new Font("Verdana", Font.PLAIN, 16));
		userNameField.setBounds(81, 230, 353, 32);
		rightPanel.add(userNameField);
		userNameField.setColumns(10);

		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		passwordLabel.setBounds(83, 266, 143, 32);
		rightPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 16));
		passwordField.setBounds(83, 299, 353, 32);
		rightPanel.add(passwordField);

		signUpButton = new JButton("Sign Up");
		signUpButton.setForeground(new Color(248, 125, 9));
		signUpButton.setBackground(new Color(50, 50, 50));
		signUpButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		signUpButton.setBounds(83, 349, 351, 39);

		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fullName = fullNameField.getText();
				String username = userNameField.getText();
				String password = new String(passwordField.getPassword());

				try {
					pInterface.setAccount("user", fullName, username, password);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}


				LoginPage logInPage = new LoginPage();
				MainFrame.frame.remove(signUpPanel);
				MainFrame.frame.getContentPane().add(logInPage.getPanel());
				logInPage.getPanel().revalidate();
				logInPage.getPanel().repaint();
			}
		});

		rightPanel.add(signUpButton);

		logInLabel = new JLabel("Already have an account?");
		logInLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		logInLabel.setForeground(new Color(248, 125, 9));
		logInLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		logInLabel.setBounds(145, 388, 289, 39);
		rightPanel.add(logInLabel);

		logInButton = new JButton("Log In");
		logInButton.setForeground(Color.BLACK);
		logInButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		logInButton.setBackground(new Color(55, 55, 55));
		logInButton.setBounds(339, 420, 95, 25);

		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginPage logInPage = new LoginPage();
				MainFrame.frame.remove(signUpPanel);
				MainFrame.frame.getContentPane().add(logInPage.getPanel());
				logInPage.getPanel().revalidate();
				logInPage.getPanel().repaint();

			}
		});
		rightPanel.add(logInButton);

	}

	public JPanel getPanel() {
		return signUpPanel;
	}
}
