package presentation;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashBoard {
	//Initialize UI components
	private JPanel adminDashBoardPanel;
	
	private JLabel dashboardLabel;
	private JLabel sendPointsLabel;
	private JLabel rewardsLabel;
	private JLabel pointRecieverLabel;
	private JLabel pointAmountLabel;
	private JLabel requestsLabel;
	
	private JTextField pointRecieverUsernameTextField;
	private JTextField amountOfPointsTextField;
	
	private JButton sendPointButton;
	private JButton acceptRequestButton;
	private JButton denyRequestButton;
	
	private JComboBox requestsDropdown;
	
	
	//Constructor calls initialize method to create admin dashboard panel
	public AdminDashBoard() {
		initialize();
	}
	
	public void initialize() {
		adminDashBoardPanel = new JPanel();
		adminDashBoardPanel.setBackground(new Color(255, 255, 255));
		adminDashBoardPanel.setSize(800,500);
		adminDashBoardPanel.setLayout(null);
		
		dashboardLabel = new JLabel("Dashboard", SwingConstants.CENTER);
		dashboardLabel.setOpaque(true);
		dashboardLabel.setBackground(new Color(55, 55, 55));
		dashboardLabel.setForeground(Color.white);
		dashboardLabel.setFont(new Font("Verdana", Font.PLAIN, 64));
		dashboardLabel.setBounds(0, 0, 800, 101);
		adminDashBoardPanel.add(dashboardLabel);
		
		sendPointsLabel = new JLabel("Send Points:");
		sendPointsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		sendPointsLabel.setBounds(23, 112, 230, 21);
		adminDashBoardPanel.add(sendPointsLabel);
		
		rewardsLabel = new JLabel("Rewards:");
		rewardsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		rewardsLabel.setBounds(418, 112, 230, 21);
		adminDashBoardPanel.add(rewardsLabel);
		
		pointRecieverLabel = new JLabel("Enter Point Reciever Username:");
		pointRecieverLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		pointRecieverLabel.setBounds(23, 144, 277, 21);
		adminDashBoardPanel.add(pointRecieverLabel);
		
		pointAmountLabel = new JLabel("Amount:");
		pointAmountLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		pointAmountLabel.setBounds(23, 198, 137, 21);
		adminDashBoardPanel.add(pointAmountLabel);
		
		pointRecieverUsernameTextField = new JTextField();
		pointRecieverUsernameTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		pointRecieverUsernameTextField.setBounds(23, 167, 261, 20);
		pointRecieverUsernameTextField.setColumns(10);
		adminDashBoardPanel.add(pointRecieverUsernameTextField);
		
		amountOfPointsTextField = new JTextField();
		amountOfPointsTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		amountOfPointsTextField.setColumns(10);
		amountOfPointsTextField.setBounds(23, 219, 261, 20);
		adminDashBoardPanel.add(amountOfPointsTextField);
		
		sendPointButton = new JButton("Send");
		sendPointButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		sendPointButton.setBounds(195, 250, 89, 23);
		sendPointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		adminDashBoardPanel.add(sendPointButton);
		
		requestsLabel = new JLabel("Requests:");
		requestsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		requestsLabel.setBounds(23, 317, 156, 30);
		adminDashBoardPanel.add(requestsLabel);
		
		requestsDropdown = new JComboBox();
		requestsDropdown.setBounds(23, 359, 156, 22);
		adminDashBoardPanel.add(requestsDropdown);
		
		acceptRequestButton = new JButton("Accept");
		acceptRequestButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		acceptRequestButton.setBounds(23, 399, 89, 23);
		
		acceptRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		adminDashBoardPanel.add(acceptRequestButton);
		
		denyRequestButton = new JButton("Deny");
		denyRequestButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		denyRequestButton.setBounds(23, 433, 89, 23);
		
		denyRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		adminDashBoardPanel.add(denyRequestButton);
		
		
	}
	
	public JPanel getPanel() {
		return adminDashBoardPanel;
	}
}
