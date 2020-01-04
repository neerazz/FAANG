import java.util.Scanner;

//EPI Problem - Count the number of 1's in a integer
/*

Say en example of : 542
X in binary is - 1000011110
X in binary is - 100001111
X in binary is - 10000111
X in binary is - 1000011
X in binary is - 100001
X in binary is - 10000
X in binary is - 1000
X in binary is - 100
X in binary is - 10
X in binary is - 1
X in binary is - 0
No of 1s is 5

 */
public class CountBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        System.out.println("Input is " + input);
        System.out.println("Input in binary is - " + Integer.toBinaryString(input));
        System.out.println("No of 1s is " + countBits(input));
    }

    //Count the number of 1's in a digit
    public static int countBits(int x) {
        int numBits = 0;
        while (x != 0) {
            numBits = numBits + (x & 1);
            x = x >>> 1;
            System.out.println("X in binary is - " + Integer.toBinaryString(x));
        }
        return numBits;
    }

}