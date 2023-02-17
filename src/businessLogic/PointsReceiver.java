package businessLogic;

public class PointsReceiver extends Account{
	
	private int balance;
	
	public PointsReceiver() {
	}
	
	public PointsReceiver(String name, String username, String password) {
		super(name, username, password);
		this.balance = 0;
		this.role = "PR";
	}
	
	public void createPR(String name, String username, String password) {
		
		PointsReceiver pr = new PointsReceiver(name, username, password);
		system.addAccount(pr);
	}
	
	public int checkBalance() {
		return this.balance;
	}
	
	public void addPoints(int points) {
		this.balance += points;
	}
	
	public void removePoints(int points) {
		this.balance -= points;
	}
	
	public String sendPointsRequest(int requestedPoints) {
	    
		String request = "Points Request: " + requestedPoints + " points requested by " + this.getUsername();
	    
	    Administrator admin = (Administrator) system.getAdministrator();
	    
	    if (admin != null) {
	        admin.addPointRequest(request);
	        return "Point request sent to the administrator.";
	    } else {
	        return "No administrator account found. Point request not sent.";
	    }
	}

}
