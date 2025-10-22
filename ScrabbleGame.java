// Samantha Castillo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScrabbleGame {

    // data structure to hold dictionary of words
    private static List<Word> dictionary = new ArrayList<Word>();

    public static void main (String[] args) {

        //readin text file of words and definitions into my ArrayList
        Scanner in = null;
        try {
            in = new Scanner(new File("definitions.txt"));
            while (in.hasNextLine()) {
                String word = in.next();
                String def = in.nextLine().trim();
                dictionary.add(new Word(word, def));
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        //MY EDIT ************ 
        Collections.sort(dictionary); //sort dictionary for binary search

        Random rand = new Random(); //randomization for letters
        String letters = "";

        for (int i = 0; i < 4; i++) { //outputs 4 letters only
            char c = (char) ('A' + rand.nextInt(26));
            letters += c;
        }

        System.out.println("Your letters are: " + letters);
        System.out.print("Enter a word using these letters: ");

        Scanner input = new Scanner(System.in); //user input of four letters given
        String userWord = input.nextLine().toUpperCase();

        if (userWord.length() > 4) { //checks if word is longer than 4 letters
            System.out.println("word cannot be longer than 4 letters.");
            return;
        }

        int index = binarySearch(dictionary, userWord); //check if word is real
        if (index != -1) {
            Word foundWord = dictionary.get(index);
            System.out.println("Definition: " + foundWord.getDefinition()); //word found in dictonary
         } else {
            System.out.println(userWord + " is not a real word."); //word not found in dictionary
        }
        // END OF MY EDIT ********

      // for (Word w: dictionary){ 
            // System.out.println(w);
      //  }
} //end scrabblegame class

    //binary seach for a word in dictionary
    public static int binarySearch(List<Word> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            int cmp = list.get(mid).compareTo(new Word(target, ""));
            if (cmp==0) { 
                return mid; //found
            } else if(cmp <0){
                left = mid +1; //search right half
            } else {
                right = mid-1;// search left
            }
        }
        

        return -1; // not found
    }
}