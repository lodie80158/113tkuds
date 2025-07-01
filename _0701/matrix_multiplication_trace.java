package _0701;

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int sum = 0;
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    if (k < 1) System.out.print(" + ");
                }
                System.out.println(" = " + sum);
                c[i][j] = sum;
            }
        }

        System.out.println("結果矩陣：");
        for (int[] row : c) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
/*
 * 時間複雜度說明：
 * - 使用三層迴圈，對於 n x n 矩陣會執行 n³ 次運算。
 * - 時間複雜度為 O(n³)，屬於立方級時間。
 */