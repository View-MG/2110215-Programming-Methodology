package logic;

public class CardCounter {

	private UnitCard card;
	private int count;

	public CardCounter(UnitCard card, int count) {
		this.card = card;
		setCount(count);
	}

	public UnitCard getCard() {
		return card;
	}

	public void setCard(UnitCard card) {
		this.card = card;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if(count <= 0) {
			count = 0;
		}
		this.count = count;
		
	}
	
	public void addCount(int add) {
		this.count += add;
	}
	
	public void removeCount(int add) {
		this.count -= add;
		if(this.count < 0) this.count = 0;
	}

	public String toString() {
		return this.getCard() + " x " + this.getCount();
	}

}
