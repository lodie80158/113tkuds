package _0716;


import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("❌ 無效座標：(%d, %d)\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("⚠️ 位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        board[row][col] = player;
        return true;
    }

    static char checkWinner(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char player = board[row][col];
                if (player == EMPTY) continue;

                // 四個方向
                if (checkLine(board, row, col, 0, 1, player) ||  // →
                    checkLine(board, row, col, 1, 0, player) ||  // ↓
                    checkLine(board, row, col, 1, 1, player) ||  // ↘
                    checkLine(board, row, col, 1, -1, player)) { // ↙
                    return player;
                }
            }
        }
        return EMPTY;
    }

    static boolean checkLine(char[][] board, int r, int c, int dr, int dc, char player) {
        for (int i = 0; i < 5; i++) {
            int nr = r + dr * i;
            int nc = c + dc * i;
            if (nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE || board[nr][nc] != player) {
                return false;
            }
        }
        return true;
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = initializeBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 井字遊戲開始 ===");
        printBoard(board);

        while (true) {
            System.out.printf("玩家 %c，請輸入 row 和 col（例如 2 3）：", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);

                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("\n🤝 平手！");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }

        scanner.close();
    }
}
