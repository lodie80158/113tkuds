package midterm;

import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] bills = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            int kwh = Integer.parseInt(sc.nextLine());
            int bill = calc(kwh);
            bills[i] = bill;
            total += bill;
        }

        for (int b : bills) {
            System.out.println("Bill: $" + b);
        }

        int avg = (int) Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    public static int calc(int kwh) {
        double fee = 0;
        int[] limits = {120, 210, 170, 200, 300};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int[] seg = new int[6];
        for (int i = 0; i < 5 && kwh > 0; i++) {
            seg[i] = Math.min(kwh, limits[i]);
            kwh -= seg[i];
        }
        seg[5] = kwh;
        for (int i = 0; i < 6; i++) {
            fee += seg[i] * rates[i];
        }
        return (int) Math.round(fee);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆用電量計算耗費 O(1)，共 n 筆資料，總體為 O(n)。
 */
