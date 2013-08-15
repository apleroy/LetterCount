/*
Andy LeRoy
7/20/2013
Authorship.java - determines word count and proportion of various words within file
Constructs two array objects to hold the word counts and related percent of totals
See file - AuthorshipArray class
*/


import java.io.*;
import java.util.*;

public class Authorship {

	public static void main (String[] args) throws FileNotFoundException {
		
		if (args.length < 1) {
			System.out.println("Please enter a valid file name.  Try again...");
			System.exit (0);
		}
			
		File f = new File(args[0]);
		Scanner input = new Scanner(f);

		AuthorshipArray wordStoreArray = new AuthorshipArray(); //constructs new object
		//used to hold all values and word counts which will be returned

		ArrayList<String> fileStrings = new ArrayList<String>();

		while(input.hasNext()) {
			fileStrings.add(input.nextLine()); //put all lines from file in array list
		}

		for (int i = 0; i < fileStrings.size(); i++) {

			String lineString = fileStrings.get(i); //get each line from array list
			wordStoreArray.updateArray(lineString); //pass each line in the file as a string for calculation

		}


		System.out.println(wordStoreArray.printResults());
		System.out.println("Finished");
	}

}