package concepts.primitives;

import java.util.Random;

public class Basics {
    public static void main(String[] args) {

        System.out.println("Byte.MIN_VALUE" + Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE" + Byte.MAX_VALUE);

        System.out.println("Short.MIN_VALUE" + Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE" + Short.MAX_VALUE);

        System.out.println("Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE=" + Integer.MAX_VALUE);

        System.out.println("Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE=" + Long.MAX_VALUE);

        System.out.println("Character.MIN_VALUE=" + Character.MIN_VALUE);
        System.out.println("Character.MAX_VALUE=" + Character.MAX_VALUE);

        System.out.println("Boolean.FALSE=" + Boolean.FALSE);
        System.out.println("Boolean.TRUE=" + Boolean.TRUE);

        System.out.println("Float.SIZE=" + Float.SIZE);
        System.out.println("Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("Float.MAX_VALUE=" + Float.MAX_VALUE);

        System.out.println("Double.SIZE=" + Double.SIZE);
        System.out.println("Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE=" + Double.MAX_VALUE);

        System.out.println("Boolean Value of \"true\" =" + Boolean.valueOf("true"));
        System.out.println("Integer.parseInt(\"32\")=" + Integer.parseInt("32"));
        System.out.println("Float.toString(3.213f)=" + 3.213f);

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

        //String to INT
        System.out.println("String.valueOf(123)=" + 123);

        // Random
        Random rand = new Random();
        System.out.println("rand.nextInt()=" + rand.nextInt());
        System.out.println("rand.nextInt(10)=" + rand.nextInt(10));
        System.out.println("rand.nextDouble()=" + rand.nextDouble());
        System.out.println("rand.nextBoolean()=" + rand.nextBoolean());

        char[] C = new char[]{'a' ,'b'};
        int[] a = new int[] {12,15};
    }
}