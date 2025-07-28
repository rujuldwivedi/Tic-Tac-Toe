import readline from "readline";

export class Input
{
  constructor()
  {
    this.rl = readline.createInterface
    (
        {
        input: process.stdin,
        output: process.stdout,
        }
    );
  }

  ask(question)
  {
    return new Promise
    (   (resolve) =>
        {
        this.rl.question
        (question, (answer) =>
            {
            resolve(answer);
            }
        );
        }
    );
  }

  async askBoardSize()
  {
    while (true)
    {
      const input = await this.ask("Enter board size (n ≥ 3): ");
      const n = parseInt(input);
      if (Number.isInteger(n) && n >= 3)
        return n;
      console.log("❌ Invalid size. Please enter an integer ≥ 3.");
    }
  }

  async askMove(playerName, symbol, n)
  {
    while (true)
        {
      const input = await this.ask
      (
        `${playerName} (${symbol}), enter your move (row col): `
      );
      const [row, col] = input.trim().split(" ").map(Number);
      if
      (
        Number.isInteger(row) &&
        Number.isInteger(col) &&
        row >= 0 &&
        row < n &&
        col >= 0 &&
        col < n
      )
      {
        return { row, col };
      }
      console.log("❌ Invalid input. Enter two integers between 0 and", n - 1);
    }
  }

  close()
  {
    this.rl.close();
  }
}
