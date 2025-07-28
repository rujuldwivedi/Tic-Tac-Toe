// Game.js
import { Board } from "./Board.js";
import { Player } from "./Player.js";
import { Input } from "./Input.js";

export class Game
{
  constructor(n)
  {
    this.n = n;
    this.board = new Board(n);
    this.input = new Input();
    this.players = [new Player("Player 1", "X"), new Player("Player 2", "O")];
    this.currentPlayerIndex = 0;
    this.movesLeft = n * n;
  }

  get currentPlayer()
  {
    return this.players[this.currentPlayerIndex];
  }

  switchPlayer()
  {
    this.currentPlayerIndex = 1 - this.currentPlayerIndex;
  }

  async play()
  {
    console.log(`🎮 Starting Tic Tac Toe (${this.n} x ${this.n})`);
    this.board.display();

    while (true)
    {
      const { row, col } = await this.input.askMove
      (
        this.currentPlayer.name,
        this.currentPlayer.symbol,
        this.n
      );

      const success = this.board.placeMove(row, col, this.currentPlayer.symbol);
      if (!success)
      {
        console.log("⚠️ Cell already taken. Try again.");
        continue;
      }

      this.board.display();
      this.movesLeft--;

      if (this.checkWin(row, col, this.currentPlayer.symbol))
      {
        console.log(`🏆 ${this.currentPlayer.name} wins!`);
        break;
      }

      if (this.movesLeft === 0)
      {
        console.log("🟰 It's a draw!");
        break;
      }

      this.switchPlayer();
    }

    this.input.close();
  }

  checkWin(row, col, symbol)
  {
    const grid = this.board.grid;
    const n = this.n;

    // Check entire row
    let rowWin = true;
    for (let j = 0; j < n; j++)
    {
      if (grid[row][j] !== symbol)
      {
        rowWin = false;
        break;
      }
    }

    // Check entire column
    let colWin = true;
    for (let i = 0; i < n; i++)
    {
      if (grid[i][col] !== symbol)
      {
        colWin = false;
        break;
      }
    }

    // Check main diagonal
    let diagWin = true;
    if (row === col)
    {
      for (let i = 0; i < n; i++)
      {
        if (grid[i][i] !== symbol)
        {
          diagWin = false;
          break;
        }
      }
    } else
        {
      diagWin = false;
    }

    // Check anti-diagonal
    let antiDiagWin = true;
    if (row + col === n - 1)
        {
      for (let i = 0; i < n; i++)
        {
        if (grid[i][n - 1 - i] !== symbol)
            {
          antiDiagWin = false;
          break;
        }
      }
    } else
        {
      antiDiagWin = false;
    }

    return rowWin || colWin || diagWin || antiDiagWin;
  }
}
