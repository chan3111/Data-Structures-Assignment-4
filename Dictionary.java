/**   Name: Dictionary.java
 * 	  Purpose: This class models a dictionary.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 4/4/2017
 *	  Data fields:  dictionary: TreeMap<String, Integer> - stores the words made by the user or imported from a file
 *    Methods:  default constructor - initilizes the dictionary TreeMap object 
 *				clearDictionary(): void - clears the TreeMap 
 *				addFromKeyboard(Scanner): void - calls a method to add a word to the TreeMap from keyboard
 *				addFromFile(Scanner): void - calls a method to add words to the TreeMap from a file
 *				addWord(String): void - adds a word to to the TreeMap
 *				searchWord(Scanner): void - searches for number of instances of a single word
 *				numNodes(): void - displays the number of nodes in the TreeMap
 *				findOccurance(String): int - returns 0 if a string is not found otherwise returns number of occurances of word
 *				stripWord(String): String - converts word to all lowercase letters and strips all characters except for a-z
 */
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
	
	private TreeMap<String, Integer> dictionary;
	
	Dictionary(){
		dictionary = new TreeMap<String, Integer>();
	}
	
	public void clearDictionary(){
		dictionary.clear();
		System.out.println("Dictionary cleared");
	}
	
	public void addFromKeyboard(Scanner in){
		System.out.println("Enter word to add: ");
		addWord(in.next());
	}
	
	public void addFromFile(Scanner in){
		while(in.hasNext()){
			addWord(in.next());
		}
	}
	
	public void addWord(String word){
		word = stripWord(word);
		int count = findOccurance(word);
		count++;
		dictionary.put(word, count);
	}
	
	public void searchWord(Scanner in){
		System.out.println("Enter word to search for:");
		String word = in.next();
		System.out.println(word + " occurs " + findOccurance(word) + " times");
	}
	
	public void numNodes(){
		System.out.println("There are " + dictionary.size() + " nodes");
	}
	
	private int findOccurance(String word){
		Integer value = dictionary.get(word);
		if(value == null)
			return 0;
		else
			return value;
	}
	
	private String stripWord(String word){
		return word.toLowerCase().replaceAll("[^a-z]","");
	}
}
