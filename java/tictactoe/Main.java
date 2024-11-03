import java.util.Scanner;

public class Main {
    private static String[][] board;

    // private static final String invaliderr = "Invalid input: expected input:\n\t<int> <int>.";
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        board = new String[3][3];

        /* row one */
        board[0][0] = " ";
        board[0][1] = " ";
        board[0][2] = " ";
    
        board[1][0] = " ";
        board[1][1] = " ";
        board[1][2] = " ";

        board[2][0] = " ";
        board[2][1] = " ";
        board[2][2] = " ";

        boolean win = false;
        boolean isPlayerOneTurn = true;

        printBoard();
        while (!win) {
            if (isPlayerOneTurn) {
                System.out.print("Player 1: Pick a square (row col) >> ");
            } else {
                System.out.print("Player 2: Pick a square (row col) >> ");
            }
            int col = scanner.nextInt();
            int row = scanner.nextInt();
            String lastChar;
            if (isPlayerOneTurn) {
                board[row][col] = "X";
                lastChar = "X";
                isPlayerOneTurn = false;
            } else {
                board[row][col] = "O";
                lastChar = "O";
                isPlayerOneTurn = true;
            }
            printBoard();
            win = checkWinCondition(lastChar);
        }
        if (!isPlayerOneTurn) {
            System.out.println("Player 1 Wins!");
        } else {
            System.out.println("Player 2 Wins!");
        }
        scanner.close();
    }

    static void printBoard() {
        System.out.println("    0   1   2  ");
        System.out.println("  |---|---|---|");
        System.out.println("0 |-" + board[0][0] + "-|-" + board[1][0] + "-|-" + board[2][0] + "-|");
        System.out.println("  |---|---|---|");
        System.out.println("1 |-" + board[0][1] + "-|-" + board[1][1] + "-|-" + board[2][1] + "-|");
        System.out.println("  |---|---|---|");
        System.out.println("2 |-" + board[0][2] + "-|-" + board[1][2] + "-|-" + board[2][2] + "-|");
        System.out.println("  |---|---|---|");
    }

    static boolean checkWinCondition(String lastChar) {
        int intBoard[][] = new int[3][3];

        /* row one */
        intBoard[0][0] = 4;
        intBoard[0][1] = 4;
        intBoard[0][2] = 4;

        /* row two */
        intBoard[1][0] = 4;
        intBoard[1][1] = 4;
        intBoard[1][2] = 4;

        /* row three */
        intBoard[2][0] = 4;
        intBoard[2][1] = 4;
        intBoard[2][2] = 4;

        /* convert board to int matrix */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X")) {
                    intBoard[i][j] = 1;
                } else if (board[i][j].equals("O")) {
                    intBoard[i][j] = 0;
                }
            }
        }
        /*
         * add up each row, col and diagonal. If they add up to 3 Player one wins, if
         * they are zero player 2 wins
         */
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            rowSum = rowSum + intBoard[0][i];
            rowSum = rowSum + intBoard[1][i];
            rowSum = rowSum + intBoard[2][i];
            if (rowSum == 3) {
                return true;
            }
            int colSum = 0;
            colSum = colSum + intBoard[i][0];
            colSum = colSum + intBoard[i][1];
            colSum = colSum + intBoard[i][2];
            if (colSum == 3) {
                return true;
            }
        }

        int diagSum = 0;
        diagSum = diagSum + intBoard[0][0];
        diagSum = diagSum + intBoard[1][1];
        diagSum = diagSum + intBoard[2][2];

        if (diagSum == 3) {
            return true;
        } else if (diagSum == 0) {
            return false;
        }

        int diag1Sum = 0;
        diag1Sum = diag1Sum + intBoard[0][2];
        diag1Sum = diag1Sum + intBoard[1][1];
        diag1Sum = diag1Sum + intBoard[2][0];

        if (diag1Sum == 3) {
            return true;
        } else if (diag1Sum == 0) {
            return false;
        }

        return false;
    }

    static boolean validate(int x) {
        if (x > 0 && x < 3) {
            return true;
        }
        return false;
    }
}
