import java.util.Scanner;

public class Game
{
    private Player[] players;
    private Board board;
    private WinChecker checker;
    private int currentPlayer;

    public Game(int size, int algoChoice)
    {
        board = new Board(size);
        players = new Player[]{new Player("Player 1", 'X'), new Player("Player 2", 'O')};
        currentPlayer = 0;

        switch (algoChoice)
        {
            case 1 -> checker = new ON2Checker();
            case 2 -> checker = new ONChecker();
            case 3 -> checker = new O1Checker(size);
            default -> throw new IllegalArgumentException("Invalid algorithm choice");
        }
    }

    public void start()
    {
        Scanner sc = new Scanner(System.in);
        
        int totalMoves = 0;
        double totalExecTimeNs = 0;

        while (true)
        {
            board.display();
            Player player = players[currentPlayer];
            System.out.println(player.getName() + "'s turn (" + player.getSymbol() + ")");

            int row = -1, col = -1;

            while (true)
            {
                System.out.print("Enter row (0 to " + (board.getSize() - 1) + "): ");
                row = sc.nextInt();
                System.out.print("Enter column (0 to " + (board.getSize() - 1) + "): ");
                col = sc.nextInt();

                if(board.isCellValid(row, col) && board.isCellEmpty(row, col))
                break;

                System.out.println("Invalid move. Try again.");
            }

            long startMove = System.nanoTime();

            board.placeSymbol(row, col, player.getSymbol());
            boolean win = checker.checkWin(board, row, col, player.getSymbol());
            boolean draw = board.isFull();

            long endMove = System.nanoTime();
            totalExecTimeNs += (endMove - startMove);
            totalMoves++;

            if (win)
            {
                board.display();
                System.out.println(player.getName() + " wins!");
                break;
            }

            if (draw)
            {
                board.display();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = 1 - currentPlayer;
        }

        double avgTimePerMoveSec = (totalExecTimeNs / totalMoves) / 1e9;

        System.out.printf("Game finished in %.4f seconds (%.2f nanoseconds per move).%n", totalExecTimeNs / 1e9, avgTimePerMoveSec * 1e9);


    }
}
