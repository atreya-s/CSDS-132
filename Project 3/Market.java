import java.util.*;

public class Market extends MarketOrder {
	
/**
* Constructor that initializes a new Market
* @param StockSymbol the stock symbol associated with the order
* @param NumberShares the number of shares
*  @param Price the price 
* @param Buyer the buyer 
* @param Seller the seller
* @param allOrNone whether the order is all or none
* @param dayOrder whether the order is a day order
* @param trader the trader
 */
	public Market(char StockSymbol, int NumberShares, double Price, boolean allOrNone, boolean dayOrder,
			Trader trader) {
		super(StockSymbol, NumberShares, Price, allOrNone, dayOrder, trader);
		
	}
/**
 * Initializes a new LinkedList of type Order that includes all Sell Orders
 */
	public static final LinkedList<Order> sellOrders = new LinkedList<Order>(); 
	
	/**
	 * Initializes a new LinkedList of type Order that includes all Buy Orders
	 */
	public static final LinkedList<Order> buyOrders= new LinkedList<Order>();
	
	/**
	 * Initializes a new LinkedList of type Trader that includes all Open Orders
	 */
    public static final LinkedList<Trader> openOrders = new LinkedList<Trader>(); 
    
  
    
/**
 * Method that returns all of Buy Orders placed
 * @return list of LLNodes containing all the buy orders in the market.
 */
    public LinkedList<Order> getBuyOrders(){
    	return buyOrders;
    }
    /**
     * Method that returns all Sell Orders placed
     * @return list of LLNode containing all the sell orders in the market.
     */
    public LinkedList<Order> getSellOrders() {
    	return sellOrders;
    }
    

    
    /**
     * Returns a list of the buy and sell orders of a given trader
     */
    public LinkedList <Order> getOpenOrders(Trader trader) {
    	
    	LinkedList<Order> openOrders = new LinkedList<>();
    	
    	LLNode<Order> nodeptrSell = sellOrders.getFirstNode();
    	
    	while(nodeptrSell.getNext()!=null) {
    		if(trader.equals(nodeptrSell.getElement().getTrader())){
    			openOrders.addToFront(nodeptrSell.getElement());
    		}
    	}
    	
    	LLNode<Order> nodeptrBuy = buyOrders.getFirstNode();
    	
    	while(nodeptrBuy.getNext()!=null) {
    		if(trader.equals(nodeptrBuy.getElement().getTrader())){
    			openOrders.addToFront(nodeptrBuy.getElement());
    		}
    	}

    	
    	
    	return openOrders;
    }
    
    /**
	 * Method to return the highest price of a buy order in the market
	 * @returns a double
	 * @param takes no input
	 * @param order must not be an "all or nothing" order
	 */
	public double getCurrentBuyPrice() {
		
		
		
		LLNode<Order> nodeptrBuy = buyOrders.getFirstNode();
		
		
		double currentBuyPrice = Integer.MIN_VALUE;
		
    	while(nodeptrBuy.getNext()!=null) {
    		if(nodeptrBuy.getElement().isAllOrNone() == false){
    			if(nodeptrBuy.getElement().getPrice() > currentBuyPrice) {
    				currentBuyPrice = nodeptrBuy.getElement().getPrice();
    			}
    		}
    	}
		
		return currentBuyPrice;
		
		
	} 
	
    /**
     * Method to return the lowest price of a sell order in the marker
     * @returns double
     * @param takes no input
     * @param order must not be an "all or nothing" order
     */
	public double getCurrentSellPrice() {
	
	LLNode<Order> nodeptrSell = sellOrders.getFirstNode();	
	
	double currentSellPrice = Integer.MAX_VALUE;
		
    	while(nodeptrSell.getNext()!=null) {
    		if(nodeptrSell.getElement().isAllOrNone() == false){
    			if(nodeptrSell.getElement().getPrice() < currentSellPrice) {
    				currentSellPrice = nodeptrSell.getElement().getPrice();
    			}
    		}
    	}
		
		
		return currentSellPrice;
	} 
	
	
	
