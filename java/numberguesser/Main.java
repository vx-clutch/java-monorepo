import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int target = rand.nextInt(1001);

    System.out.print("(guess a number from 0-1000) >> ");
    int x = scanner.nextInt();

    if (x == target) {
      System.out.println("You gussed: " + x + " and were corret!");
      System.exit(0);
    }
    int guess = 0;
    int guess_left = 5;
    while (x != target) {
      guess++;
      guess_left--;
      if (guess == 5) {
        System.out.println("You took too many guesses. The correct answer was " + target);
        System.exit(0);
      }
      if (target > x) {
        System.out.println(x + " is too small.");
      } else {
        System.out.println(x+ " is too big.");
      }
      System.out.print("(guesses left: " + guess_left + ") >> ");
      x = scanner.nextInt();
    }
    System.out.println("You gussed: " + x + " and were corret! in " + guess + " guesses.");
    scanner.close();
  }
}