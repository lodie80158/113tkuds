package finalexam;

import java.util.Scanner;

public class F02_YouBikeNextFull {
    
    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }


    static int binarySearch(int[] times, int query) {
        int left = 0, right = times.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }


    static String toHHmm(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            times[i] = toMinutes(t);
        }
        String queryStr = sc.next();
        int query = toMinutes(queryStr);

        int idx = binarySearch(times, query);
        if (idx == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(toHHmm(times[idx]));
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋法在排序好的時間陣列中尋找第一個大於查詢時間的元素，時間複雜度為 O(log n)。
 */


