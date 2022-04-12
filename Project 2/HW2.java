// Atreya Sridharan
import java.util.NoSuchElementException;
public class HW2 {

	public static double average (double arr []) {

		// If length of array = 0, we know that there cannot be any value in the array (regardless of length)
		
		if (arr.length == 0) 
			throw new NoSuchElementException() ; 
		// to calculate sum, we need to a for-loop that iterates through the array, adding it's elements
		
		double sum = 0.0; 
		
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
			
		sum = sum / arr.length ;
		return (double)sum ; 
	} 
	
	public static double average(double arr [][]) {
		
		// the same method done for the single array can be employed here, however, we need two for-loops to iterate through the two different arrays
		
		if (arr.length == 0)
			throw new NoSuchElementException() ; 
		
		
		double sum = 0.0; 
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length ; j++) {
				sum += arr[i][j];
				count++;
			}
		}
		
		sum = sum / count ; 
		return sum ; 
	}
	
	public static int countWords(String sentence) {
		
		//if the string returns a null value, we know that the string is empty. Hence, returning 0
       //we could have also used word.EmptyString() [However, given the parameters of the project, we can only assume the string to have a null value]
		
		if (sentence == null) {
			return 0; 
		}
		
		// Using the definition of a word, we can create a for-loop that runs through the length of the string
		// However, we need two for-loops. One that terminates at the length of the string and one that terminates 1 before (counting for white space)
		
		int sum = 0;
		
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') 
				sum++; 
		}
		
		// Checks if there is a word at the end of the sentence
		if (sentence.charAt(sentence.length() - 1) != ' ')
			sum++;
		
		return sum; 
	}
	
	public static String truncate (String word, int maxlength) {
		
		// Initializing string builder to store words/characters as they're put in the loop
		StringBuilder builder = new StringBuilder(); 
		
		int index = 0; 
		int count = 0; 
	    int i = 0; 
	    
	    if (maxlength == 0 )
	    	return "" ; 

	    
	    // Loops through the entire string to check if at any index, there is a blank space
	    for(int loop  = 0; loop < word.length(); loop++) {
	    	if (word.charAt(i) != ' ' && word.charAt(i) != '-') {
	    		count = count + 1; 
	    	}
	    	
	    	if (count == maxlength) {
	    		index = 1;
	    	}
	    	
	    	i = i + 1; 
	    }
	    
	    if (index == 0) {
	    	int j = 0 ; 
	    	
		    //loops through entire string to add space at space j
		    for (int loop = 0; loop < word.length(); loop++) {	
		    	if (word.charAt(j) != '-')
		    		builder.append(word.charAt(j));
		    	j = j + 1 ; 
		    }
	    }
	    
	    else {
	    	for (;word.charAt(index) != ' ' && word.charAt(index) != '-'; index++) {
	    			
	    }
	    	int k = 0; 
	    	while (k < index) {
	   			if (word.charAt(k)!= '-') {
	   				builder.append(word.charAt(k)) ; 
	   			}
	   			k = k + 1; 
    			if ( k == index) {
	    			if(word.charAt(k) == '-') {
	    				builder.append(word.charAt(k)) ; 
	    			}
	    		}
	   		}
	    		
	    }
	    
	    return builder.toString() ; 
	}	
	
	// To return a String with the space evenly distributed, with respect to the int parameter
	public static String padString (String character, int length) {
		
		// String builder to store words/character as added into the loop
		StringBuilder builder = new StringBuilder ();
		
		int index ; 
		int whiteSpaceCount = 0; 
	
		// To identify how much space must be distributed between the words, a for-loop needs to be created to check the index of the first WhiteSpace
		
		for (index = 0; index < character.length() && Character.isWhitespace(character.charAt(index)); index--)  {
		}; 
		
		int firstCharacterIndex = index ; 
		
		// To identify how much space must be distributed between the words, a for-loop needs to be created to check the index of the last WhiteSpace
		for (index = character.length() - 1; index > firstCharacterIndex && Character.isWhitespace(character.charAt(index)); index = index -1) {
		}; 
		
		int lastCharacterIndex = index ; 
		
		// Keeps track of the number of whiteSpaces in a given String
		for (index = 0; index < lastCharacterIndex ; index++){
			
			// Identifying whether a space is a space or not
			// Using a character method to check for WhiteSpace at a certain Index (method found online)
			boolean currentChar = Character.isWhitespace(character.charAt(index)); 
			
			boolean nextChar = Character.isWhitespace(character.charAt(index+1)) ; 
			if (currentChar && !nextChar) {
				whiteSpaceCount = whiteSpaceCount + 1; 
			}
		}
		
		//Tracks the length of the string from fist to last WhiteSpace
		int newLength = lastCharacterIndex - firstCharacterIndex ;
		
		// for loop that iterates through out the first character index, adding space to the beginning 
		for( index = 0; index < firstCharacterIndex; index++) {
			
			char phrase = character.charAt(index) ; 
			builder.append(phrase) ; 
			
		}
		
		// Keeps track of how much space to add
		int spacesToAdd = (length - character.length()); 
		
		// Adds to the String Builder the first non WhitesSpace character to the last WhiteSpace character
		for( index = firstCharacterIndex; index < lastCharacterIndex; index++) {
			
			char phrase = character.charAt(index) ; 
			boolean currentPhrase = Character.isWhitespace(character.charAt(index)) ; 
			boolean nextPhrase = Character.isWhitespace(character.charAt(index + 1)) ; 
			
			// Adds Phrases until a Space is met
			if (!currentPhrase) {
				builder.append(phrase);
			}
			
			// Adds the number of space required for the string to match the parameter length
			else if (currentPhrase && !nextPhrase) {
				
				int numberAdded = (spacesToAdd / whiteSpaceCount) ; 
				
				for (int newIndex = 0; newIndex <= numberAdded; newIndex++) {
					builder.append(' ') ; 
				}
				
				spacesToAdd = spacesToAdd - numberAdded ; 
				whiteSpaceCount = whiteSpaceCount - 1 ;
			}
		}
		
		for (index = lastCharacterIndex; index < character.length(); index++) {
			char phrase = character.charAt(index) ; 
			builder.append(phrase) ; 
		}
		
		return builder.toString() ; 
	}
	
	// To make prettyPrint easier, I created a new method that removes WhiteSpace from the first non WhiteSpace character
	public static String removeSpaceFromFront (String expression) {
		
		// Stores the character as they're added in the String
		StringBuilder builder = new StringBuilder () ;
		int index; 
		
		// Stores index of the first non-whitespace in the string
		for( index = 0; index < expression.length() && Character.isWhitespace(expression.charAt(index)); index++) {
		}
		
		//Recreates String without the original WhiteSpace
		
		while (index < expression.length()) {
			char character = expression.charAt(index) ; 
			builder.append(character) ; 
			index = index + 1;	
		}
		
		return builder.toString() ; 
	}
	
	// Prints String with respect to int parameter
	public static void prettyPrint (String word, int width) {
		
		// Stores character as added into String
		StringBuilder builder = new StringBuilder () ; 
		int index; 
		String line; 
		int lineLength = width ; 
		
		// Prints line from current index for a specified width
		for(index = 0; word.length() > index && lineLength >= width ; ) {
			
			// Makes a String from the current index to the index of the specified width 
			for (;builder.toString().length() <= width && word.length() > index; index++) {
				
				char character = word.charAt(index) ; 
				builder.append(character) ; 
				
			}
			
			// Keeps track of the index of the space behind the width index
			for(!Character.isWhitespace(word.charAt(index - 1)); index--) {
				
			};
			
			lineLength = builder.toString().length() ; 
			
			// Uses two previous methods in order to make it easier to conceptualize 
			line = padString (truncate(removeSpaceFromFront(builder.toString()), width - 1), width) ; 
			System.out.println(line);
		}
		
		builder = new StringBuilder () ; 
	}
}
	



