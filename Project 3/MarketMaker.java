/**
 * A class to represent a market maker
 * @author Atreya Sridharan
 *
 */
public class MarketMaker extends Trader {
	
	int defaultordersize;
	
	double priceoffset; 
	/**
	 * Constructor that initializes the name of the trader
	 * @param name the name of the trader
	 * @param defaultOrderSize the orderSize placed
	 * @param priceOffset the price offset for the market
	 */
    public MarketMaker(String name, int defaultOrderSize, double priceOffset) {
		super (name); 
		this.defaultordersize = defaultOrderSize;
		this.priceoffset = priceOffset; 
    }
	
    /**
     * Returns default order size
     * @return default order size
     */
	public int getDefaultOrderSize() {
		return defaultordersize; 
	}
	
	/**
	 * Updates the default order size
	 * @param defaultOrderSize the new default order size
	 */
	public void setDefaultOrderSize (int defaultOrderSize) {
		this.defaultordersize = defaultOrderSize; 
	}
	
	/**
	 * Returns the price offset
	 * @return the price offset
	 */
	public double getPriceOffset() {
		return priceoffset; 
	}
	
	/**
	 * Updates the price offset
	 * @param priceOffSet the new price offset
	 */
	public void setPriceOffset(double priceOffSet) {
		this.priceoffset = priceOffSet; 
	}
}
