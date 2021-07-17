package concepts.primitives;

public class BitwiseOperators {
    public static void main(String[] args) {
        int x = 73;
        System.out.println("Integer to Binary: " + Integer.toBinaryString(x));
        System.out.println("Oth Index= " + ((x >>> 0) & 1));
        System.out.println("1st Index= " + ((x >>> 1) & 1));
        System.out.println("2nd Index= " + ((x >>> 2) & 1));
        System.out.println("3rd Index= " + ((x >>> 3) & 1));
        System.out.println("4th Index= " + ((x >>> 4) & 1));
        System.out.println("5th Index= " + ((x >>> 5) & 1));
        System.out.println("6th Index= " + ((x >>> 6) & 1));
        System.out.println("7th Index= " + ((x >>> 7) & 1));
        System.out.println("8th Index= " + ((x >>> 8) & 1));
        System.out.println("9th Index= " + ((x >>> 9) & 1));

        //x&(x-1)
        System.out.println("Value in Binary: " + Integer.toBinaryString(x));
        System.out.println("x & (x-1) on the Binary: " + Integer.toBinaryString(x & (x - 1)));

        System.out.println("6 & 4 is " + (6 & 4));
        System.out.println("1 | 2 is " + (1 | 2));
        System.out.println("8 >>> 1 is " + (8 >>> 1));
        System.out.println("16 >>> 2 is " + (16 >>> 2));

        System.out.println("-16 in Binary: " + Integer.toBinaryString(-16));
        System.out.println("16 in Binary: " + Integer.toBinaryString(16));

    }
}