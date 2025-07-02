package _0702;

import java.util.*;
public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int key = sc.nextInt(), ops = 0;
        int low = 0, high = n - 1, mid, index = -1;
        while (low <= high) {
            ops++;
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(index);
        System.out.println(ops);
    }
}
