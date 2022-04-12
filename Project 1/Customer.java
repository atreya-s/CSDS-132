
public class Customer {

	// A private instance field that stores the first name associated with the account
	private String firstName; 
	
	// A private instance field that stores the last name associated with the account
	private String lastName; 
	
	// A private instance field that stores the address associated with the account
	private String address; 
	
	// A private instance field that stores the Stock instance associated with the account
    private Stock stockAccount; 
    
    // A private instance field that stores the Cash instance associated with the account
    private Cash cashAccount; 
    
    // A private instance field that stores the commission amount associated with the account
    private double commissionAmount; 
    
    // A private instance field that stores the date associated with the account
    private Date date;
    
    
    public Customer(String firstName, String lastName, String Address, double commission, Stock stockAccount, Cash cashAccount, Date date) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.address = Address; 
    	this.commissionAmount = commission;
    	this.stockAccount = stockAccount;
    	this.cashAccount = cashAccount;
    	this.date = date;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName; 
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getAddress() {
    	return address ; 
    }
    
    public void setAddress(String address) {
    	this.address = address ; 
    }
    
    public Stock getStockAccount () {
    	return stockAccount; 
    }
    
    public void setStockAccount (Stock stockAccount) {
    	this.stockAccount = stockAccount ; 
    }
    
    public Cash getCashAccount () {
    	return cashAccount ; 
    }
    
    public void setCashAccount (Cash cashAccount) {
    	this.cashAccount =  cashAccount; 
    }
    
    public double getCommissionAmount(){
    	return commissionAmount;
    	
    }
    
    public void setCommissionAmount (double commission) {
    	this.commissionAmount = commission ; 
    	
    }
    
    public Date getDate() {
    	return date;
    }
   
    public double currentValue() {
    	return ((cashAccount.getBalance() + stockAccount.getNumberShares()) * stockAccount.getCurrentPrice());  
    }
    
    public void deposit (double amount) {
 
    	cashAccount.deposit(amount);
    }
    
    public boolean withdraw (double amount) {
    	
    	return cashAccount.withdraw(amount) ; 
    	}
   
    public void sellShares (int numShares) {
    	
    	stockAccount.sell(numShares, commissionAmount); 
    }
    
    public boolean buyShares(int numShares) {
    	
    	stockAccount.buy(numShares, commissionAmount); 
    	if (this.currentValue() < 0 ) {
    		
    		return false; 
    		
    	}
    	else 
    	{ 
    		cashAccount.transfer(stockAccount.buy(numShares, commissionAmount));
    		return true;
    	}

    
    }
    
    public void incrementDate () {
    	int oldMonth = date.getMonth();
    	int oldYear = date.getYear();
    	double oldInterestEarned = this.yearlyInterestEarned();
    	double oldCapitalGainsEarned = this.yearlyCapitalGainsEarned();
    	date.incrementDay();
    	cashAccount.processDay(); 
    	if(date.getMonth() != oldMonth) {
    		cashAccount.processMonth();
    	}
    		
    	if(date.getYear() != oldYear) {
    		double newInterestEarned = cashAccount.getSavingsRate() - this.yearlyInterestEarned() ; 
    		double newCapitalGainsEarned = stockAccount.getCapitalGains() ; 
    		
    		 
    	}
    		
  
    
    }
   public double yearlyInterestEarned () {
    	return (cashAccount.getSavingsRate()) ; 
    }
    
    public double yearlyCapitalGainsEarned () {
    	return (stockAccount.getCapitalGains()) ;
    }
    
   
}






	

