import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeBoard {
    int n = 3;
    char board[][] = new char[n][n];

    public void startBoard() {
        Player p1 = new Player();
        Player p2 = new Player();
        Scanner in = new Scanner(System.in);

        System.out.println("Tic Tac Toe game is ready to play!");

        System.out.println("Digite o nome do jogador 1: ");
        p1.player = in.nextLine();

        System.out.println("Digite o nome do jogador 2: ");
        p2.player = in.nextLine();

        in.close();
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

    public void launchTTT() {
        boolean gameEnded = false, player1 = true;
        char c;
        int row, col;
        Scanner in = new Scanner(System.in);

        do {
            if (player1 == true) {
                c = 'x';
            } else {
                c = 'o';
            }

            //while(true) {
                System.out.print("Enter a row number: ");
                row = Integer.parseInt(in.nextLine());
                System.out.print("Enter a column number: ");
                col = Integer.parseInt(in.nextLine());
                in.close();
                if (row < 0 || col < 0 || row >= n || col >= n) {
                    System.out.println("This position is outside the boundaries of the board!x Try again.");
                    // check input range
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                    // check non empty cell
                } else {
                    break;
                }
            //} 
            
            drawnBoard(row, col, c);

            showBoard();
            player1 = !player1;
        }while(!gameEnded);
    }

    TicTacToeBoard() {

    }
}
