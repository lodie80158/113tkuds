package _0703;
import java.util.Scanner;

public class t13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[][][] cube = new int[N][N][N];
        int minVal = Integer.MAX_VALUE;

        // 先計算原始值，找最小值
        for (int z = 0; z < N; z++) {
            int A, B, C, D;
            // 每層使用不同參數
            if (z == 0) {
                A = 8; B = 4; C = 2; D = 3;
            } else if (z == 1) {
                A = 6; B = 3; C = 1; D = 14;
            } else {
                A = 7; B = 5; C = 3; D = 17;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    cube[z][y][x] = A * z + B * y + C * x + D;
                    if (cube[z][y][x] < minVal)
                        minVal = cube[z][y][x];
                }
            }
        }

        // 將所有數字減去最小值後+5，調整起點為5
        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    cube[z][y][x] = cube[z][y][x] - minVal + 5;
                }
            }
        }

        // 輸出格式
        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    System.out.print(cube[z][y][x]);
                    if (x != N - 1) System.out.print(" ");
                }
                System.out.println();
            }
            if (z != N - 1) System.out.println();
        }
    }
}
