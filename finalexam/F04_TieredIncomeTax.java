package finalexam;

import java.util.Scanner;

public class F04_TieredIncomeTax {


    static final int[] brackets = {540000, 1210000, 2420000, 4530000};
    static final double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};


    static double calculateTax(int income) {
        double tax = 0.0;
        int remaining = income;
        int prevBracket = 0;

        for (int i = 0; i < brackets.length; i++) {
            int bracketAmount = brackets[i] - prevBracket;
            if (remaining <= 0) break;
            int taxable = Math.min(remaining, bracketAmount);
            tax += taxable * rates[i];
            remaining -= taxable;
            prevBracket = brackets[i];
        }
   
        if (remaining > 0) {
            tax += remaining * rates[rates.length - 1];
        }
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        double totalTax = 0.0;
        int[] incomes = new int[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < n; i++) {
            double tax = calculateTax(incomes[i]);
            totalTax += tax;
            System.out.printf("Tax: $%.0f\n", tax);
        }

        double avg = n > 0 ? totalTax / n : 0.0;
        System.out.printf("Average: $%.0f\n", avg);

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 說明：
 * 對 n 筆收入逐筆計算稅額，每筆稅額計算為固定段階走訪，時間複雜度為 O(1)。
 * 整體時間複雜度為 O(n)，空間複雜度為常數 O(1)。
 * 此演算法線性處理輸入並輸出結果，效率穩定且符合需求。
 */


