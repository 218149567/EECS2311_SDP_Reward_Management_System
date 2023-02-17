package presentation;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import persistence.*;
import businessLogic.*;

public class LandingPageAdmin {

	private JFrame frame;
	private JPanel panel;
	
	private ManagementSystem dbManager;
	private static StubDataBase dbData;
	
	private String[] accountNamesAndIds;
	
	public LandingPageAdmin() {

		frame = new JFrame();
		frame.setSize(500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		panel.setLayout(null);

		JLabel typeofviewadmin = new JLabel("Admins View");
		typeofviewadmin.setBounds(220, 0, 80, 25);
		panel.add(typeofviewadmin);

		// implementation of the accounts drop-down menu
		dbData = new StubDataBase();
		dbManager = new ManagementSystem(dbData);
		
		accountNamesAndIds = updateAccountsNamesAndIds();
		/*
		 * implementation for display the account/user/admin attributes
		 */
		
		// Grabs the current user
		PointsReceiver user = null;
		for (Account account : dbData.getAccounts()) {
			if (account instanceof PointsReceiver) {
				user = (PointsReceiver) account;
				break;
			}
		}

		// display the attributes of the PointsReceiver
		JLabel attributeName = new JLabel("Name: " + user.getName());
		attributeName.setBounds(50, 100, 100, 25);
		panel.add(attributeName);

		JLabel attributeUsername = new JLabel("Username: " + user.getUsername());
		attributeUsername.setBounds(50, 150, 200, 25);
		panel.add(attributeUsername);

		JLabel attributePassword = new JLabel("Password: " + user.getPassword());
		attributePassword.setBounds(50, 200, 200, 25);
		panel.add(attributePassword);

		JLabel attributeId = new JLabel("ID: " + user.getId());
		attributeId.setBounds(50, 250, 200, 25);
		panel.add(attributeId);

		// display the balance of the PointsReceiver
		JLabel attributeBalance = new JLabel("Balance: " + user.checkBalance());
		attributeBalance.setBounds(50, 300, 200, 25);
		panel.add(attributeBalance);

		// Create the JComboBox drop-down menu
		JComboBox<String> accountList = new JComboBox<>(accountNamesAndIds);
		accountList.removeAllItems();
		for (String accountNameAndId : accountNamesAndIds) {
		    accountList.addItem(accountNameAndId);
		}
		accountList.setBounds(50, 400, 200, 25);
		panel.add(accountList);
		
		// Add submit button to give points
		JButton givePointsButton = new JButton("Give");
		givePointsButton.setBounds(350, 450, 100, 25);
		panel.add(givePointsButton);
		
		JLabel pointsLabel = new JLabel("Amount: ");
		pointsLabel.setBounds(50, 450, 300, 25);
		panel.add(pointsLabel);

		JTextField pointsField = new JTextField();
		pointsField.setBounds(125, 450, 200, 25);
		panel.add(pointsField);
		pointsField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		
		// checks for the selected reward
		givePointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedAccountString = (String) accountList.getSelectedItem();
				PointsReceiver selectedAccount = null;
				for (Account account : dbData.getAccounts()) {
					if (account instanceof PointsReceiver && selectedAccountString.equals(account.getName())) {
						selectedAccount = (PointsReceiver) account;
						break;
					}
				}
				// updates the db giving user points
		        if (selectedAccount != null) {
		            String points = pointsField.getText();
		            int pointsToGive = Integer.parseInt(points);
		            selectedAccount.addPoints(pointsToGive);
		            attributeBalance.setText("Balance: " + selectedAccount.checkBalance());
		        }
		    }
		});
		
		//account edit button to open editting window
		JButton accountEditButton = new JButton("Edit Account Info");
		accountEditButton.setBounds(50, 350, 150, 25);
		panel.add(accountEditButton);
		
		//listener for opening the window and closes the previous window
		accountEditButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AccountEditGUI accountEditPage = new AccountEditGUI();
		        frame.dispose();
		    }
		});
		
		JButton rewardEditButton = new JButton("Edit Rewards");
		rewardEditButton.setBounds(350, 350, 115, 25);
		panel.add(rewardEditButton);
		
		rewardEditButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        RewardEditGUI rewardEditPage = new RewardEditGUI();
		        frame.dispose();
		    }
		});
		
		panel.revalidate();
		panel.repaint();
		frame.setVisible(true);
	}
	
	public String[] updateAccountsNamesAndIds() {
	    List<Account> accounts = dbData.getAccounts();
	    String[] accountNamesAndIds = new String[accounts.size()];
	    for (int i = 0; i < accounts.size(); i++) {
	        Account account = accounts.get(i);
	        accountNamesAndIds[i] = account.getName() + " - " + account.getId();
	    }
	    this.accountNamesAndIds = accountNamesAndIds;
	    return accountNamesAndIds;
	}

	public static void main(String[] args) {
		LandingPageAdmin adminWindow = new LandingPageAdmin();

	}
}
