package cards;

public class Card {
	
	private Shape shape;
	private int number;
	
	public Card() {}
	
	public Card(Shape shape, int number) {
		this.shape = shape;
		this.number = number;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Card [shape=" + shape + ", number=" + number + "]";
	}
	
}
