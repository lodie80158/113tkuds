package finalexam;

import java.util.Scanner;

public class F02_YouBikeNextFull {

    // 將 HH:mm 字串轉成分鐘數 (0~1439)
    static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    // 二分搜尋：找出陣列中第一個 > target 的索引
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length; // right 為陣列長度
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = timeToMinutes(sc.nextLine());
        }

        int query = timeToMinutes(sc.nextLine());

        int idx = upperBound(times, query);

        if (idx == n) {
            System.out.println("No bike");
        } else {
            int res = times[idx];
            System.out.printf("%02d:%02d\n", res / 60, res % 60);
        }
        sc.close();
    }
}

/*
計算複雜度分析：

1. 輸入 n 筆已排序的時間表，使用二分搜尋查找首個大於查詢時間的索引，時間複雜度為 O(log n)。
2. 二分搜尋依賴排序陣列，且查詢僅需一次完成。
3. 輸出對應時間或 No bike，為常數時間 O(1)。

空間複雜度：
- 儲存時間表陣列空間為 O(n)。
- 其他變數空間為常數。

總結：使用二分搜尋達成對時間表快速查詢，整體時間複雜度為 O(log n)，空間複雜度為 O(n)，效能優良且符合需求。
*/

