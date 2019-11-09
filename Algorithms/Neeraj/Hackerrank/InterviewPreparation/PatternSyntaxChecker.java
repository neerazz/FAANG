package InterviewPreparation;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
https://www.hackerrank.com/challenges/pattern-syntax-checker/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class PatternSyntaxChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String[] patterns = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            patterns[i] = in.next();
        }
        for (int i = 0; i < testCases; i++) {
            try {
                Pattern.compile(patterns[i]);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
    }
}
