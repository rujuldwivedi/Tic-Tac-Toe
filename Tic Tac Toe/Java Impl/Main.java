import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to n x n Tic Tac Toe!");

        System.out.print("Enter board size (n): ");
        int size = sc.nextInt();

        System.out.println("\nChoose win-checking algorithm:");
        System.out.println("1. O(n^2) - Brute Force Check");
        System.out.println("2. O(n)   - Count Rows/Cols/Diagonals");
        System.out.println("3. O(1)   - Real-Time Constant Time Checker");

        int algoChoice = 0;

        while (true)
        {
            System.out.print("Enter your choice (1-3): ");
            algoChoice = sc.nextInt();

            if (algoChoice >= 1 && algoChoice <= 3)
            break;
            
            System.out.println("Invalid choice. Please try again.");
        }

        Game game = new Game(size, algoChoice);
        game.start();
    }
}
