package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import persistence.StubDataBase;
import businessLogic.*;
import persistence.*;

public class LandingPageAdmin {
	
	
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			frame.setSize(500,700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			frame.add(panel);	
			//
			frame.setVisible(true);
			//
			panel.setLayout(null);
			
			JLabel typeofviewadmin = new JLabel("Admins View");
			typeofviewadmin.setBounds(220, 0, 80, 25);
			panel.add(typeofviewadmin);
			 
			
			
			//implementation of the rewards drop-down menu
			StubDataBase dbData = new StubDataBase();

	        // Get the rewards from the database
	        ArrayList<Reward> rewards = dbData.getRewards();

	        // Create an array to store the reward names and costs
	        String[] rewardNamesAndCosts = new String[rewards.size()];

	        //make an array with the reward names and costs
	        for (int i = 0; i < rewards.size(); i++) {
	            Reward reward = rewards.get(i);
	            rewardNamesAndCosts[i] = reward.getName() + " - " + reward.getCost();
	        }

	        // Create the JComboBox drop-down menu
	        JComboBox<String> rewardMenuOptions = new JComboBox<>(rewardNamesAndCosts);
	        rewardMenuOptions.setBounds(50, 50, 200, 25);
	        panel.add(rewardMenuOptions);
	        // Add submit button to redeem the selected reward
	        JButton redeemButton = new JButton("Redeem");
			redeemButton.setBounds(350, 50, 80, 25);
			panel.add(redeemButton);
			panel.revalidate();
			panel.repaint();
			//checks for the selected reward
	        redeemButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String selectedRewardString = (String) rewardMenuOptions.getSelectedItem();
	        		Reward selectedReward = null;
	        		for(Reward reward : dbData.getRewards()) {
	        			if(selectedRewardString.equals(reward.getName())) {
	        				selectedReward = reward;
	        				break;
	        			}
	        		}
	        		if(selectedReward != null) {
	        			int cost = selectedReward.getCost();
	        			PointsReceiver user = null;
	        			//grabs the correct user that is logged in from the db
		                for (Account account : dbData.getAccounts()){
		                	// need a method to see if the check that the user is logged in
		                    if (account instanceof PointsReceiver /*&& (account.getUsername().equals(loggedInUser.getUsername() ) */) {
		                        user = (PointsReceiver) account;
		                        break;
		                    }
		                }
		                //updates the db for the user of the cost of the reward
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
	       
	        frame.setVisible(true);
	        
	        
//			JButton lPageButtonAdmin = new JButton("button");
//			lPageButtonAdmin.setBounds(350, 50, 80, 25);
//			panel.add(lPageButtonAdmin);

	}
}
