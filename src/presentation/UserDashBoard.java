package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class UserDashBoard {
	//Initialize UI components
	private JPanel userDashBoardPanel;
	
	private JLabel dashboardLabel;
	private JLabel userInfoLabel;
	private JLabel requestPointsLabel;
	private JLabel nameLabel;
	private JLabel usernameLabel;
	private JLabel userIdLabel;
	private JLabel balanceLabel;
	private JLabel pointAmountLabel;
	private JLabel redeemRewardsLabel;
	
	private JTextField pointAmountTextField;
	
	private JButton requestPointsButton;
	private JButton redeemRewardButton;
	
	private JComboBox rewardsDropDownMenu;

	public UserDashBoard() {
		initialize();
	}
	
	
	//Constructor calls initialize method to create user dashboard page panel
	public void initialize() {
		userDashBoardPanel = new JPanel();
		userDashBoardPanel.setBackground(new Color(255, 255, 255));
		userDashBoardPanel.setSize(800,500);
		userDashBoardPanel.setLayout(null);
		
		JLabel dashboardLabel = new JLabel("Dashboard", SwingConstants.CENTER);
		dashboardLabel.setOpaque(true);
		dashboardLabel.setBackground(new Color(55, 55, 55));
		dashboardLabel.setForeground(Color.white);
		dashboardLabel.setFont(new Font("Verdana", Font.PLAIN, 64));
		dashboardLabel.setBounds(0, 0, 800, 101);
		userDashBoardPanel.add(dashboardLabel);
		
		userInfoLabel = new JLabel("User Info:");
		userInfoLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		userInfoLabel.setBounds(21, 112, 230, 30);
		userDashBoardPanel.add(userInfoLabel);
		
		
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		nameLabel.setBounds(21, 153, 117, 20);
		userDashBoardPanel.add(nameLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		usernameLabel.setBounds(21, 184, 117, 20);
		userDashBoardPanel.add(usernameLabel);
		
		userIdLabel = new JLabel("User ID:");
		userIdLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		userIdLabel.setBounds(245, 184, 117, 20);
		userDashBoardPanel.add(userIdLabel);
		
		balanceLabel = new JLabel("Balance:");
		balanceLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		balanceLabel.setBounds(245, 153, 117, 20);
		userDashBoardPanel.add(balanceLabel);
		
		requestPointsLabel = new JLabel("Request Points:");
		requestPointsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		requestPointsLabel.setBounds(21, 292, 230, 30);
		userDashBoardPanel.add(requestPointsLabel);
		
		pointAmountLabel = new JLabel("Enter Points Request Amount:");
		pointAmountLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		pointAmountLabel.setBounds(21, 333, 277, 21);
		userDashBoardPanel.add(pointAmountLabel);
		
		pointAmountTextField = new JTextField();
		pointAmountTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		pointAmountTextField.setBounds(21, 356, 261, 20);
		pointAmountTextField.setColumns(10);
		userDashBoardPanel.add(pointAmountTextField);
		
		requestPointsButton = new JButton("Request");
		requestPointsButton.setHorizontalAlignment(SwingConstants.RIGHT);
		requestPointsButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		requestPointsButton.setBounds(182, 381, 100, 23);
		requestPointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userDashBoardPanel.add(requestPointsButton);
		
		redeemRewardsLabel = new JLabel("Redeem Rewards:");
		redeemRewardsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		redeemRewardsLabel.setBounds(431, 112, 230, 30);
		userDashBoardPanel.add(redeemRewardsLabel);
		
		rewardsDropDownMenu = new JComboBox();
		rewardsDropDownMenu.setBounds(431, 155, 230, 22);
		userDashBoardPanel.add(rewardsDropDownMenu);
		
		redeemRewardButton = new JButton("Redeem");
		redeemRewardButton.setHorizontalAlignment(SwingConstants.RIGHT);
		redeemRewardButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		redeemRewardButton.setBounds(561, 194, 100, 23);
		redeemRewardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userDashBoardPanel.add(redeemRewardButton);	
	}
	
	public JPanel getPanel() {
		return userDashBoardPanel;
	}

}
