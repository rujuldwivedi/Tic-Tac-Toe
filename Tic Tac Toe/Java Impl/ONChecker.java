public class ONChecker implements WinChecker
{
    @Override
    public boolean checkWin(Board board, int row, int col, char symbol)
    {
        int n = board.getSize();

        boolean winRow = true;

        for(int j = 0; j < n; j++)
        {
            if(board.getCell(row, j) != symbol)
            {
                winRow = false;
                break;
            }
        }

        boolean winCol = true;

        for(int i = 0; i < n; i++)
        {
            if(board.getCell(i, col) != symbol)
            {
                winCol = false;
                break;
            }
        }

        boolean winDiag = true;

        if(row == col)
        {
            for(int i = 0; i < n; i++)
            {
                if(board.getCell(i, i) != symbol)
                {
                    winDiag = false;
                    break;
                }
            }
        }
        else
        winDiag = false;

        boolean winAntiDiag = true;

        if(row + col == n - 1)
        {
            for(int i = 0; i < n; i++)
            {
                if(board.getCell(i, n - 1 - i) != symbol)
                {
                    winAntiDiag = false;
                    break;
                }
            }
        }
        else
        winAntiDiag = false;

        return winRow || winCol || winDiag || winAntiDiag;
    }
}
