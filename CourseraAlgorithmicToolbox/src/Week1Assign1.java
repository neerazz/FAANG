import java.util.Scanner;

/*
In this very first programming challenge, your goal is to implement a program that reads two digits from the standard input and
prints their sum to the standard output.
 */
public class Week1Assign1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(a + b);
    }
}
