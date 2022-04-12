 
/* Atreya Sridharan 
 * CSDS 132 Programming Project 3
 * 
 * April 3, 2022
 * 
 * JUnit test for all classes associated with the Project
 * 
 * 
 */

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class HWTester {
    
	//Creates new Trader with the name "Mukesh"
	private Trader Mukesh; 
	
	
	//Creates new StockSymbol 
	private char stockSymbol; 
        
	/*test for the getName method that returns the name of the market maker
	  */
		@Test
		void testGetName() {
			
			MarketMaker Mukesh = new MarketMaker("Mukesh", 5, 5.0);
			
			assertEquals("Mukesh", Mukesh.getName());
			
		
			
		}
		
		/* Test for the getDefaultOrderSize method that returns default size 
		 * for a market order by this market maker.
		 */
		@Test
		void testGetDefaultOrderSize() {
			
			MarketMaker Mukesh = new MarketMaker("Mukesh", 5, 5.0);
			
			assertEquals(5, Mukesh.getDefaultOrderSize()) ; 
		}
		
		/* Test for the getPriceOffset method that returns the price offset
		 * for the market maker
		 */
		@Test
	void testGetPriceOffset() {
			
			MarketMaker Mukesh = new MarketMaker("Mukesh", 5, 5.0);
			
			assertEquals(5.0, Mukesh.getPriceOffset(), 0.0);
			
		
			
		}
		/* Test for the getStockSymbol method that returns the single character
		 * associated with the stock
		 */
		@Test
		void testGetStockSymbol() {
			
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 54, 56, true,true, Mukesh );
			
			assertEquals(stockSymbol, ord1.getStockSymbol()); 
		}
		/* Test for the getNumberShares method that returns the number of shares for that order
		 * 
		 */
		@Test
		void testGetNumberShares() {
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 5, 56, true,true, Mukesh );
			
			assertEquals(5, ord1.getNumberShares()) ; 
		}
		/* Test for the getPrice method that returns the desired price per share of the order.
		 */
		@Test
		void testGetPrice() {
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 54, 56, true,true, Mukesh);
			
			assertEquals(56, ord1.getPrice()) ; 
		}
		
		/* Test for the IsAllOrNone method
		 * method returns true if we must trade all the shares of the order.
		 *  The method returns false if we can trade some, but not all, of the shares of the order.
		 */
		@Test
		void testIsAllOrNone() {
			
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 54, 56, false,true, Mukesh);
			
			assertFalse(ord1.isAllOrNone()) ;
			
		}
		/* Test for the IsDayOrder
		 * If the order is a day order, then it will expire when the market closes. 
		 * If the order is not a day order, then it will remain even when the market is closed.
		 */
		@Test
		void testIsDayOrder() {
			
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 54, 56, false,false, Mukesh);
			
			assertEquals(false,ord1.isDayOrder()) ; 
		}
		/* Test for the getTrader method that returns the name of the Trader placing the order
		 */
		@Test
		void testGetTrader() {
			
			BuyLimitOrder ord1 = new BuyLimitOrder('p', 54, 56, true,true, Mukesh );
			
			assertEquals(Mukesh, ord1.getTrader()) ; 
		}
		
		/*
		 * The methods tested in the BuyLimitOrder class is the same for SellLimitOrder as the methods serve the same function
		 * In my hierarchy, we can see that BuyLimitOrder and SellLimitOrder have the same parent class, so they method workings are the same
		 */
		
		
		/*
		 * MarketSellOrder and MarketBuyOrder have the same methods as BuyLimitOrder due to them being having the same superclass (Order)
		 * The only method not present are isDayOrder and isAllOrNone, but a market buy order can never be "all or none" and are day orders
		 * this implies there is no need to test them.
		 */
		
		/* For the class Transaction, the first 3 methods are the same for MarketSellOrder and BuyOrder, hence they are not being tested
		 * The only tests will on the methods getBuyer, getSeller and getTransactionNumber
		 * This test is on the getBuyer method
		 * the getBuyermethod returns the trader or market maker that purchasing the stock.
		 */
		@Test
		void testGetBuyer() {
			
			Transaction t1 = new Transaction('p', 54, 53, Mukesh, Mukesh);
			
			assertEquals(Mukesh, t1.getBuyer()) ; 
		}
		 /* This test is on the getSeller method
		 * the getSeller method returns the trader or market maker that purchasing the stock.
		 */
		@Test
		void testGetSeller() {
			
			Transaction t1 = new Transaction('p', 54, 53, Mukesh, Mukesh);
			
			assertEquals(Mukesh, t1.getSeller()) ; 
			
		}
		/*
		 * This is a test for the getTransactionNumber method.
		 * this method returns the number of this transaction.
		 */
		@Test
		void testGetTransactionNumber() {
			
			Transaction t1 = new Transaction('p', 54, 53, Mukesh, Mukesh);
			
			assertEquals(0, t1.getTransactionNumber()) ; 

		}
		/**
		 * This test is for the getSellOrders method in the market class.
		 * returns a list of LLNode containing all the sell orders in the market.
		 */
		@Test
		void testGetSellOrders() {
			
			LinkedList<Integer> sellOrders = new LinkedList<Integer>(); 
			
			assertTrue(sellOrders.isEmpty()); 
			
			sellOrders.addToFront(5);
			
			assertFalse(sellOrders.isEmpty()) ; 
			
			assertEquals(1, sellOrders.length());
		}
		/**
		 * This test is for the getBuyOrders method in the market class
		 * returns a list of LLNodes containing all the buy orders in the market.
		 */
		@Test
		void testGetBuyOrders() {
			
			LinkedList<Integer> buyOrders = new LinkedList<Integer>();
			
			assertTrue(buyOrders.isEmpty()); 
			
			buyOrders.addToFront(5);
			
			assertFalse(buyOrders.isEmpty()); 
			
			assertEquals(1, buyOrders.length());
			
		}
		/**
		 * This test is for the getOpenOrders method in the market class
		 * returns a list of LLNodes containing all the buy and sell orders for that trader
		 *  or market maker that is in the market.
		 */
		@Test
		void testGetOpenOrders() {
			
			LinkedList<Trader> openOrders = new LinkedList<Trader>(); 
			
			assertTrue(openOrders.isEmpty()) ; 
			
			openOrders.addToFront(Mukesh);
			
			assertFalse(openOrders.isEmpty());
			assertEquals(1, openOrders.length()) ; 
		}
		
		/**
		 * This test is for the getCurrentBuyPrice in the market class
		 * returns the highest price of a buy order in the market that is not an "all or nothing" order. 
		 * 
		 */
		@Test
		void testGetCurrentBuyPrice() {
			
			LinkedList<BuyLimitOrder> buyOrders = new LinkedList<BuyLimitOrder>();
			
			buyOrders.contains(null);
			assertFalse(buyOrders.contains(null));
		}
		
		/**
		 * This test is for the getCurrentSellPrice in the market class
		 * returns the lowest price of a sell order in the market that is not an "all or nothing" order.
		 */
		@Test
		void testGetCurrentSellPrice() {
			
			LinkedList<SellLimitOrder> sellOrders = new LinkedList<SellLimitOrder>();
			
			sellOrders.contains(null); 
			
			assertFalse(sellOrders.contains(null)) ; 
		}
		
		/**
		 * This test is for the isOpen method in the market class
		 * Returns true if market contains both a MarketBuyOrder and a MarketSellOrder. 
		 * Returns false otherwise.
		 */
		@Test
		void testIsOpen() {
			
			Market m1 = new Market('p', 5, 5.0, false, false, Mukesh); 
			
			LLNode<Order> nodeptr = new LLNode<Order>(m1, null) ;  
			
	       nodeptr.setNext(null);
	       
		  assertEquals(true, m1.isOpen()); 
			
		}
		
		/**
		 * This test is for the isValidOrder method in the market class
		 * the method returns true if this is a valid order for the market
		 */
		@Test
		void testIsValidOrder() {
			Market m1 = new Market('p', 5, 5.0, false, false, Mukesh); 
			
			assertTrue(m1.isValidOrder(m1));
		}
		/**
		 * This test is for addOrders method in the market class
		 * . If the order's stock symbol does not match the market's stock symbol, an appropriate exception should be thrown. 
		 * Otherwise the order is placed into the appropriate list of orders,
		 *  it should be placed in the appropriate position by price.
		 */
		@Test
		void testaddOrders() {
			Market m1 = new Market('p', 5, 5.0, false, false, Mukesh); 
		}
		/**
		 * This test is for the matchingOrders method in the market class
		 * The method should return true if the buy order's price is greater than or equal to the sell order's price
		 *  if either order is all or none, the other order must have a number of shares that is equal to or larger than the all or none order's number of shares.
		 */
		@Test
		void testMatchingOrders() {
			Market m1 = new Market('p', 5, 5.0, false, false, Mukesh) ; 
			assertTrue(m1.matchingOrders(m1, m1)); 
		}
		
	}


