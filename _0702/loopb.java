package _0702;

public class loopb {
    public static void main(String[] args) {

        int x=0;
        int i=1;
        int count=0;
        while (++i <= 100)
        {
            x=x+1;
            count++;

    }
        System.out.println(count); // 99
    }
    
}
//++i 是 前置遞增，表示在判斷條件之前先把 i 加 1。

//所以 i 的變化會從 2 開始，依序到 100（共 99 次迴圈）。

