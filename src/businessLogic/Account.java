package businessLogic;

import java.sql.SQLException;

import persistence.ManagementSystem;

public class Account {
	protected String role;
	private String name;
	private String username;
	private String password;
	private int id;
	private static int idCounter = 3;
	
	private static ManagementSystem ms = new ManagementSystem();
	
	public Account(){
	}
	
	public Account(String role, String name, String username, String password){
		this.role = role;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public static Account createAccount(String role, String name, String username, String password) {
		
		Account newAccount = new Account(role, name, username, password);
		newAccount.id = idCounter++;
		
		return newAccount;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	
}
