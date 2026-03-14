/* 
// Features
1. Multiple Players
2. Custom Boards
3. Multiple Snakes and Ladders
4. Ranking System for Players
5. Sequential Player Turns
*/

// Design Patterns Used:
/*
1. Strategy Pattern : For Scoring Strategy
2. Factory Pattern : Can use for Initializing the strategies
3. Builder Pattern : Can use for Initializing the Game
 */




class Player {
    String playerId;
    String playerName;
    Cell position;
    int score;
}

class Cell {
    int row;
    int column;
}

abstract class Obstacles {
    Cell start;
    Cell end;
}

class Snake extends Obstacles {
    public Snake(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }
}

class Ladder extends Obstacles {
    public Snake(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }
}

class Board {
    List<Obstacles> obstacles;
    int rows;
    int columns;
    public Board(int rows, int columns, List<Obstacles> obstacles) {
        this.rows = rows;
        this.columns = columns;
        this.obstacles = obstacles;
    }
}

public interface ScoringStrategy {
    int calculateScore(Player player);
}

class SimpleScoringStrategy implements ScoringStrategy {
    @Override
    int calculateScore(Player player) {
        // Business logic to calculate the score
        return player.position.row * 10 + player.position.column;
    }
}

class ComplexScoringStrategy implements ScoringStrategy {
    @Override
    int calculateScore(Player player) {
        // Business logic to calculate the score
        return player.position.row * 10 + player.position.column + player.score;
    }
}

class Dice {
    int count;

    public int rollDice() {
        // business logic toroll the dice and return the result
        return (int) (Math.random() * count) + 1;
    }
}

class GameBuilder {
    Game game;
    public GameBuilder(String gameId, String gameName) {
        this.game = new Game(gameId, gameName);
    }
    public GameBuilder addPlayers(List<Player> players) {
        this.game.players = players;
        return this;
    }
    public GameBuilder addBoard(Board board) {
        this.game.board = board;
        return this;
    }
    public GameBuilder addScoringStrategy(ScoringStrategy scoringStrategy) {
        this.game.scoringStrategy = scoringStrategy;
        return this;
    }
    public GameBuilder addDiceCount(int diceCount) {
        this.game.dice = new Dice(diceCount);
        return this;
    }
    public Game build() {
        return this.game;
    }
}

class Game {
    String gameId;
    String gameName;
    List<Player> players;
    Board board;
    ScoringStrategy scoringStrategy;
    Queue<Player> playerQueue;
    Dice dice;
    

    public Game(String gameId, String gameName) {
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public void initializeGame() {
        // No Need for this as we are using Builder Pattern
    }

    public void startGame() {
        while(!playerQueue.isEmpty()) {
            Player currentPlayer = playerQueue.poll();
            // roll the dice
            int diceResult = dice.rollDice();
            // move the player to the new position
            currentPlayer.position = board.getCell(currentPlayer.position.row + diceResult, currentPlayer.position.column);
            // check if the player has landed on a snake or ladder
            if (board.getObstacles().contains(currentPlayer.position)) {
                currentPlayer.position = board.getCell(currentPlayer.position.row, currentPlayer.position.column);
            }
            // check if the player has won
            if (currentPlayer.position.row == 10 && currentPlayer.position.column == 10) {
                System.out.println(currentPlayer.playerName + " has won the game");
            } else {
                // add the player to the queue
                playerQueue.add(currentPlayer);
            }
        }
    }
}




public class Main {
    public static void main(String[] args) {
        GameBuilder gameBuilder = new GameBuilder("Game 1", "Game 1");
        gameBuilder.addPlayers(new ArrayList<>(Arrays.asList(
            new Player("Player 1", "John"),
            new Player("Player 2", "Jane"),
            new Player("Player 3", "Jim"),
            new Player("Player 4", "Jill")
        )));
        gameBuilder.addBoard(new Board(10, 10, new ArrayList<>(Arrays.asList(
            new Snake(new Cell(1, 1), new Cell(2, 2)),
            new Ladder(new Cell(3, 3), new Cell(4, 4))  
        ))));
        gameBuilder.addScoringStrategy(new SimpleScoringStrategy());
        gameBuilder.addDiceCount(1);
        Game game = gameBuilder.build();
        game.startGame();
    }
}