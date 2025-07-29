package finalexam;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) count[c - 'a']++;
        }
        int odd = 0;
        for (int c : count) if (c % 2 == 1) odd++;
        System.out.println(odd <= 1 ? "Possible" : "Impossible");
    }
    /*
     * Time Complexity: O(n)
     * 說明：一次遍檢查字符類型和繪固。
     */
}
