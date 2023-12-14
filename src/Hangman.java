public class Hangman {

    public static final int MAX_MISTAKES = 8;
    private int mistakes;

    private String wordToGuess;
    private final StringBuilder lettersUsed = new StringBuilder();
    private final StringBuilder wordTransformed = new StringBuilder();


    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getMistakes() {
        return mistakes;
    }

    public Hangman(String guessWord) {
        setWordToGuess(guessWord);
        transformWord();
    }


    public void checkResult() {
        System.out.println(wordTransformed);
        if (!wordTransformed.toString().contains("*")) {
            System.out.println("Congratulations you won!");
        } else {
            System.out.println("Unfortunately you lost. Try again.");
        }
    }

    public boolean checkIfLetterUsed(String letter) {
        return lettersUsed.indexOf(letter) != -1;
    }

    public void checkTheWord(String letter) {
        if (!checkIfLetterUsed(letter)) {
            lettersUsed.append(letter);
            String[] wordSplit = wordToGuess.split("");
            if (wordToGuess.contains(letter)) {
                for (int i = 0; i < wordSplit.length; i++) {
                    if (wordSplit[i].equals(letter)) {
                        wordTransformed.replace(i, i + 1, letter);
                    }
                }
                System.out.println(wordTransformed);
            } else {
                mistakes++;
                System.out.printf("Letter %s is not there. Mistakes: %d%n", letter, mistakes);
            }
        } else {
            System.out.println("You already used such letter.");
            System.out.println(wordTransformed);
        }
    }

    public void transformWord() {
        int length = getWordToGuess().length();
        wordTransformed.append("*".repeat(length));
    }

    public void printMenu() {
        System.out.printf("1 - Continue%n2 - Exit %n");
    }


    public String getTransformedWord() {
        return wordTransformed.toString();
    }
}
