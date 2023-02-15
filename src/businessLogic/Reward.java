package businessLogic;

public class Reward {
		
	private String name;
	private String description;
	private int cost;
	private int quantity;
	
	public Reward(String name, String desc, int cost, int quantity) {
		this.name = name;
		this.description = desc;
		this.cost = cost;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
