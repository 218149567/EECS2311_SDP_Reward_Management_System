package presentation;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import businessLogic.*;
import persistence.*;

public class RewardEditGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel nameLabel, rewardDescriptionLabel, costLabel, quantityLabel;
	private JLabel attributeName, attributeDescription, attributeCost, attributeQuantity;
	private JTextField nameField, descriptionField, costField, quantityField;
	private JButton addRewardButton, closeButton;
	private JTable rewardTable;

	private ManagementSystem dbManager;
	private StubDataBase dbData;
	private Reward reward;
	
	private static RewardEditGUI instance;
	
	public RewardEditGUI() {
		// Set up the window properties
		setTitle("Reward Editing Page");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 600);
		add(panel);

		dbData = new StubDataBase();
		dbManager = new ManagementSystem(dbData);

		// check to see if account is an admin account

		/*
		 * reward implementation
		 */

		// table to see all current rewards
		String[] columnNames = { "Name", "Description", "Cost", "Quantity" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		ArrayList<Reward> rewards = dbManager.getRewards();
		for (Reward reward : rewards) {
			Object[] row = { reward.getName(), reward.getDescription(), reward.getCost(), reward.getQuantity() };
			model.addRow(row);
		}
		
		rewardTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(rewardTable);
		scrollPane.setBounds(50, 50, 400, 200);
		panel.add(scrollPane);

		// functionality to add rewards
		JPanel formPanel = new JPanel();
		formPanel.setLayout(null);
		formPanel.setBounds(0, 300, 500, 200);
		panel.add(formPanel);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(50, 10, 100, 25);
		formPanel.add(nameLabel);

		nameField = new JTextField(20);
		nameField.setBounds(160, 10, 200, 25);
		formPanel.add(nameField);

		rewardDescriptionLabel = new JLabel("Description:");
		rewardDescriptionLabel.setBounds(50, 40, 100, 25);
		formPanel.add(rewardDescriptionLabel);

		descriptionField = new JTextField(20);
		descriptionField.setBounds(160, 40, 200, 25);
		formPanel.add(descriptionField);

		costLabel = new JLabel("Cost:");
		costLabel.setBounds(50, 70, 100, 25);
		formPanel.add(costLabel);

		costField = new JTextField();
		costField.setBounds(160, 70, 200, 25);
		costField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		formPanel.add(costField);

		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(50, 100, 100, 25);
		formPanel.add(quantityLabel);

		quantityField = new JTextField();
		quantityField.setBounds(160, 100, 200, 25);
		quantityField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		formPanel.add(quantityField);

		
		addRewardButton = new JButton("Add Reward");
		addRewardButton.setBounds(200, 140, 125, 25);
		formPanel.add(addRewardButton);
		addRewardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String description = descriptionField.getText();
				int cost = Integer.parseInt(costField.getText());
				int quantity = Integer.parseInt(quantityField.getText());
				Reward newReward = new Reward(name, description, cost, quantity);
				dbManager.addReward(newReward);
				Object[] rowData = { name, description, cost, quantity };
				model.addRow(rowData);
			}
		});
		
		
		closeButton = new JButton("Close");
		closeButton.setBounds(200, 175, 125, 25);
		formPanel.add(closeButton);
		closeButton.addActionListener(e -> {
			//Open the landing page after exiting
			LandingPageAdmin landingPage = new LandingPageAdmin();
			dispose();
		});
		
		setVisible(true);
	}
	
    public static RewardEditGUI getInstance() {
        if (instance == null) {
            instance = new RewardEditGUI();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        RewardEditGUI.getInstance();
    }
}
