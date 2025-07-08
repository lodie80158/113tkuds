package _0708;

public class StudentGradeSystem {
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        return 'D';
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];
        int[] gradeCount = new int[4]; // A, B, C, D
        int sum = 0, max = scores[0], min = scores[0];
        int maxIdx = 0, minIdx = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            grades[i] = getGrade(scores[i]);

            if (grades[i] == 'A') gradeCount[0]++;
            else if (grades[i] == 'B') gradeCount[1]++;
            else if (grades[i] == 'C') gradeCount[2]++;
            else gradeCount[3]++;

            if (scores[i] > max) {
                max = scores[i];
                maxIdx = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIdx = i;
            }
        }

        double avg = (double) sum / scores.length;
        int aboveAvg = 0;
        for (int score : scores) {
            if (score > avg) aboveAvg++;
        }

        System.out.println("=== 成績報告 ===");
        System.out.printf("總分: %d\n平均: %.2f\n", sum, avg);
        System.out.printf("最高分: %d (學生 %d)\n最低分: %d (學生 %d)\n", max, maxIdx, min, minIdx);
        System.out.printf("高於平均人數: %d (比例: %.2f%%)\n", aboveAvg, aboveAvg * 100.0 / scores.length);

        System.out.println("\n等級統計:");
        System.out.println("A: " + gradeCount[0]);
        System.out.println("B: " + gradeCount[1]);
        System.out.println("C: " + gradeCount[2]);
        System.out.println("D: " + gradeCount[3]);

        System.out.println("\n學生明細:");
        System.out.println("編號\t分數\t等級");
        System.out.println("----------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%c\n", i, scores[i], grades[i]);
        }
    }
}
