
public class LimitOrder extends Order {

	/**
	 * Constructor that initializes a new LimitOrder
	 * @param StockSymbol the stock symbol associated with the order
	 * @param NumberShares the number of shares 
	 * @param Price the price 
	 * @param Buyer the buyer 
	 * @param Seller the seller
	 * @param allOrNone whether the order is all or none
	 * @param dayOrder whether the order is a day order
	 * @param trader the trader 
	 */

	public LimitOrder(char stockSymbol, int numberShares, double price, boolean allOrNone, boolean dayOrder,
			Trader trader) {
		super(stockSymbol, numberShares, price, allOrNone, dayOrder, trader);
	
	}

}
