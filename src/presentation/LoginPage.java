package presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import businessLogic.PersistenceInterface;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage {

	//Initialize UI components
	private JPanel logInPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;

	private JLabel logoLabel;
	private JLabel welcomeLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel signUpLabel;

	private JTextField userNameField;
	private JPasswordField passwordField;

	private JButton logInButton;
	private JButton signUpButton;


	//Constructor calls initialize method to create log in page panel
	public LoginPage() {
		initialize();
	}

	public void initialize() {
		PersistenceInterface pInterface = new PersistenceInterface();

		logInPanel = new JPanel();
		logInPanel.setBackground(new Color(255, 255, 255));
		logInPanel.setSize(800,500);
		logInPanel.setLayout(null);

		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 295, 500);
		leftPanel.setBackground(new Color(55, 55, 55));
		leftPanel.setLayout(null);
		logInPanel.add(leftPanel);

		logoLabel = new JLabel();
		logoLabel.setBounds(20, 105, 255, 250);
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/presentation/imgs/logo.PNG")));
		leftPanel.add(logoLabel);

		rightPanel = new JPanel();
		rightPanel.setBounds(295, 0, 505, 500);
		rightPanel.setBackground(new Color(250, 250, 250));
		rightPanel.setLayout(null);
		logInPanel.add(rightPanel);

		welcomeLabel = new JLabel("Please Log In");
		welcomeLabel.setBounds(83, 44, 351, 60);
		welcomeLabel.setForeground(new Color(0, 0, 0));
		welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 48));
		welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
		welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rightPanel.add(welcomeLabel);

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
			public void actionPerformed(ActionEvent e){
				String username = userNameField.getText();
				String password = new String(passwordField.getPassword());
				
				try {

					if (pInterface.usernameChecker(username) && pInterface.passwordChecker(username, password)) {

						if(pInterface.getAccount(username).getRole().equals("user")) {
							UserDashBoard userDashboardPage = new UserDashBoard();

							MainFrame.frame.remove(logInPanel);
							MainFrame.frame.getContentPane().add(userDashboardPage.getPanel());
							userDashboardPage.getPanel().revalidate();
							userDashboardPage.getPanel().repaint();
						}
						else {
							AdminDashBoard adminDashboardPage = new AdminDashBoard();

							MainFrame.frame.remove(logInPanel);
							MainFrame.frame.getContentPane().add(adminDashboardPage.getPanel());
							adminDashboardPage.getPanel().revalidate();
							adminDashboardPage.getPanel().repaint();
						}

						System.out.println("Succeful login");
					}
					else {
						JOptionPane.showMessageDialog(logInPanel, "Incorrect username or password.","Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException | SQLException e1) {
					e1.printStackTrace();
				}

			}
		});


		rightPanel.add(logInButton);

		signUpLabel = new JLabel("New here?");
		signUpLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		signUpLabel.setForeground(new Color(248, 125, 9));
		signUpLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		signUpLabel.setBounds(319, 388, 115, 39);
		rightPanel.add(signUpLabel);

		signUpButton = new JButton("Sign Up");
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		signUpButton.setBackground(Color.WHITE);
		signUpButton.setBounds(339, 420, 95, 25);

		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUpPage signUpPage = new SignUpPage();

				MainFrame.frame.remove(logInPanel);
				MainFrame.frame.getContentPane().add(signUpPage.getPanel());
				signUpPage.getPanel().revalidate();
				signUpPage.getPanel().repaint();
			}
		});
		rightPanel.add(signUpButton);

	}

	public JPanel getPanel() {
		return logInPanel;
	}
}
