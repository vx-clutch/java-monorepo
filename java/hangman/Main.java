import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] art = {"____\n|/   |\n|\n|\n|\n|\n|\n|_____", "____\n|   (_)\n|\n|\n|\n|\n|\n|_____", "____\n|   (_)\n|    |\n|    |\n|\n|\n|\n|_____", "____\n|   (_)\n|   \\|\n|    |\n|\n|\n|\n|_____", "____\n|   (_)\n|   \\|/\n|    |\n|\n|\n|\n|_____", "____\n|   (_)\n|   \\|/\n|    |\n|   /\n|\n|\n|_____", "____\n|   (_)\n|   \\|/\n|    |\n|   / \\\n|\n|\n|_____"};
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWelcome to Hangman!");
        String[] possibleAnswers = { "car", "dog", "truck", "keyboard", "unicode", "insert", "normal", "cody", "c" };
        String answer = possibleAnswers[rand.nextInt(possibleAnswers.length)];
        ArrayList<String> correct = new ArrayList<>(Collections.nCopies(answer.length(), "_"));
        System.out.println("The word has " + answer.length() + " letters\n");
        int tries = art.length;
        int rTries = 0;
        while (tries != 0) {
            System.out.println(art[rTries]);
            System.out.println("\nWord: " + correct);
            System.out.println("Tries left: " + tries);
            System.out.print("Guess a letter: ");
            String letter = scanner.nextLine();
            letter.toLowerCase();
            if (!answer.contains(letter)) {
                System.out.println("Incorrect guess.");
                tries--;
                rTries++;
            } else {
                int location = answer.indexOf(letter);
                correct.set(location, letter);
            }
            String correctString = String.join("", correct);
            if (correctString.equals(answer)) {
                System.out.println("You won!");
                System.exit(0);
            }
            System.out.println();
        }
        if (tries == 0) {
            System.out.println("____\n|   (_)\n|   \\|/\n|    |\n|   | |\n|\n|\n|_____");
            System.out.println("You ran out of tries! The correct answer was: " + answer);
        }
        scanner.close();
    }
}
