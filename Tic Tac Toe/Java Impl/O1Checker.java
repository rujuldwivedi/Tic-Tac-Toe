public class O1Checker implements WinChecker
{
    private int[] rowCount, colCount;
    private int diagCount, antiDiagCount;
    private int size;
    private char winSymbol;

    public O1Checker(int size)
    {
        this.size = size;
        rowCount = new int[size];
        colCount = new int[size];
        diagCount = 0;
        antiDiagCount = 0;
        winSymbol = '\0';
    }

    @Override
    public boolean checkWin(Board board, int row, int col, char symbol)
    {
        int val = (symbol == 'X') ? 1 : -1;
        rowCount[row] += val;
        colCount[col] += val;

        if(row == col)
        diagCount += val;

        if(row + col == size - 1)
        antiDiagCount += val;

        if(Math.abs(rowCount[row]) == size || Math.abs(colCount[col]) == size || Math.abs(diagCount) == size || Math.abs(antiDiagCount) == size)
        {
            winSymbol = symbol;
            return true;
        }

        return false;
    }

    public char getWinSymbol()
    {
        return winSymbol;
    }
}
