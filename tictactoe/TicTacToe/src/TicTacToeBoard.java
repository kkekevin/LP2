import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeBoard {
    int n = 3;
    char board[][] = new char[n][n];
    Scanner in = new Scanner(System.in);
    Player p1 = new Player();
    Player p2 = new Player();

    public void startBoard() {
        System.out.println("Tic Tac Toe game is ready to play!");

        System.out.println("Digite o nome do jogador 1: ");
        p1.player = in.nextLine();

        System.out.println("Digite o nome do jogador 2: ");
        p2.player = in.nextLine();

        // in.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public void drawnBoard(int row, int col, char c) {
        board[row][col] = c;
    }

    public boolean winGame(char c) {
        boolean win = true;
        int j = 2;
        for(int i = 0; i < n; i++) { // check first diagonal
            if(board[i][i] != c) {
                win = false;
            }
        }
        if(win) { return win; }
        win = true; // turn another condition abble

        for(int i = 0; i < n; i++) { //check second diagonal
            if(board[i][i] != c) {
                win = false;
            }
        }
        if(win) { return win; }
        win = true;


        for(int i = 0; i < n; i++) { // check horizontal lines
            for(j = 0; j < n; j++) {
                if(board[i][j] != c){
                    win = false;
                }
            }
            if(win) { return win; }
            win = true;
        }
        win = true;

        for(int i = 0; i < n; i++) { // check vertical lines
            for(j = 0; j < n; j++) {
                if(board[j][i] != c)
                    win = false;                
            }
            if(win)
                return win;
        }

        return win;
    }

    public boolean filledBoard() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        System.out.println("tabuleiro cheio");
        return true;
    }

    public void launchTTT() {
        boolean gameEnded = false, player1 = true, gameEndedF = false;
        char c;
        int row, col;

        do {
            if (player1 == true) {
                c = 'x';
            } else {
                c = 'o';
            }
            // set x or o for each player

            while (true) {
                if (player1) {
                    System.out.println(p1.player + "'s turn");
                } else {
                    System.out.println(p2.player + "'s turn");
                }

                System.out.print("Enter a row number: ");
                row = in.nextInt();
                System.out.print("Enter a column number: ");
                col = in.nextInt();
                // in.close();
                if (row < 0 || col < 0 || row >= n || col >= n) {
                    System.out.println("This position is outside the boundaries of the board!x Try again.");
                    // check input range
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                    // check non empty cell
                } else {
                    break;
                }
            }

            drawnBoard(row, col, c);
            showBoard();
            gameEndedF = filledBoard();
            gameEnded = winGame(c);
            player1 = !player1; // player's turn
        } while (!gameEnded && !gameEndedF);
    }

    TicTacToeBoard() {

    }
}
