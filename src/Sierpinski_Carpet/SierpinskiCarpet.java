package Sierpinski_Carpet;

import java.util.Scanner;

public class SierpinskiCarpet {
    private static char[][] board;

    public static boolean sierp(int i, int j, int n, int ignoredSize, char[][] board) {
        // The base case is when n == 0
        /*
  0 1 2 j
0 * * *
1 *   *
2 * * *
i
 */
        if (n == 0) {
            return false;
        }

        // Calculates the size of the current 3x3 grid
        double gridSize = Math.pow(3, n);
        double pwr = 1 * Math.pow(3, n - 1);

        // Checks if the current position is within the middle square of the current grid
        if (((i % gridSize >= pwr && i % gridSize < pwr + pwr)
                && (j % gridSize >= pwr && j % gridSize < pwr + pwr))
                || sierp(i, j, n - 1, ignoredSize, board)) {
            // If the current position is within the middle square, sets the character to a space
            board[i][j] = ' ';
            return true;
        } else {
            return false;
        }
    }

    public static void carpet(int n, int size) {
        // Initializes the board with '*' characters
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '*';
            }
        }

        // Iterates through each position on the board and apply the Sierpinski carpet algorithm
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sierp(i, j, n, size, board);
            }
        }
    }

    public static void printBoard() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //asks the user to enter the size of the carpet
        System.out.print("Enter the size of the carpet: ");
        int size = sc.nextInt();

        // Calculates the number of iterations required using log3
        int iterations = (int) (Math.log(size) / Math.log(3));

        // Generates the Sierpinski carpet
        carpet(iterations, size);

        // Print the board
        printBoard();
    }


}
