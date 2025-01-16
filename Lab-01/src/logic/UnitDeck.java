package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		setDeckName(deckName);
		this.cardsInDeck = new ArrayList<>();
	}
	
	
	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		if(deckName.isBlank()) {
			deckName = "Untitled Deck";
		}
		this.deckName = deckName;
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
	
	public void addCard(UnitCard newCard, int count) {
		if(count <= 0) return;
		for(int i = 0; i < cardsInDeck.size(); i++) {
			CardCounter x = cardsInDeck.get(i);
			if(x.getCard().equals(newCard)) {
				x.addCount(count);
				return;
			}
		}
		this.cardsInDeck.add(new CardCounter(newCard,count));
	}
	public void removeCard(UnitCard toRemove, int count) {
		if(count <= 0) return;
		for(int i = 0; i < cardsInDeck.size(); i++) {
			CardCounter x = cardsInDeck.get(i);
			if(x.getCard().equals(toRemove)) {
				if(x.getCount() - count > 0){
					x.removeCount(count);
				}else {
					cardsInDeck.remove(x);
				}
				return;
			}
		}
	}
	public int cardCount() {
		int allCard = 0;
		for(int i = 0; i < cardsInDeck.size(); i++) {
			allCard += cardsInDeck.get(i).getCount();
		}
		return allCard;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for(int i = 0; i < cardsInDeck.size(); i++) {
			CardCounter x = cardsInDeck.get(i);
			if(x.getCard().equals(card)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		UnitDeck otherCard = (UnitDeck) other;
		return this.deckName == otherCard.deckName;
	}
	
}
