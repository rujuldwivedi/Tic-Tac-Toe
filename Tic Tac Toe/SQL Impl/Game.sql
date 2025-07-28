-- Drop old if any
DROP TABLE IF EXISTS Board;
DROP TABLE IF EXISTS Players;

CREATE TABLE Players
(
    player_id INT PRIMARY KEY,
    name VARCHAR(50),
    symbol CHAR(1) CHECK (symbol IN ('X', 'O'))
);

CREATE TABLE Board
(
    x INT,
    y INT,
    symbol CHAR(1) CHECK (symbol IN ('X', 'O')),
    PRIMARY KEY (x, y)
);

INSERT INTO Players (player_id, name, symbol) VALUES
(1, 'Rujul', 'X'),
(2, 'Dwivedi', 'O');

INSERT INTO Board (x, y, symbol) VALUES
(0, 0, 'X'),
(0, 1, 'X'),
(0, 2, 'X'),
(1, 1, 'O'),
(2, 0, 'O');

-- Check row win
SELECT symbol, x, COUNT(*) AS count
FROM Board
GROUP BY symbol, x
HAVING COUNT(*) = 3;

-- Check column win
SELECT symbol, y, COUNT(*) AS count
FROM Board
GROUP BY symbol, y
HAVING COUNT(*) = 3;

-- Check main diagonal win
SELECT symbol, COUNT(*) AS count
FROM Board
WHERE x = y
GROUP BY symbol
HAVING COUNT(*) = 3;

-- Check anti-diagonal win
SELECT symbol, COUNT(*) AS count
FROM Board
WHERE x + y = 2
GROUP BY symbol
HAVING COUNT(*) = 3;