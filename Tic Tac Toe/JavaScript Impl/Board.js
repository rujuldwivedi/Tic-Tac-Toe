export class Board
{
  constructor(n)
  {
    this.n = n;
    this.grid = Array.from({ length: n }, () => Array(n).fill(null));
  }

  display()
  {
    console.log
    (
        this.grid.map((row) => row.map((cell) => cell || "_").join(" ")).join("\n")
    );
  }

  placeMove(x, y, symbol)
  {
    if (this.grid[x][y] === null)
    {
        this.grid[x][y] = symbol;
      return true;
    }
    return false;
  }

  getCell(x, y)
  {
    return this.grid[x][y];
  }
}
