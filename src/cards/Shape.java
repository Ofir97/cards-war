package cards;

public enum Shape {
	
	DIAMOND("◆"), CLUB("♣"), HEART("♥"), SPADE("♠");
	
	private String icon;
	
	Shape(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
}
