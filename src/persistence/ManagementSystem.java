package persistence;
	import businessLogic.*;
	public class ManagementSystem {
		private static StubDataBase db;
		public ManagementSystem(StubDataBase db){
			ManagementSystem.db = db;
		}
		public StubDataBase getDb() {
			return db;
		}
		public void addAccount(Account account) {
			ManagementSystem.db.getAccounts().add(account);
		}
		public Account getAccount(int id){
			for(Account account : ManagementSystem.db.getAccounts()) {
				if(account.getId() == id) {
					return account;
				}
			}
			return null;
		}
		public Account getAccount(String username){
			for(Account account : ManagementSystem.db.getAccounts()) {
				if(account.getUsername().equals(username)) {
					return account;
				}
			}
			return null;
		}
		public void addReward(Reward reward) {
			ManagementSystem.db.getRewards().add(reward);
		}
		
		public Reward getReward(String name) {
			for(Reward reward : ManagementSystem.db.getRewards()) {
				if(reward.getName().equals(name)) {
					return reward;
				}
			}
			return null;
		}
		public void removeReward(Reward reward) {
			
		}
}
