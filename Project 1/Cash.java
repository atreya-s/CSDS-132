
public class Cash {
	
	
	// A private instance field that stores the current balance in the account
		private double balance ; 
		
   // A private instance field that stores the interest rate applied to positive balances
		private double savingsRate ;
	
	// A private instance field that stores the interest rate applied to negative balances 
		private double loanRate;
		
		// A private instance field that stores the loan limit for the account
		private double loanLimit; 
	
		// A private instance field that stores the overdraft penalty for the account
		private double overdraftPenalty ;
		
		public Cash(double savingsRate, double loanRate, double loanLimit, double overdraftPenalty) {
			this.savingsRate = savingsRate ; 
			this.loanRate = loanRate;
			this.loanLimit = loanLimit;
			this.overdraftPenalty = overdraftPenalty;
		
		}	
		
		public double getBalance() {
			
			return balance ;
			
		}
		
		public double getSavingsRate () {
			
			return savingsRate ; 
		}
        
		public void setSavingsRate (double savingsRate) {
			
			this.savingsRate = savingsRate ;
		}
		
		public double getLoanRate () {
			
			return loanRate ; 
		}
		
		public void setLoanRate (double loanRate) {
			
			this.loanRate = loanRate ; 
		}
		
		public double getLoanLimit () {
			
			return loanLimit ; 
		}
		
		public void setLoanLimit (double limit) {
			
			this.loanLimit = limit ; 
		}
		
		public double getOverdraftPenalty () {
			
		      return overdraftPenalty ; 
		}
		
		public void setOverdraftPenalty (double penalty) {
			
			this.overdraftPenalty = penalty ; 
		}
		
		public void deposit (double amount) {
			
		   balance += amount ;
		}
		
		public boolean withdraw (double amount) {
			
			if (amount <= balance) {
				balance -= amount;
				return true;
			}
			
			else 
			{
				return false;
			}
			

		}
		
		public void transfer (double amount) {
			
			balance -= amount ; 
		}
		
		public void processDay() {
			
			double monthlyInterest;
		    if (this.balance >0) {
		      monthlyInterest = savingsRate;
		    }
		    
		    else {
		      monthlyInterest = loanRate;
		    }
		    
		    if(this.balance>=0) {
		      monthlyInterest = this.balance * this.savingsRate / 365 + monthlyInterest;
		    }
		    
		    else {
		      monthlyInterest = (this.balance * this.loanRate) / (365 + monthlyInterest);
		    }
		    
	    }
		
		public void processMonth() { 
		    double monthlyInterest;
		    if (this.balance >0) {
		      monthlyInterest = savingsRate;
		    }
		    else {
		      monthlyInterest = loanRate;
		    }
		    this.balance = this.balance * monthlyInterest;
		    monthlyInterest = 0;
		    if (balance + monthlyInterest < 0 && balance + monthlyInterest > loanLimit) {
		      this.balance = this.balance - overdraftPenalty;
		    }
	    }
		
		 
 
		
}
