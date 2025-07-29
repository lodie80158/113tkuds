package finalexam;

import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), total = 0;
        for (int i = 0; i < n; i++) {
            int income = sc.nextInt(), tax = 0;
            int[][] brackets = {{540000, 5}, {1210000, 12}, {2420000, 20}, {4530000, 30}, {Integer.MAX_VALUE, 40}};
            int prev = 0;
            for (int[] b : brackets) {
                if (income > b[0]) {
                    tax += (b[0] - prev) * b[1] / 100;
                    prev = b[0];
                } else {
                    tax += (income - prev) * b[1] / 100;
                    break;
                }
            }
            total += tax;
            System.out.println("Tax: $" + tax);
        }
        System.out.println("Average: $" + (total / n));
    }
    /*
     * Time Complexity: O(n)
     * 說明：每個收入依稅級計算稅額，常數級距處理。
     */
}
