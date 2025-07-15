package midterm;

import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[7];
        for (int i = 0; i < 7; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0, right = 6;
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(a[i]);
            if (i < 6) System.out.print(" ");
        }
        System.out.println();
    }
}
