import java.util.Random;

public class Bitwise {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.SIZE);
        System.out.println(Boolean.FALSE);
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Integer.parseInt("32"));
        System.out.println(Float.toString(3.213f));
        // Use these instead of ==
        System.out.println(Double.compare(3.14, 2.12));
        // Math Functions
        System.out.println(Math.min(12, 15));
        System.out.println(Math.max(12, 15));
        // 12.1 -> 13
        System.out.println(Math.ceil(12.1));
        // -21 -> 21
        System.out.println(Math.abs(-21));
        // 19.01 -> 20
        System.out.println(Math.ceil(19.01));
        // Sqrt
        System.out.println(Math.sqrt(21));
        // Power a ^ b
        System.out.println(Math.pow(10, 2));
        //Gives ASCII of 'A'
        System.out.println('A' - 0);
        //Random
        Random rand = new Random();
        System.out.println(rand.nextInt(1021));
    }
}