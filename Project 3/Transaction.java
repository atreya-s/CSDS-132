
public class Transaction {

	// Stores the single character symbol of the stock that this buy order is for
	private char stockSymbol; 
	
	// Stores the number of shares of the order
	private int numberShares; 
	
	// Stores desired price per share of the order
	protected double price;
	
	//Stores market maker that placed this order
	private Trader buyer; 
	
	private Trader seller;
	
	private int numberOfTransactions = 0;
	 
	/**
	 * Constructor that initializes a new Transaction
	 * @param StockSymbol the stock symbol associated with the order
	 * @param NumberShares the number of shares 
	 * @param Price the price 
	 * @param Buyer the buyer 
	 * @param Seller the seller
	 * @param allOrNone whether the order is all or none
	 * @param dayOrder whether the order is a day order
	 */

	public Transaction (char StockSymbol, int NumberShares, double Price, Trader Buyer, Trader Seller) {
		
		this.stockSymbol = StockSymbol;
		this.numberShares = NumberShares;
		this.price = Price;
		this.buyer = Buyer; 
		this.seller = Seller;
	}
	
	/**
	 * Getter Method that returns stock symbol of the stock involved in the transaction
	 * @return single chracter symbol of the stock
	 * @param char
	 */
	public char getStockSybmol() {
		return stockSymbol ; 
	}
	
	/**
	 * Getter Method to get the number of shares of the order.
	 * @return  number of shares
	 * @param int
	 */
	
	public int getNumberShares() {
		return numberShares; 
	}
	
	/**
	 * Getter Method that returns the desired price per share of the order
	 * @return desired price per share of the order
	 * @param double 
	 */
	
     public double getPrice() {
		return price; 
	}
	
	/**
	 * Getter Method that returns the market maker that is buying stock.
	 * @return market maker 
	 * @param returns the trader
	 */
     
	public Trader getBuyer() {
		return buyer;
		
	}
	/**
	 * Getter Method that returns the market maker that is selling the stock.
	 * @return market maker 
	 * @param returns the trader
	 */
     
	public Trader getSeller() {
		return seller; 
	}
	
	/**
	 * Getter Method that returns the unique number of transaction
	 * @return Unique number belonging to transaction
	 * @param Unique number should be such that if the earlier transaction should have a smaller unique number
	 */
	public int getTransactionNumber()
	{
		return numberOfTransactions++;
	}
}

