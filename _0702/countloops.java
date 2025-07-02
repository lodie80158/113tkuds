package _0702;

public class countloops {
    public static void main(String[] args) {
        int n=5;
        int sum=0;
        int cnt=0;
        
        for (int i = 0; i < n; i++) {
            System.out.println("第 "+i+" 次迴圈， sum = "+sum+"+"+i);
            sum+=i;
            cnt++;//每個加法都記錄
        }
        System.out.println("總和為"+sum);
        System.out.println("加法執行了"+cnt+ "次");

    }
}
