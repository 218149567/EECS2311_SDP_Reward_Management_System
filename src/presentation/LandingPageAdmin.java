package presentation;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import persistence.*;
import businessLogic.*;

public class LandingPageAdmin {

	private JFrame frame;
	private JPanel panel;

	public LandingPageAdmin() {

		frame = new JFrame();
		frame.setSize(500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.add(panel);
		//
		frame.setVisible(true);
		//
		panel.setLayout(null);

		JLabel typeofviewadmin = new JLabel("Admins View");
		typeofviewadmin.setBounds(220, 0, 80, 25);
		panel.add(typeofviewadmin);

		// implementation of the rewards drop-down menu
		StubDataBase dbData = new StubDataBase();

		// Get the rewards from the database
		ArrayList<Reward> rewards = dbData.getRewards();

		// Create an array to store the reward names and costs
		String[] rewardNamesAndCosts = new String[rewards.size()];

		// make an array with the reward names and costs
		for (int i = 0; i < rewards.size(); i++) {
			Reward reward = rewards.get(i);
			rewardNamesAndCosts[i] = reward.getName() + " - " + reward.getCost();
		}

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

		JLabel attributeId = new JLabel("ID: " + user.getUsername());
		attributeId.setBounds(50, 250, 200, 25);
		panel.add(attributeId);

		// display the balance of the PointsReceiver
		JLabel attributeBalance = new JLabel("Balance: " + user.checkBalance());
		attributeBalance.setBounds(50, 300, 200, 25);
		panel.add(attributeBalance);

		// Create the JComboBox drop-down menu
		JComboBox<String> rewardMenuOptions = new JComboBox<>(rewardNamesAndCosts);
		rewardMenuOptions.setBounds(50, 400, 200, 25);
		panel.add(rewardMenuOptions);
		// Add submit button to redeem the selected reward
		JButton redeemButton = new JButton("Redeem");
		redeemButton.setBounds(350, 400, 80, 25);
		panel.add(redeemButton);
		panel.revalidate();
		panel.repaint();
		// checks for the selected reward
		redeemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedRewardString = (String) rewardMenuOptions.getSelectedItem();
				Reward selectedReward = null;
				for (Reward reward : dbData.getRewards()) {
					if (selectedRewardString.equals(reward.getName())) {
						selectedReward = reward;
						break;
					}
				}
				if (selectedReward != null) {
					int cost = selectedReward.getCost();
					PointsReceiver user = null;
					// grabs the correct user that is logged in from the db
					for (Account account : dbData.getAccounts()) {
						// need a method to see if the check that the user is logged in
						if (account instanceof PointsReceiver /*
																 * && (account.getUsername().equals(loggedInUser.
																 * getUsername() )
																 */) {
							user = (PointsReceiver) account;
							break;
						}
					}
					// updates the db for the user of the cost of the reward
					if (user != null && user.checkBalance() >= cost) {
						user.addPoints(-cost);
						JOptionPane.showMessageDialog(rewardMenuOptions, "Reward redeemed successfully!",
								"Redeem Reward", JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						JOptionPane.showMessageDialog(rewardMenuOptions, "Not enough points to redeem this reward.",
								"Redeem Reward", JOptionPane.WARNING_MESSAGE, null);
					}
				}

			}
		});
		
		//account edit button to open editting window
		JButton accountEditButton = new JButton("Edit Account Information");
		accountEditButton.setBounds(50, 350, 80, 25);
		panel.add(accountEditButton);
		
		//listener for opening the window and closes the previous window
		accountEditButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AccountEditGUI editPage = new AccountEditGUI();
		        frame.dispose();
		    }
		});

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		LandingPageAdmin adminWindow = new LandingPageAdmin();

	}
}
