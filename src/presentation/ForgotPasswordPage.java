package presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ForgotPasswordPage {

	private JPanel forgotPasswordPanel;
	private JPanel leftPanel;
	private JPanel RightPanel;
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	public ForgotPasswordPage() {
		initialize();
	}
	
	public void initialize() {
		forgotPasswordPanel = new JPanel();
		forgotPasswordPanel.setBackground(new Color(255, 255, 255));
		this.forgotPasswordPanel.setSize(800,500);
		forgotPasswordPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 295, 500);
		leftPanel.setBackground(new Color(55, 55, 55));
		this.forgotPasswordPanel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(20, 105, 255, 250);
		leftPanel.add(logoLabel);
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/presentation/imgs/logo.PNG")));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(295, 0, 505, 500);
		rightPanel.setBackground(new Color(250, 250, 250));
		this.forgotPasswordPanel.add(rightPanel);
		rightPanel.setLayout(null);
		
		JLabel changePasswordLabel = new JLabel("<html>Change <br>Password </html>");
		changePasswordLabel.setBounds(83, -2, 351, 136);
		changePasswordLabel.setForeground(new Color(0, 0, 0));
		changePasswordLabel.setFont(new Font("Verdana", Font.PLAIN, 48));
		changePasswordLabel.setHorizontalTextPosition(JLabel.CENTER);
		changePasswordLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rightPanel.add(changePasswordLabel);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNewLabel.setBounds(83, 145, 143, 32);
		rightPanel.add(lblNewLabel);
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("Verdana", Font.PLAIN, 16));
		userNameField.setBounds(81, 176, 353, 32);
		rightPanel.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("New Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblPassword.setBounds(83, 238, 182, 32);
		rightPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 16));
		passwordField.setBounds(83, 281, 353, 32);
		rightPanel.add(passwordField);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnNewButton.setBounds(83, 324, 351, 39);
		rightPanel.add(btnNewButton);
		

		
		
		
	}

	public JPanel getPanel() {
		return forgotPasswordPanel;
	}
}
