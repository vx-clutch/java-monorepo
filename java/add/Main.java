import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Add adder = new Add();
        Scanner scanner = new Scanner(System.in);
        System.out.print("(x) >> ");
        int x = scanner.nextInt();
        System.out.print("(y) >> ");
        int y = scanner.nextInt();
        System.out.print(x + " + " + y + " = ");
        System.out.println(adder.add(x, y));
        if (x == 2) {
            System.out.println("x is 2...");
        } else if (x == 3) {
            System.out.println("x is 3...");
        } else {
            System.out.println("x is not 2, or 3...");
        }
    }
}q