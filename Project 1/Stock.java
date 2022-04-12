
public class Stock {

	// A private instance field that stores the name for the stock
	private String companyName ; 
	
	// A private instance field that stores the stock market ticker symbol
	private String tickerSymbol ; 
	
	// A private instance field that stores the current price for a share of the stick
	private double currentPrice ; 
	
	// A private instance field that stores the number of shared owned in the stock
	private int numberShares ; 
	
	// // A private instance field that stores the cost basis for the owned shares
	private double costBasis ; 
	
	// A private instance field that stores the total capital gains earned so far
	private double capitalGains ;
	
	public Stock(String tickerSymbol, double currentPrice) {
		this.tickerSymbol = tickerSymbol;
		this.currentPrice = currentPrice;
	}
	
	public Stock(String companyName, String tickerSymbol, double currentPrice) {
		this.companyName = companyName ; 
		this.tickerSymbol = tickerSymbol ; 
		this.currentPrice = currentPrice ;
	}
	
	
	public String getCompanyName () {
		
		return companyName ; 
	}
	
	public void  setCompanyName (String name) {
		this.companyName = name ;
	}
	
	public String getTickerSymbol () {
		
		return tickerSymbol ; 
	}
	
	public void setTickerSymbol (String tickerSymbol) {
		this.tickerSymbol = tickerSymbol ; 
	}

	
	public double getCurrentPrice () {
	
		return currentPrice ;
	}
	
	public void setCurrentPrice (double price) {
		this.currentPrice = price ; 
	}
	
	public int getNumberShares () {
		
		return numberShares ; 
		
	}
	
	public double getCostBasis () {
		
		return costBasis ;
	}
	
	public double getCapitalGains () {
		
		return capitalGains ; 
	}
	
	public double buy (int numShares, double commission) {
		
		numberShares += numShares ; 
		costBasis += ((numShares * this.getCurrentPrice()) + commission);
		return this.costBasis ; 
	}
	
    public double sell (int numShares, double commission) {
    	
    	if (numShares > this.getNumberShares() == true) {
    		return 0.0;
    	}
    	else
    	{
    		double decrease = (double)(numShares / this.getNumberShares());
    		costBasis -= decrease;
    		capitalGains += ((numShares * this.getCurrentPrice()) - commission - decrease);
    		numberShares -= numShares;
    		return (capitalGains + decrease);
    	}
    	
    	
    	
    }
    
    public double split (int ratioNumerator, int ratioDenominator) {
    	
    	if (ratioNumerator <= 0 || ratioDenominator <= 0) {
    		return 0.0 ; 
    	
    	}
    	else
    	{
    		double charges = ratioNumerator / ratioDenominator;
    	      if (charges >= (int)charges + 0.5)  charges = (int)charges + 1;
    	      else if (charges < (int)charges + 0.5)  charges = (int)charges;
    	      this.numberShares = (int)(numberShares * charges);
    	      return (double)(this.numberShares * currentPrice);
    		
    	}
    		
    }
	public static void main (String [] args) {
//	Stock s1 = new Stock("A123", 1.0);
//	    Stock s2 = new Stock("Nike", "5g&", 2.0);
//	    s1.setCompanyName("Case Western Reserve University");
//	    System.out.println(s1.getCompanyName());
//        s2.setTickerSymbol("CWRU");
//       System.out.println(s2.getTickerSymbol());
//       s1.setCurrentPrice(200.0);
//       System.out.println(s1.getCurrentPrice());
//       System.out.println(s1.getNumberShares());
//       System.out.println(s2.getCostBasis());
//      System.out.println(s2.getCapitalGains());
//     System.out.println(s1.buy(5,1));
//       System.out.println(s1.sell(-1, 0.35));
//       System.out.println(s2.sell(1,0.35)) ; 
//       System.out.println(s1.split(2,-1));
//       System.out.println(s1.split(2, 1));
 	
	    
	}
}

	
