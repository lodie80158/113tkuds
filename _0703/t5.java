package _0703;


    import java.util.Scanner;

    public class t5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            int celsius = sc.nextInt();
            
            int fahrenheit = (celsius * 9 / 5) + 32;
        
            System.out.print(fahrenheit);
        }
    }
    
