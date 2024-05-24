import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kérje meg a felhasználót, hogy adja meg a pálya méretét
        System.out.print("Adja meg a pálya méretét (N): ");
        int N = scanner.nextInt();

        // Kérje meg a felhasználót, hogy adja meg az akadályok arányát (százalékban)
        System.out.print("Adja meg az akadályok arányát (0-100): ");
        int p = scanner.nextInt();

        // Kérje meg a felhasználót, hogy adja meg a játékos karakterét
        System.out.print("Adja meg a játékos karakterét: ");
        char playerChar = scanner.next().charAt(0);

        // Létrehozunk egy pályát a megadott mérettel és akadály aránnyal
        Board board = new Board(N, p, playerChar);

        while (true) {
            board.printBoard();
            System.out.print("Adja meg a lépést (WASD): ");
            String input = scanner.next().toUpperCase();
            if (input.length() != 1) {
                System.out.println("Érvénytelen bemenet. Egyetlen WASD karaktert adjon meg.");
                continue;
            }
            char move = input.charAt(0);
            board.moveOpponent(move);
            board.moveRobots();
            if (board.isGameOver()) {
                board.printBoard();
                if (board.didRobotsWin()) {
                    System.out.println("Az játékos bekerítve. A robotok nyertek!");
                } else if (board.didOpponentWin()) {
                    System.out.println("Az játékos megszökött. Az játékos nyert!");
                }
                break;
            }
        }
        scanner.close();
    }
}
