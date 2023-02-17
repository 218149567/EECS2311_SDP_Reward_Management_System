package presentation;

import javax.swing.*;

import businessLogic.*;
import persistence.*;

public class AccountEditGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel nameLabel, usernameLabel, passwordLabel;
	private JLabel attributeName, attributeUsername, attributePassword;
	private JTextField nameField, usernameField, passwordField;
	private JButton saveButton, cancelButton;

	private ManagementSystem dbManager;
	private StubDataBase dbData;
	private PointsReceiver user;

	public AccountEditGUI() {
		// Set up the window properties
		setTitle("The Account Editing Page");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 600);
		add(panel);
		
		dbData = new StubDataBase();
		dbManager = new ManagementSystem(dbData);

		for (Account account : dbData.getAccounts()) {
			if (account instanceof PointsReceiver) {
				user = (PointsReceiver) account;
				break;
			}
		}

		// display the attributes of the PointsReceiver
		attributeName = new JLabel("Name: " + user.getName());
		attributeName.setBounds(50, 50, 100, 25);
		panel.add(attributeName);

		// label for name text field
		nameLabel = new JLabel("Change Name:");
		nameLabel.setBounds(200, 50, 100, 25);
		panel.add(nameLabel);

		// text field for name
		nameField = new JTextField();
		nameField.setBounds(350, 50, 150, 25);
		panel.add(nameField);

		// username
		attributeUsername = new JLabel("Username: " + user.getUsername());
		attributeUsername.setBounds(50, 100, 200, 25);
		panel.add(attributeUsername);

		usernameLabel = new JLabel("Change Username: ");
		usernameLabel.setBounds(200, 100, 300, 25);
		panel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(350, 100, 150, 25);
		panel.add(usernameField);

		// password
		attributePassword = new JLabel("Password: " + user.getPassword());
		attributePassword.setBounds(50, 150, 300, 25);
		panel.add(attributePassword);

		passwordLabel = new JLabel("Change Password: ");
		passwordLabel.setBounds(200, 150, 300, 25);
		panel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(350, 150, 150, 25);
		panel.add(passwordField);

		// save and cancel buttons
		saveButton = new JButton("Save");
		saveButton.setBounds(100, 200, 100, 25);
		panel.add(saveButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(300, 200, 100, 25);
		panel.add(cancelButton);

		// implementation of the save/cancel buttons
		saveButton.addActionListener(e -> {
			String newName = nameField.getText().trim();
			String newUsername = usernameField.getText().trim();
			String newPassword = passwordField.getText().trim();

			if (!newName.equals("")) {
				user.setName(newName);
			}
			if (!newUsername.equals("")) {
				user.setUsername(newUsername);
			}
			if (!newPassword.equals("")) {
				user.setPassword(newPassword);
			}

			// update database
			dbManager.updatePointsReceiver(user);

			// show a message dialog to confirm that the account was saved
			JOptionPane.showMessageDialog(this, "New Account Setting Saved!");
			
			//Open the landing page after exiting
			LandingPageAdmin landingPage = new LandingPageAdmin();
			dispose();
		});

		cancelButton.addActionListener(e -> {
			// show a message dialog to confirm that the account was saved
			JOptionPane.showMessageDialog(this, "Cancel Account Settings.");
			
			//Open the landing page after exiting
			LandingPageAdmin landingPage = new LandingPageAdmin();
			dispose();
		});

		// Show the window
		setVisible(true);
	}

	public static void main(String[] args) {
		AccountEditGUI editWindow = new AccountEditGUI();
	}
}
