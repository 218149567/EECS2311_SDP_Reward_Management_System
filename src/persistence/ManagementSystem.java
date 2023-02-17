package persistence;

import java.util.ArrayList;

import businessLogic.*;

public class ManagementSystem {

	private static StubDataBase db;

	public ManagementSystem(StubDataBase db) {
		ManagementSystem.db = db;
	}

	public StubDataBase getDb() {
		return db;
	}

	public void addAccount(Account account) {
		db.getAccounts().add(account);
	}

	public Account getAccount(int id) {
		for (Account account : db.getAccounts()) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	public Account getAccount(String username) {
		for (Account account : db.getAccounts()) {
			if (account.getUsername().equals(username)) {
				return account;
			}
		}
		return null;
	}
	
	public Account getAdministrator() {
		return db.getAccounts().get(0);
	}

	public void updatePointsReceiver(PointsReceiver updatedUser) {
		PointsReceiver user = (PointsReceiver) getAccount(updatedUser.getId());
	    if (user != null) {
	        db.getAccounts().set(db.getAccounts().indexOf(user), user);
	    }
	}
	
	public ArrayList<Account> getAccounts() {
		return db.getAccounts();
	}

	public ArrayList<Reward> getRewards() {
		return db.getRewards();
	}
	
	public void addReward(Reward reward) {
		ManagementSystem.db.getRewards().add(reward);
	}

	public Reward getReward(String name) {
		for (Reward reward : ManagementSystem.db.getRewards()) {
			if (reward.getName().equals(name)) {
				return reward;
			}
		}
		return null;
	}

	public void removeReward(Reward reward) {

	}
}
