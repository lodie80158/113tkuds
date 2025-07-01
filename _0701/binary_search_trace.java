package _0701;

import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        int left = 0, right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("結果：" + (found ? "已找到！" : "找不到！"));
    }
}

/*
 * 時間複雜度說明：
 * - 每次搜尋都將搜尋區間減半。
 * - 最多執行 log₂(n) 次迴圈。
 * - 時間複雜度為 O(log n)，比線性搜尋 O(n) 快得多。
 */