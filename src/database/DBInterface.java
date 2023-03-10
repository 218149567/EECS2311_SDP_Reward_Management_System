package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInterface {

	private Connection connection;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String address = "jdbc:mysql://localhost:3306/RMSDatabase?createDatabaseIfNotExist=true";

	public DBInterface(){
	}

	public void getConnection(String username, String password) throws Exception{
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(address, username, password);
		} 

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTables() throws SQLException{

		String createAccountsTable = "CREATE TABLE IF NOT EXISTS tblUsers" 
				+"(role VARCHAR(256), " 
				+"name VARCHAR(256), "
				+ "username VARCHAR(256), "
				+ "password VARCHAR(256), "
				+ "userId INTEGER)";

		String createRewardsTable = "CREATE TABLE IF NOT EXISTS tblRewards" 
				+"(name VARCHAR(256), " 
				+"decription VARCHAR(256), "
				+ "cost INTEGER, "
				+ "quantity INTEGER) ";

		java.sql.Statement statement = connection.createStatement();
		statement.execute(createAccountsTable);
		statement.execute(createRewardsTable);
	}

	public void addTestAccounts() throws SQLException{
		String insertUser1 = "INSERT INTO tblUsers VALUES ('admin', 'John Dohn', 'john000', 'pass123', '1')";
		String insertUser2 = "INSERT INTO tblUsers VALUES ('user', 'Ben Smith', 'ben123', 'ben007', '2')";
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(insertUser1);
		statement.executeUpdate(insertUser2);
	}

}
