public class MarketBuyOrder extends MarketOrder {

	/**
	 * Constructor that initializes a new BuyLimitOrder
	 * @param StockSymbol the stock symbol associated with the order
	 * @param NumberShares the number of shares 
	 * @param Price the price 
	 * @param allOrNone whether the order is all or none
	 * @param dayOrder whether the order is a day order
	 * @param trader the trader that placed order
	 */
	
	public MarketBuyOrder(char StockSymbol, int NumberShares, double Price, boolean allOrNone, boolean dayOrder,
			Trader trader) {
		super(StockSymbol, NumberShares, Price, false, true, trader);
		
	}


}
