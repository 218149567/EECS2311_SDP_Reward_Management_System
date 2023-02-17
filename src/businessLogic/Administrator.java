package businessLogic;

import java.util.ArrayList;

public class Administrator extends Account{
	
	private ArrayList <String> pointRequests;
	
	public Administrator() {
	}
	
	public Administrator(String name, String username, String password) {
		super(name, username, password);
		this.role = "AD";
	}
	
	public void createAdmin(String name, String username, String password) {
		
		Administrator admin = new Administrator(name, username, password); 
		system.addAccount(admin);
	}
	
	public void addPoints(int points, String username){
		Account user = system.getAccount(username);
		
		if (user.getRole().equals("PR")) {
			((PointsReceiver) user).addPoints(points);
		}
		
	}
	
	public void changePassword(String username, String newPassword) {
		system.getAccount(username).setPassword(newPassword);
	}
	
	public void removeAccount(String username) {
		int index = system.getDb().getAccounts().indexOf(system.getAccount(username));
		system.getDb().getAccounts().remove(index);
	}

	public void addPointRequest(String request) {
        pointRequests.add(request);
    }
	
    public ArrayList <String> getPointRequests() {
        return pointRequests;
    }
}
