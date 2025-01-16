package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;
	
	
	public UnitCard() {
		setName("");
		setBloodCost(0);
		setPower(0);
		setHealth(1);
		setFlavorText("");
	}

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		this.flavorText = flavorText;
	}

	//Name ----------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isBlank()) {
			name = "Creature";
		}
		this.name = name;
	}
	
	//bloodCost -----------------

	public int getBloodCost() {
		return bloodCost;
	}

	public void setBloodCost(int bloodCost) {
		if(bloodCost < 0) {
			bloodCost = 0;
		}
		this.bloodCost = bloodCost;
	}

	//power ----------------------
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if(power <= 0) {
			power = 0;
		}
		this.power = power;
	}
	
	//health -----------------------
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 1) {
			health = 1;
		}
		this.health = health;
	}

	//Text--------------------
	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof UnitCard)) return false;
		UnitCard otherCard = (UnitCard) obj;
		return this.name.equals(otherCard.name);
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
