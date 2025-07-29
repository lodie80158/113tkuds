package finalexam;

import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());  // 避免 InputMismatch
        String[] stops = sc.nextLine().split(" "); // 一行輸入站名
        String[] range = sc.nextLine().split(" ");
        String start = range[0], end = range[1];

        int i1 = -1, i2 = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) i1 = i;
            if (stops[i].equals(end)) i2 = i;
        }
        if (i1 == -1 || i2 == -1) System.out.println("Invalid");
        else System.out.println(Math.abs(i1 - i2) + 1);
    }

    /*
     * Time Complexity: O(n)
     * 說明：輸入站點後，以一次線性掃描陣列方式找出起訖站索引，
     *       接著直接用索引計算停靠站數。n 為輸入的站點數。
     */
}
