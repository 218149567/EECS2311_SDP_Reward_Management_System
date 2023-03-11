package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import businessLogic.Account;
import database.*;

public class ManagementSystem {
	private DBInterface dbInterface;
	
	public ManagementSystem() {
		this.dbInterface = new DBInterface();
	}
	
	public void createDB(String username, String password) throws Exception {
		this.dbInterface.getConnection(username, password);
		this.dbInterface.createTables();
		this.dbInterface.addTestAccounts();
	}
	
	public Account getAccount(String username) throws SQLException {
		
		ResultSet retrivedUser = this.dbInterface.retriveAccount(username);
		
		String role = retrivedUser.getString("role");
		String name = retrivedUser.getString("name");
		String user = retrivedUser.getString("username");
		String password = retrivedUser.getString("password");
		int userID = retrivedUser.getInt("userId");

		
		Account userAccount = new Account(role, name, user, password);
		
		return userAccount;
	}
	
	public void setAccount(String role, String name, String username, String password, int userId) throws SQLException {
		this.dbInterface.addAccount(role, name, username, password, userId);
	}
	
}
