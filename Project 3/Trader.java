public abstract class Trader {

	/* Private instance field that stores name */
	private String name; 
	 
	/**
	 * Constructor that initializes the name of the trader
	 * @param name the name of the trader
	 */
	public Trader(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the trader
	 * @return the name of the trader
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * Changes the name of the trader
	 * @param name the new name of the trader
	 */
	public void setName(String name) {
		this.name = name ; 
	}
	
}
