package persistence;

import java.util.ArrayList;

import businessLogic.*;

	public class StubDataBase {
		private Administrator admin = new Administrator("Admin", "admin", "password");
		private PointsReceiver user1 = new PointsReceiver("Joe", "joe123", "pass123");
		private PointsReceiver user2 = new PointsReceiver("Tara", "tara99", "tara00");
		private PointsReceiver user3 = new PointsReceiver("Mike", "mike65", "pass123");

		private static ArrayList<Account> accounts = new ArrayList<Account>();

		public StubDataBase() {
			StubDataBase.accounts.add(admin);
			StubDataBase.accounts.add(user1);
			StubDataBase.accounts.add(user2);
			StubDataBase.accounts.add(user3);
		}

		public ArrayList<Account> getAccounts() {
			return accounts;
		}

		public String toString(){
			String list = "[ ";
			for (int i = 0; i < accounts.size(); i++)
     {      
        list += accounts.get(i);

        if(i > accounts.size() - 1) {
        	list += ",";

        }
     }

			list += "]";

			return list;
		}
}