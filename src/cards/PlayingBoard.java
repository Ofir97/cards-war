package cards;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;

public class PlayingBoard {

	public static void main(String[] args) {
		List<Card> cards = Utils.generateDeck();
		Collections.shuffle(cards);

		Player player1 = new Player();
		Player player2 = new Player();
		
		player1.setCards(Utils.handlePlayerCards(cards.subList(0, 26)));
		player2.setCards(Utils.handlePlayerCards(cards.subList(26, 52)));
		Utils.setPlayerNames(player1, player2);

		startGame(player1, player2);

	}

	public static void startGame(Player player1, Player player2) {
		
		ArrayDeque<Card> winStack = new ArrayDeque<Card>();

		while (player1.getCards().size() > 0 && player2.getCards().size() > 0) {

			Utils.displayCards(player1, player2);

			int player1cardNumber = player1.getCards().peek().getNumber();
			int player2cardNumber = player2.getCards().peek().getNumber();

			if (player1cardNumber > player2cardNumber) {
				System.err.println(player1.getName() + " wins!");
				player1.addCard(player2.removeCard());
				player1.addCard(player1.removeCard());
				player1.addCards(winStack);
				winStack = new ArrayDeque<Card>();
				
			} else if (player1cardNumber < player2cardNumber) {
				System.err.println(player2.getName() + " wins!");
				player2.addCard(player1.removeCard());
				player2.addCard(player2.removeCard());
				player2.addCards(winStack);
				winStack = new ArrayDeque<Card>();
				
			} else { 
				System.err.println("WAR!");
				for (Card card : Utils.handleWar(player1, player2)) {
					winStack.add(card);
				}
			}
			
			Utils.displayNumberOfCards(player1, player2);
			
			System.out.println("--------------------------------------\n");
			
			Utils.countBackwards();
		}
		
		
		String winnerName = Utils.checkWinner(player1, player2);
		if (winnerName.equals("match"))
			System.out.println("It's a match!");
		else System.err.println(winnerName + " wins!!!");
	}

}
