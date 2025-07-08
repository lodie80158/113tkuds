package _0708;

public class ArrayStatistics {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0, max = arr[0], min = arr[0];
        int maxIdx = 0, minIdx = 0;
        int even = 0, odd = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
            if (arr[i] % 2 == 0) even++;
            else odd++;
        }

        double avg = (double) sum / arr.length;

        int countAboveAvg = 0;
        for (int num : arr) {
            if (num > avg) countAboveAvg++;
        }

        System.out.println("=== 陣列統計分析 ===");
        System.out.printf("總和: %d\n平均: %.2f\n", sum, avg);
        System.out.printf("最大值: %d (索引 %d)\n最小值: %d (索引 %d)\n", max, maxIdx, min, minIdx);
        System.out.println("大於平均值的數量: " + countAboveAvg);
        System.out.println("偶數數量: " + even + "\n奇數數量: " + odd);
    }
}