	/**
	 * Method to determine whether MarketBuyOrder and MarketSellOrder is present in the market
	 * @return true if market contains both a MarketBuyOrder and a MarketSellOrder, otherwise false
	 * @param takes no input
	 * @param returns a boolean`
	 */
	public boolean isOpen() {
		
		if(getBuyOrders()==null || getSellOrders()== null) {
			return false;
		}
		
		boolean hasMarketBuyOrder = false;
		boolean hasMarketSellOrder = false;
		
		
		
		LLNode<Order> nodeptrSell = getSellOrders().getFirstNode();
    	
    	while(nodeptrSell.getNext()!=null){
    			if(nodeptrSell.getElement() instanceof MarketSellOrder){
    				hasMarketSellOrder = true;
    			}
    		}
    	
    	LLNode<Order> nodeptrBuy = getBuyOrders().getFirstNode();
    	
    	while(nodeptrBuy.getNext()!=null) {
    		if(nodeptrBuy.getElement() instanceof MarketBuyOrder){
    			hasMarketBuyOrder = true;
    		}
    	}
    	
		
		if (hasMarketBuyOrder && hasMarketSellOrder)
			return true;
		else
			return false;
	
}
	/**
	 * Checks whether if the order is valid or not
	 * @param for an order to valid it must be for the same stock symbol as the market. 
	 * In addition, if the order is a buy order and not a market buy order, the price of the order must not be higher than the highest market sell order,
	 *  and if the order is a sell order and not a market sell order, the price must not be lower than the lowest market buy order in the market.
	 * @return true if this is a valid order for the market
	 */
	public boolean isValidOrder(Order ord) {
		
		if(ord.getStockSymbol()==(this.getStockSymbol())){
			if(ord instanceof BuyLimitOrder) {
				if(ord.getPrice() > getCurrentSellPrice()) {
					return false;
				}
			}else if(ord instanceof SellLimitOrder) {
				if(ord.getPrice() < getCurrentBuyPrice()) {
					return false;
				}
			}
		}
		else{
			return false;
		}
		return true;
	}
	
	/**
	 * adds order to the appropriate linked list
	 * @param If the order's stock symbol does not match the market's stock symbol an appropriate exception should be thrown.
	 * @throws Illegal Argument Exception
	 * 
	 */
	public void addOrder(Order ord) {
		
		if(ord instanceof MarketBuyOrder || ord instanceof BuyLimitOrder) {
			buyOrders.addToFront(ord);
		}else if(ord instanceof MarketSellOrder || ord instanceof SellLimitOrder) {
			sellOrders.addToFront(ord);
			throw new IllegalArgumentException(); 
		}
	}
	
	/**
	 * removes duplicate order
	 * @param If there is an order in the market with the same stock symbol, price, number of shares, and trader or market maker, that order is removed.
	 */
	public void removeOrder(Order ord) {
		LLNode<Order> nodeptrSell = sellOrders.getFirstNode();
    	
    	while(nodeptrSell.getNext()!=null) {
    		if(nodeptrSell.getElement().getStockSymbol()==ord.getStockSymbol() && nodeptrSell.getElement().getPrice()==ord.getPrice() && nodeptrSell.getElement().getNumberShares()==ord.getNumberShares() && nodeptrSell.getElement().getTrader() == ord.getTrader()){
   
    				sellOrders.remove(ord);
    		}
    			
    		}
    	
    	LLNode<Order> nodeptrBuy = buyOrders.getFirstNode();
    	
    	while(nodeptrBuy.getNext()!=null) {
    		if(nodeptrBuy.getElement().getStockSymbol()==ord.getStockSymbol() && nodeptrBuy.getElement().getPrice()==ord.getPrice() && nodeptrBuy.getElement().getNumberShares()==ord.getNumberShares() && nodeptrBuy.getElement().getTrader() == ord.getTrader()){
    		
    				buyOrders.remove(ord);
    		}
	}
    	}
	/**
	 * Compares whether two orders are the same or not
	 * @param Must be buy order or a sell order
	 * @param Order can be limit order or a market order
	 * @return true if the buy order's price is greater than or equal to the sell order's price
	 *  if either order is all or none, the the other order must have a number of shares that is equal to or larger than the all or none order's number of shares.

	 */
	public boolean matchingOrders(Order ord1, Order ord2) {
		if((ord1 instanceof BuyLimitOrder || ord1 instanceof MarketBuyOrder) && (ord2 instanceof SellLimitOrder || ord2 instanceof MarketSellOrder)) {
			if(ord1.getPrice() >= ord2.getPrice() ) {
				if(ord1.isAllOrNone() || ord2.isAllOrNone()) {
					if(ord1.isAllOrNone()) {
						if(ord2.getNumberShares() >= ord1.getNumberShares()) {
							return true;
						}else {
							return false;
						}
					}else {
						if(ord1.getNumberShares() >= ord2.getNumberShares()) {
							return true;
						}else {
							return false;
						}
					}
				}
			}else{
				return false;
			}		
	}
		return false;
	}
	
	/**
	 * Method that allows order to placed
	 * @return a list of Transactions
	 * @throws IllegalArgumentException
	 */
	public LinkedList<Transaction> placeOrder(Order ord) throws IllegalArgumentException {
		if(isValidOrder(ord) == false){
				throw new IllegalArgumentException();  	}
		
		
		
		
		return null;
	}
	/**
	 * All market maker orders are removed from the market and any day order is removed from the market.
	 * @return close market
	 */
	public String closeMarket() {
		
		return "Closed" ; 
		
	}
}


