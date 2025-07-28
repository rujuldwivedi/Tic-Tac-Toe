import { Input } from "./Input.js";
import { Game } from "./Game.js";

async function main()
{
  const input = new Input();
  const n = await input.askBoardSize();
  input.close();

  const game = new Game(n);
  await game.play();
}

main();