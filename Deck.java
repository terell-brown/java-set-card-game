import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Deck {
	
	LinkedList<Card> cards;
	private int deckSize;
	final private int deckMaxSize = 52;
	
	public Deck() {
		cards = new LinkedList<Card>();
		Random intGenerator = new Random();
		for (int i=0; i < deckMaxSize; i++) {
			cards.add(generateRandomCard(intGenerator));
		}
		deckSize = deckMaxSize;
		showCards();
	}

	private Card generateRandomCard(Random intGenerator) {
		
		Card card = new Card();
		card.setColor(intGenerator.nextInt(3)+1);
		card.setShape(intGenerator.nextInt(3)+1);
		card.setShading(intGenerator.nextInt(3)+1);
		card.setNumber(intGenerator.nextInt(3)+1);
		// +1 to achieve random integer in the range from 0 to 3
		
		return card;
	}
	
	public boolean isEmpty() {
		return cards.size() == 0;
	}
	
	public ArrayList<Card> deal() {
		if (cards.size() < 3) {
			return dealCards(cards.size());
		} else {
			return dealCards(3);
		}
		
	}
	
	public ArrayList<Card> dealCards(int numCards) {
		// removes the specified numCards from the deck and returns them in a list
		ArrayList<Card> cardsToDeal = new ArrayList<Card>();
		
		for (int i=0; i < numCards; i++) {
			if (cards.isEmpty()) {
				// no more cards in the deck to deal
				return cardsToDeal;
			} else {
				cardsToDeal.add(cards.poll());
			}			
		}
		
		deckSize = deckSize - numCards;
		return cardsToDeal;
	}
	
	public void showCards() {
		if (cards == null) {
			System.out.println("There are no cards in the deck");
			return;
		} 
		
		System.out.println("Cards in the deck include: ");
		for (Card card: cards) {
			System.out.println("[" + card.getColor() + "," + card.getShape() + "," + card.getShading() + "," + card.getNumber() + "]"  );
		}
	}

	

}
