package hangmanOIT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangman {
	
	
	
	public static void main(String[] args) {
		
		String[] words = {"apple", "banana", "orange", "grape", "pineapple",
	            "strawberry", "watermelon", "kiwi", "blueberry", "peach",
	            "pear", "mango", "cherry", "lemon", "apricot",
	            "plum", "melon", "raspberry", "papaya", "fig"};
		
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter to play a new game or type exit to quit: ");
			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("exit")) {
				break;
			}
			else {
				playGame(words,scanner);
			}
			
		}
		
		System.out.println("Good Bye!");	
		
		
		
	}
	
	
	private static void playGame(String words[], Scanner scanner) {
Random random = new Random();
		
		String randomWord = words[random.nextInt(words.length)];
		
		
		Scanner scanners = new Scanner(System.in);
		
		System.out.println("Let's play HangMan!\n\n");
		
		
		int tries = 0;
		String hiddenWord = "";
		
		for(int i = 0; i < randomWord.length(); i++) {
			
			hiddenWord += " - ";
		}
			
		
		System.out.println(hiddenWord);
		
		
		List<Character> guesses = new ArrayList<>();
		
		
		
		while(true) {
		System.out.print("\n\nEnter a letter: ");
		String letter = scanners.nextLine();
		guesses.add(letter.charAt(0));
		status(randomWord, guesses);
		tries++;
		
		if(correctGuess(randomWord,guesses)) {
			System.out.println("\n Congrasts you won in " + tries + " tries");
			break;
		}
		
		}
		
	}
	
	
	private static void status(String word, List<Character> guesses ) {
		
		for(int i = 0; i< word.length(); i++) {
			if(guesses.contains(word.charAt(i))){
				System.out.print(word.charAt(i));
				
			} else {
				System.out.print(" - ");
			}
		}
	}
	
	private static boolean correctGuess(String word, List<Character> guesses) {
		for(int i = 0; i< word.length(); i++) {
			if(!guesses.contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}

}
