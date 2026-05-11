import java.util.Scanner;

public class Nqueens {
    static int board[][];
    static int n;

    // This function checks if a queen can be placed at board[row][col]
    static boolean isSafe(int row, int col) {
        int i, j;

        // Check the column above
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check the upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check the upper-right diagonal
        for (i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Recursive function to solve the puzzle
    static boolean solve(int row) {
        // Base case: If all queens are placed, return true
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                
                board[row][col] = 1; // Place queen

                // Recur to place the rest
                if (solve(row + 1)) return true;

                // BACKTRACK: Remove queen if it doesn't lead to a solution
                board[row][col] = 0; 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        n = sc.nextInt();

        board = new int[n][n];

        if (solve(0)) {
            System.out.println("\nSolution Found:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }
        
        sc.close();
    }
}