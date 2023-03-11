package businessLogic;
import java.sql.SQLException;

import persistence.*;

public class PersistenceInterface {
	
	protected static ManagementSystem ms;
	
	public PersistenceInterface() {
	}
	
	public void setUp(String username, String password) throws Exception {
		ms = new ManagementSystem();
		ms.createDB(username, password);
		System.out.println("success");
	}
	
	public Account getAccount(String username) throws SQLException {
		return ms.getAccount(username);
	}
	
	public void setAccount(String role, String name, String username, String password) throws SQLException {
		Account acc = Account.createAccount(role, name, username, password);
		ms.setAccount(role, name, username, password, acc.getId());	
	}
	
	
	public boolean usernameChecker(String username) throws SQLException {
		if(ms.getAccount(username) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean passwordChecker(String username, String password) throws SQLException {
		
		if(ms.getAccount(username).getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

}
