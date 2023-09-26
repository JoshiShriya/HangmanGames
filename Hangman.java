import java.util.Scanner;

public class Hangman {
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int maxAttempts;
    private int remainingAttempts;

    public Hangman(String wordToGuess, int maxAttempts) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.remainingAttempts = maxAttempts;
//        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
    }

    public boolean isGameWon() {
        return !currentGuess.toString().contains("_");
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0;
    }

    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        boolean guessedCorrectly = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
                guessedCorrectly = true;
            }
        }

        if (!guessedCorrectly) {
            remainingAttempts--;
        }
    }

    public void displayCurrentStatus() {
        System.out.println("Current Guess: " + currentGuess.toString());
        System.out.println("Remaining Attempts: " + remainingAttempts);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        String wordToGuess = "programming"; // Change this word to be guessed.
        int maxAttempts = 6; // Change the number of maximum attempts.

        Hangman game = new Hangman(wordToGuess, maxAttempts);

        while (!game.isGameOver()) {
            System.out.println("\n--------------------------");
            game.displayCurrentStatus();
            System.out.print("Enter a letter: ");
            char letter = scanner.next().charAt(0);
            game.guessLetter(letter);

            if (game.isGameWon()) {
                System.out.println("Congratulations! You won! The word was: " + wordToGuess);
                break;
            }
        }

        if (!game.isGameWon()) {
            System.out.println("Game over! You ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
