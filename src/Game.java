import java.util.Scanner;
import static database.WordsDatabase.*;

public class Game {
    private static final int NEXT_GAME = 1;
    private static final int EXIT_GAME = 2;

    private static final Scanner scanner = new Scanner(System.in);

    public void startNewGame() {
        Hangman hangmanGame = new Hangman(drawRandomWord());
        printInformationAboutWord(hangmanGame.getTransformedWord());
        String letter;
        do {
            letter = getLetter();
            hangmanGame.checkTheWord(letter);
        } while (hangmanGame.getTransformedWord().contains("*") && hangmanGame.getMistakes() < Hangman.MAX_MISTAKES);
        hangmanGame.checkResult();
        hangmanGame.printMenu();
        int menuValue = scanner.nextInt();
        switch (menuValue) {
            case NEXT_GAME -> startNewGame();
            case EXIT_GAME -> System.out.println("Bye bye!");
        }
    }

    public void printInformationAboutWord(String word) {
        System.out.printf("Word to guess: %s%n", word);
    }

    public static String getLetter() {
        System.out.printf("Enter letter: %n");
        String letter = scanner.next();
        if (!letter.matches("[a-z, A-Z]")) {
            System.out.printf("You have entered incorrect value. It should be a letter%n");
        }
        return letter;
    }
}