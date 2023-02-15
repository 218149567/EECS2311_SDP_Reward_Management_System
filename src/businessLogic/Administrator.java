package businessLogic;

public class Administrator extends Account{
	
	public Administrator() {
	}
	
	public Administrator(String name, String username, String password) {
		super(name, username, password);
		this.role = "AD";
	}
}
