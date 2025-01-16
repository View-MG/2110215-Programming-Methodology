package logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		for(int i = 0; i < list.size() ; i++) {
			UnitCard x = list.get(i);
			if(card.getName().equals(x.getName())) {
				return true;
			}
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		for(int i = 0; i < list.size(); i++) {
			UnitDeck x = list.get(i);
			if(deck.getDeckName().equals(x.getDeckName())) {
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		for (UnitDeck deck : deckList) {
	        for (CardCounter counter : deck.getCardsInDeck()) { 
	            if (counter.getCard().equals(cardToTest)) {
	            	return true;
	            }
	        }
	    }
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename) {
	    File fileToRead = new File(filename);
	    ArrayList<UnitCard> cardsFromFile = new ArrayList<>();

	    try (Scanner scanner = new Scanner(fileToRead)) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] cardData = line.split(",");

	            if (cardData.length != 5) {
	                System.err.println("Invalid line format: " + line);
	                continue;
	            }

	            String cardName = cardData[0].trim();
	            int bloodCost = Integer.parseInt(cardData[1].trim());
	            int power = Integer.parseInt(cardData[2].trim());
	            int health = Integer.parseInt(cardData[3].trim());
	            String flavorText = cardData[4].trim();

	            UnitCard card = new UnitCard(cardName, bloodCost, power, health, flavorText);
	            cardsFromFile.add(card);
	        }
	    } catch (FileNotFoundException e) {
	        System.err.println("File not found: " + filename);
	        return null;
	    } catch (Exception e) {
	        System.err.println("Error reading file: " + e.getMessage());
	        return null;
	    }

	    return cardsFromFile;
	}


	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
