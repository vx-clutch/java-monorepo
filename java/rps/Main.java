import java.util.Random;
import java.util.Scanner;

public class Main {

    enum Moves {
        R,
        P,
        S,
        Q
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Rock, Paper, Scissors!");
        while (true) {
            Moves[] cOpt = {Moves.R, Moves.P, Moves.S};
            Moves computer = cOpt[rand.nextInt(3)];
            System.out.print("Choose (R)ock, (P)aper, (S)cissors, or (Q)uit >> ");
            Moves player = Moves.valueOf(Character.toString(scanner.nextLine().charAt(0)).toUpperCase());
            if (player == Moves.Q) {
                System.out.println("exit.");
                scanner.close();
                System.exit(0);
            }
            if (player == Moves.R && computer.equals(Moves.S)) {System.out.println("You win.");}
            else if (player == Moves.R && computer.equals(Moves.P)) {System.out.println("You lose.");}
            else if (player == Moves.P && computer.equals(Moves.R)) {System.out.println("You win.");}
            else if (player == Moves.P && computer.equals(Moves.S)) {System.out.println("You lose.");}
            else if (player == Moves.S && computer.equals(Moves.P)) {System.out.println("You win.");}
            else if (player == Moves.S && computer.equals(Moves.R)) {System.out.println("You lose.");}
            else {
                System.out.println("You tied.");
            }
    }
    }
}