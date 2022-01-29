package cards;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

	private static final int MAX_CARD_NUMBER = 14;

	public static List<Card> generateDeck() {
		List<Card> cards = new ArrayList<>();

		Shape[] shapes = Shape.values();

		for (int i = 2; i <= MAX_CARD_NUMBER; i++) {
			for (int j = 0; j < shapes.length; j++) {
				cards.add(new Card(shapes[j], i));
			}
		}
		return cards;
	}

	public static ArrayDeque<Card> handlePlayerCards(List<Card> cards) {
		ArrayDeque<Card> playerCards = new ArrayDeque<>();
		playerCards.addAll(cards);
		return playerCards;
	}

	public static void displayNumberOfCards(Player player1, Player player2) {
		System.out.println(String.format("(%s cards: %d | %s cards: %d)", player1.getName(),
				player1.getCards().size(), player2.getName(), player2.getCards().size()));
	}

	public static void displayCards(Player player1, Player player2) {
		Card player1card = player1.getCards().peek();
		Card player2card = player2.getCards().peek();
		
		String player1cardNumber = getCardLetter(player1card.getNumber());
		String player2cardNumber = getCardLetter(player2card.getNumber());

		System.out.println(String.format("%s: [%s%s] | %s: [%s%s]", player1.getName(), player1cardNumber,
				player1card.getShape().getIcon(), player2.getName(), player2cardNumber, player2card.getShape().getIcon()));

	}
	
	private static String getCardLetter(int number) {
		if (number == 11)
			return "J";
		if (number == 12)
			return "Q";
		if (number == 13)
			return "K";
		if (number == 14) {
			return "A";
		} 
		return String.valueOf(number);
	}

	public static void countBackwards() {
		for (int i = 3; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	public static String checkWinner(Player player1, Player player2) {
		if (player1.getCards().size() == 0 && player2.getCards().size() > 0) {
			return player2.getName();
		}
		if (player2.getCards().size() == 0 && player1.getCards().size() > 0) {
			return player1.getName();
		}
		
		return "match";
	}
	
	public static ArrayDeque<Card> handleWar(Player player1, Player player2) {
		int player1cardsAmount = player1.getCards().size();
		int player2cardsAmount = player2.getCards().size();
		
		if (player1cardsAmount < 3 && player2cardsAmount < 3) {
			player1.removeCard();
			player2.removeCard();
		}
		
		else if (player1cardsAmount >=3 && player2cardsAmount < 3) {
			player2.setCards(new ArrayDeque<Card>()); 
		}
		else if (player2cardsAmount >=3 && player1cardsAmount < 3) {
			player1.setCards(new ArrayDeque<Card>()); 
		}
		
		else { // both can fight
			ArrayDeque<Card> winnerStack = new ArrayDeque<>();
			for (int i=0; i<2; i++) {
				winnerStack.push(player1.removeCard());
				winnerStack.push(player2.removeCard());
			}
			
			return winnerStack;
		}
		
		return new ArrayDeque<Card>();
		
	}

	
	public static void setPlayerNames(Player player1, Player player2) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter first player name: ");
		player1.setName(scan.next());
		System.out.print("enter second player name: ");
		player2.setName(scan.next());
		scan.close();
	}

}
