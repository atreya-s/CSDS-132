
public class MarketSellOrder extends MarketOrder {

	public MarketSellOrder(char StockSymbol, int NumberShares, double Price, boolean allOrNone, boolean dayOrder,
			Trader trader) {
		super(StockSymbol, NumberShares, Price, false, true, trader);
		
	}

}
