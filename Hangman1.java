import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Hangman1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("/Users/shriyajoshi/eclipse-workspace/Codesforfun/src/Ramdomizer"));
		Scanner playerInput = new Scanner(System.in);

		List<String> words = new ArrayList<>();

		while (s.hasNext()) {
			words.add(s.nextLine());
		}

		Random random = new Random();

		String word = words.get(random.nextInt(words.size()));

//		System.out.println(word); // print later

		List<Character> playerguesses = new ArrayList<>();

		int wrongcount = 0;
		while(true) {
			
			printHanged(wrongcount);
			if(wrongcount>=6) {
				System.out.println("YOU LOSE!!!");
				break;
			}
			printWordState(word, playerguesses);
			if(!getPlayerGuess(playerInput, word, playerguesses)) {
				wrongcount+=1;
			}
			if(printWordState(word, playerguesses)) {
				System.out.println("YOU WIN!!!!!");
				break;

			}
			System.out.println("Please Enter your guess for the word");
			if(playerInput.nextLine().equals(word)) {
				System.out.println("YOU WIN!!!!!");
				break;

			}
			else {
				System.out.println("Nope! Try Again!");
			}
		}
	}

	private static boolean printWordState(String word, List<Character> playerguesses) {
		int correctCount =0; 
		
		for(int i = 0; i < word.length(); i++) {
			if(playerguesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctCount +=1;
			}
			else {
				System.out.print("-");

			}
		}
		System.out.println();
		return(word.length() == correctCount);
	} 
	
private static boolean getPlayerGuess(Scanner playerInput, String word, List<Character> playerguesses) {
	System.out.println("Enter a Letter");
		
		String guess = playerInput.nextLine();
		
		playerguesses.add(guess.charAt(0));

		return word.contains(guess);
	}
private static void printHanged(Integer wrongcount) {
	System.out.println("-------");
	System.out.println(" |    |");
	if(wrongcount >=1) {
		System.out.println(" O");
	}
	if(wrongcount >=2) {
		System.out.print("\\ ");
		if(wrongcount >=3) {
			System.out.println(" /");
		}
		else {
			System.out.println("");

		}

	}
	if(wrongcount >=4) {
		System.out.println(" |");
	}
	if(wrongcount >=6) {
		System.out.print("/ ");
		if(wrongcount >=6) {
			System.out.print("  \\");
		}
		else {
			System.out.println("");

		}

	}
}
}

