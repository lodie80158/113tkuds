package finalexam;

import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int startIndex = -1, endIndex = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIndex = i;
            }
            if (stops[i].equals(end)) {
                endIndex = i;
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(endIndex - startIndex) + 1;
            System.out.println(count);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：程式對輸入的停靠站序列只做一次線性掃描，尋找起訖站索引，故時間複雜度為線性 O(n)。
 */

