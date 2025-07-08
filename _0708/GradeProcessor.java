package _0708;
public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};
        int sum = 0, max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }

        double avg = (double) sum / scores.length;
        System.out.printf("總分: %d\n平均: %.2f\n", sum, avg);
        System.out.printf("最高分: %d (索引 %d)\n最低分: %d (索引 %d)\n", max, maxIndex, min, minIndex);

        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > avg) countAboveAvg++;
        }
        System.out.println("成績高於平均的人數: " + countAboveAvg);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生編號 " + i + ": " + scores[i]);
        }
    }
}
