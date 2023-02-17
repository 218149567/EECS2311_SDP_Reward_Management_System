package businessLogic;

import persistence.*;

public class Account {
	protected String role;
	private String name;
	private String username;
	private String password;
	private int id;
	private static int idCounter = 1;
	
	protected static StubDataBase DB = new StubDataBase();
	protected static ManagementSystem system = new ManagementSystem(DB);
	
	
	public Account(){
	}
	
	public Account(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
		this.id = idCounter++;
	}
	
	public static ManagementSystem getSystem() {
		return system;
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

	public static int getIdCounter() {
		return idCounter;
	}
	
	public String toString() {
		
		return this.getUsername();
		
	}
	
	public boolean usernameChecker(String username) {
		if( system.getAccount(username) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean passwordChecker(String username, String password) {
		if(system.getAccount(username).getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}