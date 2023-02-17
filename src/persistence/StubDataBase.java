package persistence;

import java.util.ArrayList;

import businessLogic.*;

public class StubDataBase {
	private Administrator admin = new Administrator("Admin", "admin", "password");
	private PointsReceiver user1 = new PointsReceiver("Joe", "joe123", "pass123");
	private PointsReceiver user2 = new PointsReceiver("Tara", "tara99", "tara00");
	private PointsReceiver user3 = new PointsReceiver("Mike", "mike65", "pass123");

	// test rewards
	private Reward reward1 = new Reward("half-day", "work only half a day", 50, 100);
	private Reward reward2 = new Reward("1-day-off", "free day off with pay", 100, 100);
	private Reward reward3 = new Reward("week-off", "week-off work with pay", 500, 100);
	private Reward reward4 = new Reward("gift-card", "$50 company giftcard", 25, 100);

	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Reward> rewards = new ArrayList<Reward>();

	public StubDataBase() {
		StubDataBase.accounts.add(admin);
		StubDataBase.accounts.add(user1);
		StubDataBase.accounts.add(user2);
		StubDataBase.accounts.add(user3);

		StubDataBase.rewards.add(reward1);
		StubDataBase.rewards.add(reward2);
		StubDataBase.rewards.add(reward3);
		StubDataBase.rewards.add(reward4);
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public ArrayList<Reward> getRewards() {
		return rewards;
	}

	public String toString() {
		String list = "[ ";
		for (int i = 0; i < accounts.size(); i++) {
			list += accounts.get(i);

			if (i > accounts.size() - 1) {
				list += ",";

			}
		}

		list += "]";

		return list;
	}
}
