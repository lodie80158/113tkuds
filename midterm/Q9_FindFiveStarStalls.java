package midterm;
import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] scores = new int[n];
        String[] parts = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(parts[i]);
        }

        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                idxList.add(i);
            }
        }

        if (idxList.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < idxList.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(idxList.get(i));
            }
            System.out.println();
        }
    }
}

