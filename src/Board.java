import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int N;
    private boolean[][] obstacles;
    private Cell opponent;
    private List<Cell> robots;
    private char playerChar;

    public Board(int N, int p, char playerChar) {
        this.N = N;
        this.obstacles = new boolean[N][N];
        this.robots = new ArrayList<>(); // Inicializáljuk a robots listát
        this.playerChar = playerChar;
        generateObstacles(p);
        placeOpponentAndRobots();
    }

    private void generateObstacles(int p) {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rand.nextInt(100) < p) {
                    obstacles[i][j] = true;
                } else {
                    obstacles[i][j] = false;
                }
            }
        }
    }

    private void placeOpponentAndRobots() {
        // Az ellenfél (játékos) a pálya közepére kerül
        opponent = new Cell(N / 2, N / 2);

        // Robotok a pálya négy sarkára kerülnek
        robots.add(new Cell(0, 0));
        robots.add(new Cell(0, N - 1));
        robots.add(new Cell(N - 1, 0));
        robots.add(new Cell(N - 1, N - 1));
    }

    public void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (obstacles[i][j]) {
                    System.out.print("X ");
                } else if (opponent.x == i && opponent.y == j) {
                    System.out.print(playerChar + " ");
                } else if (isRobotAt(i, j)) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private boolean isRobotAt(int x, int y) {
        for (Cell robot : robots) {
            if (robot.x == x && robot.y == y) {
                return true;
            }
        }
        return false;
    }

    public void moveOpponent(char direction) {
        int newX = opponent.x, newY = opponent.y;
        switch (direction) {
            case 'W': newX = opponent.x - 1; break;
            case 'S': newX = opponent.x + 1; break;
            case 'A': newY = opponent.y - 1; break;
            case 'D': newY = opponent.y + 1; break;
            default: System.out.println("Érvénytelen lépés. Használja a WASD billentyűket."); return;
        }
        if (isValidMove(newX, newY)) {
            opponent.x = newX;
            opponent.y = newY;
        } else {
            System.out.println("Érvénytelen lépés. Próbálja újra.");
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !obstacles[x][y] && !isRobotAt(x, y);
    }

    public void moveRobots() {
        for (Cell robot : robots) {
            int bestX = robot.x, bestY = robot.y;
            if (robot.x < opponent.x && isValidMove(robot.x + 1, robot.y)) bestX = robot.x + 1;
            else if (robot.x > opponent.x && isValidMove(robot.x - 1, robot.y)) bestX = robot.x - 1;
            else if (robot.y < opponent.y && isValidMove(robot.x, robot.y + 1)) bestY = robot.y + 1;
            else if (robot.y > opponent.y && isValidMove(robot.x, robot.y - 1)) bestY = robot.y - 1;
            robot.x = bestX;
            robot.y = bestY;
        }
    }

    public boolean isGameOver() {
        return isSurrounded(opponent.x, opponent.y) || isOpponentEscaped();
    }

    private boolean isSurrounded(int x, int y) {
        return (isBlocked(x - 1, y) && isBlocked(x + 1, y) &&
                isBlocked(x, y - 1) && isBlocked(x, y + 1));
    }

    private boolean isBlocked(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N || obstacles[x][y] || isRobotAt(x, y);
    }

    private boolean isOpponentEscaped() {
        return opponent.x == 0 || opponent.x == N - 1 || opponent.y == 0 || opponent.y == N - 1;
    }

    public boolean didRobotsWin() {
        return isSurrounded(opponent.x, opponent.y);
    }

    public boolean didOpponentWin() {
        return isOpponentEscaped();
    }
}
