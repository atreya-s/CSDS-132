
public class Date {

	// A private instance field that stores the day of the date; 1<=day<=31
    private int day ; 
    
    // A private instance field that stores the month of the date; 1<=day<=12
    private int month ; 
    
    // A private instance field that stores the year of the date
    private int year ; 
    
    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year ; 
    }
    
    public int getDay() {
    	return day ; 
    }
    
    public int getMonth() {
    	return month ; 
    }
    
    public int getYear() {
    	return year ; 
}
    public void incrementDay() {; 
    	if (day >= 31) {
    		day = 1;
    		month++;	
    	}
        if (month >= 12) {
        	month = 1;
        	year++ ; 
    	}
 
    	}

	@Override
	public String toString() {
		if (month == 1) {
			return ("January" + " " + day + " " + year) ;
		}
		if (month == 2) {
			return ("February" + " " + day + " " + year) ;
		}
		if (month == 3) {
			return ("March" + " " + day + " " + year) ;
		}
		if (month == 4) {
			return ("April" + " " + day + " " + year) ;
		}
		if (month == 5) {
			return ("May"+ " " + day + " " + year) ; 
		}
		if (month == 6) {
			return ("June"+ " " + day + " " + year) ; 
		}
		if (month == 7 ) {
			return ("July"+ " " + day + " " + year) ; 
		}if (month == 8 ) {
			return ("August"+ " " + day + " " + year) ; 
		}
		if (month == 9 ) {
			return ("September"+ " " + day + " " + year) ; 
		}
		if (month == 10 ) {
			return ("October"+ " " + day + " " + year) ; 
		}
		if (month == 11 ) {
			return ("November"+ " " + day + " " + year) ; 
		}
		if (month == 12 ) {
			return ("December"+ " " + day + " " + year) ; 
		}
		return (month + " " + day + " " + year) ; //Will never execute
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Date) {
			Date d = (Date) obj ; 
			return (this.getDay()== d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear() );
		} 
		else 
		{
			return false; 
		}
	}
    
	public static void main (String [] args) {
//		Date date1= new Date(31, 05, 2003) ; 
//		System.out.println(date1.getDay());
//		
//	    Date date2 = new Date(9, 02, 2003) ; 
//	    System.out.println(date2.getMonth());
//	    
//	    Date date3 = new Date(2, 3, 2004);
//	    System.out.println(date3.getYear());
//	    
//	    System.out.println(date1.toString());
//	    date1.incrementDay();
//	    System.out.println(date1.toString());
//	    
//	    System.out.println(date1.equals(date2));
//	    System.out.println(date1.equals(date3));
//	    
	}
	
	
    
    
    }

