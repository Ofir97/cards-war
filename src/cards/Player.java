package cards;

import java.util.ArrayDeque;

public class Player {
	
	private String name;
	private ArrayDeque<Card> cards;
	
	public Player() {}
	
	public Player(String name, ArrayDeque<Card> cards) {
		this.name = name;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayDeque<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayDeque<Card> cards) {
		this.cards = cards;
	}
	
	public void addCards(ArrayDeque<Card> cards) {
		cards.forEach(card -> this.cards.add(card));
	}
	
	public void addCard(Card card) {
		cards.addLast(card);
	}
	
	public Card removeCard() {
		return cards.removeFirst();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", cards=" + cards + "]";
	}
	
	

}
