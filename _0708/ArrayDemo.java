package _0708;

public class ArrayDemo {
    public static void main(String[] args) {
        double[] numbers = {1.11,2.22,3.33,4.44,5.55};
        for(int i=0 ; i < numbers.length ; i++ ){
            System.out.println(numbers[i]);
            System.out.println("index: "+i);
            System.out.println("佔用位元組: "+Integer.BYTES+"bytes");
        }
    }
    
}
