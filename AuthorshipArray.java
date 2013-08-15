/*Andy LeRoy
7/20/13
AuthorshipArray class
This class constructs two arrays - the first (wordStoreArray) holds the occurences of certain letter words
The second array (percentStoreArray) holds the percentages of each occurence based on the total- it is dependent upon the first array

The wordStoreArray takes a given string from main and calculates the number and length of given words.
The calculation only counts letters but preserves a word in tact until a ' ' has been shown.
For example the word can't will be read as one word but with only 4 letters.
*/


public class AuthorshipArray {

		private int [] wordStoreArray; //holds the count of all given lengths of words 
		//position (i +1) in the array corresponds to the word length
		private double [] percentStoreArray;


    	//1 - CONSTRUCT ARRAYs - constructor for initial arrays - 13 possibilities for each
    	//words of length 1-13+
    	public AuthorshipArray () {
    	
    		wordStoreArray = new int[13];
    		percentStoreArray = new double [13];
    	}
    
   		//Update the array of word type count.  Pass in any given string from main.
    	public int[] updateArray (String s) {
        	
        	int stringCountIndex = 0;
			int letterCount = 0;
    	
			while (stringCountIndex < s.length()) {
			
				letterCount = 0;
				//is this character a letter- start the method
				if ((s.charAt(stringCountIndex) >= 65 && s.charAt(stringCountIndex) <= 90) || 
					(s.charAt(stringCountIndex) >= 97 && s.charAt(stringCountIndex) <= 122)) {	 
					
					letterCount++;
					
					//if there is a letter - start the method to count how many letters are in the word
					//go until the next character is a space.
					//keep track of the characters passed
					
						while ((stringCountIndex + 1) < s.length() && ((s.charAt(stringCountIndex + 1)) != ' ')) {
							stringCountIndex++;
							if ((s.charAt(stringCountIndex) >= 65 && s.charAt(stringCountIndex) <= 90) || 
								(s.charAt(stringCountIndex) >= 97 && s.charAt(stringCountIndex) <= 122)) {
								letterCount++;
							}

						}
					if (letterCount >= 13) {letterCount = 13;} //max of 13 letters to be passed into arrays
				
				wordStoreArray[letterCount - 1]++; //increment the array at the appropriate index - index 0 is a one letter word
				stringCountIndex++;
				}

				else {
					stringCountIndex++;
				}
				
			}
			percentStoreArray(wordStoreArray); //pass the array into the percent array to determine the sum of totoal words and percents
			return wordStoreArray;
		}

		public double[] percentStoreArray(int [] n) {
		//pass in an int array and determine the percent of each element- store in array of doubles
			int sum = 0;

			for(int i = 0; i < n.length; i++) {
				sum+= n[i];
			}

			for(int j = 0; j < percentStoreArray.length; j++) {

				percentStoreArray[j] = (double) Math.floor((n[j] / (sum * 1.0)) * 10000) / 100; //round off the double as a percent with two digits
			}

			return percentStoreArray;
		}



		public String printResults() {
		//build a string to be returned by looping through the arrays - special case for 13+.
			String s = "\n";
			

			System.out.println("File Analysis:");
		
        		for (int i = 0; i < wordStoreArray.length - 1; i++) {//case for thirteen is different and has it' own line ("or more" case)
    		
            		s+= ("Proportion of " + (i+1) + "-letter words: " + percentStoreArray[i] + "%  (" + wordStoreArray[i] + " words)");
            
        			s+= "\n";
       			}

       			s+= ("Proportion of 13 (or more) -letter words: " + percentStoreArray[12] + "%  (" + wordStoreArray[12] + " words)");

       		return s;
       	}
		
}

