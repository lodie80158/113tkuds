package finalexam;

import java.util.Scanner;

public class F06_ArraySecondLargest {

    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }


    static Pair findSecondLargest(int[] arr, int left, int right) {
        if (left == right) {
    
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        int mid = (left + right) / 2;
        Pair leftPair = findSecondLargest(arr, left, mid);
        Pair rightPair = findSecondLargest(arr, mid + 1, right);


        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else if (leftPair.max < rightPair.max) {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        } else {

            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.second);
        }
        return new Pair(max, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondLargest(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：遞迴透過分治法拆分陣列，整體對 n 個元素做合併與比較，時間複雜度為線性 O(n)。
 */

