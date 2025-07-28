public class ON2Checker implements WinChecker
{
    @Override
    public boolean checkWin(Board board, int row, int col, char symbol)
    {
        int n = board.getSize();

        boolean rowWin = true;

        for(int j = 0; j < n; j++)
        {
            if(board.getCell(row, j) != symbol)
            {
                rowWin = false;
                break;
            }
        }

        boolean colWin = true;

        for(int i = 0; i < n; i++)
        {
            if(board.getCell(i, col) != symbol)
            {
                colWin = false;
                break;
            }
        }

        boolean diagWin = true;

        if (row == col)
        {
            for(int i = 0; i < n; i++)
            {   
                if(board.getCell(i, i) != symbol)
                {
                    diagWin = false;
                    break;
                }
            }
        }
        else
        diagWin = false;

        boolean antiDiagWin = true;

        if(row + col == n - 1)
        {
            for(int i = 0; i < n; i++)
            {
                if(board.getCell(i, n - 1 - i) != symbol)
                {
                    antiDiagWin = false;
                    break;
                }
            }
        }
        else
        antiDiagWin = false;

        return rowWin || colWin || diagWin || antiDiagWin;
    }
}
