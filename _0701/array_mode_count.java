package _0701;

public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};

        int mode = arr[0];
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

/*
 * 時間複雜度說明：
 * - 使用巢狀迴圈，對每個元素都統計其出現次數。
 * - 外層 n 次，內層 n 次，共需 n² 次比較。
 * - 時間複雜度為 O(n²)。
 * - 改進方式：使用 HashMap 可降至 O(n)。
 */