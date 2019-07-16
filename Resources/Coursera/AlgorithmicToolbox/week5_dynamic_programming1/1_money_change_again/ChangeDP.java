import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        return m / 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

