public class Board
{
    private final int size;
    private final char[][] grid;

    public Board(int size)
    {
        this.size = size;
        this.grid = new char[size][size];
        initialize();
    }

    private void initialize()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            grid[i][j] = ' ';
        }
    }

    public boolean placeSymbol(int row, int col, char symbol)
    {
        if(!isCellValid(row, col))
        return false;

        if(!isCellEmpty(row, col))
        return false;

        grid[row][col] = symbol;
        return true;
    }

    public boolean isCellValid(int row, int col)
    {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean isCellEmpty(int row, int col)
    {
        return grid[row][col] == ' ';
    }

    public boolean isFull()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(grid[i][j] == ' ')
                return false;
            }
        }
        return true;
    }

    public void display()
    {
        System.out.println();

        for(int i = 0; i < size; i++)
        {
            System.out.print(" ");

            for(int j = 0; j < size; j++)
            {
                System.out.print(grid[i][j]);

                if(j < size - 1)
                System.out.print(" | ");
            }

            System.out.println();

            if(i < size - 1)
            {
                System.out.print(" ");

                for(int j = 0; j < size; j++)
                {
                    System.out.print("---");

                    if(j < size - 1)
                    System.out.print("+");
                }
                System.out.println();
            }
        }

        System.out.println();   
    }


    public int getSize()
    {
        return size;
    }

    public char getCell(int row, int col)
    {
        return grid[row][col];
    }
}
