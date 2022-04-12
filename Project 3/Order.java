
public abstract class Order{

	// Private instance field that stores the single character symbol of the stock
	private char stockSymbol ; 
	
	//Private instance field that stores the number of shares of the order
	private int numberShares; 
	
	//Private instance field that stores desired price per share of the order
	private double price ; 
	
	/** Stores whether the order is all or none or not */
	private boolean allOrNone; 
	
	/** Stores whether the order is a day order or not */
	private boolean dayOrder; 
	
	/** Stores the trader that placed the order */
	private static Trader trader ; 
	
	
	public Order(char StockSymbol, int NumberShares, double Price,
			boolean allOrNone, boolean dayOrder, Trader trader) {
		
	} 
	
	public char getStockSymbol() {
		return stockSymbol;
	}
	
	public int getNumberShares() {
		return numberShares; 
	}
	
	public double getPrice() {
		return price; 
	}
	
	public boolean isAllOrNone() {
		return allOrNone ; 
	}
	
	public boolean isDayOrder() {
		return dayOrder; 
	}
	
	public Trader getTrader() {
		return trader ; 
	}
}
