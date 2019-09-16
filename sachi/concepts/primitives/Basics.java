import java.util.Random;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println("Double.SIZE=" + Double.SIZE);
        System.out.println("Boolean.FALSE=" + Boolean.FALSE);
        System.out.println("Boolean Value of \"true\" =" + Boolean.valueOf("true"));
        System.out.println("Integer.parseInt(\"32\")=" + Integer.parseInt("32"));
        System.out.println("Float.toString(3.213f)=" + Float.toString(3.213f));
        // Use these instead of ==
        System.out.println("Double.compare(3.14, 2.12)=" + Double.compare(3.14, 2.12));
        System.out.println("Double.compare(3.14, 3.14)=" + Double.compare(3.14, 3.14));
        // Math Functions
        System.out.println("Math.min(12, 15)=" + Math.min(12, 15));
        System.out.println("Math.max(12, 15)=" + Math.max(12, 15));
        // Ceil - Bottom - 12.1 -> 12
        System.out.println("Math.ceil(12.1)=" + Math.ceil(12.1));
        System.out.println("Math.ceil(0.9)=" + Math.ceil(0.9));
        System.out.println("Math.ceil(-1.2)=" + Math.ceil(-1.2));
        // Abs - Positive -21 -> 21
        System.out.println("Math.abs(-21)=" + Math.abs(-21));
        System.out.println("Math.abs(0)=" + Math.abs(0));
        System.out.println("Math.abs(1)=" + Math.abs(1));
        System.out.println("Math.abs(-0)=" + Math.abs(-0));
        // Floor - up 19.01 -> 19
        System.out.println("Math.floor(19.6)=" + Math.floor(19.6));
        System.out.println("Math.floor(0.9)=" + Math.floor(0.9));
        System.out.println("Math.floor(-1.2)=" + Math.floor(-1.2));
        // Sqrt
        System.out.println("Math.sqrt(21)=" + Math.sqrt(21));
        // Power a ^ b
        System.out.println("Math.pow(10, 2)=" + Math.pow(10, 2));
        // Gives ASCII of 'A'
        System.out.print("'A' - 0=");
        System.out.println('A' - 0);
        //Strig to INT
        System.out.println("String.valueOf(123)=" + String.valueOf(123));
        // Random
        Random rand = new Random();
        System.out.println("rand.nextInt()="+rand.nextInt());
        System.out.println("rand.nextInt(10)="+rand.nextInt(10));
        System.out.println("rand.nextDouble()="+rand.nextDouble());
        System.out.println("rand.nextBoolean()="+rand.nextBoolean());
    }
}