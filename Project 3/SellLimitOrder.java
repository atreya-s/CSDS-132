
public class SellLimitOrder extends LimitOrder {

	/**
	 * Constructor that initializes a new SellLimitOrder
	 * @param stockSymbol the stock symbol associated with the order
	 * @param numberShares the number of shares 
	 * @param price the price 
	 * @param allOrNone whether the order is all or none
	 * @param dayOrder whether the order is a day order
	 * @param trader the trader
	 */

	public SellLimitOrder(char stockSymbol, int numberShares, double price, boolean allOrNone, boolean dayOrder,
			Trader trader) {
		super(stockSymbol, numberShares, price, allOrNone, dayOrder, trader);
	
	}

}
