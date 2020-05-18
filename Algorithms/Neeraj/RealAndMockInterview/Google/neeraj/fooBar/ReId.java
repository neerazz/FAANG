package neeraj.fooBar;
/*
    Created on:  May 12, 2020
 */

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Questions:
 * <p>
 * There's some unrest in the minion ranks:
 * minions with ID numbers like "1", "42", and other "good" numbers have been lording it over
 * the poor minions who are stuck with more boring IDs.
 * To quell the unrest, Commander Lambda has tasked you with reassigning everyone new, random IDs based on her Completely Foolproof Scheme.
 * <p>
 * She's concatenated the prime numbers in a single long string: "2357111317192329...".
 * Now every minion must draw a number from a hat.
 * That number is the starting index in that string of primes, and the minion's new ID number will be the next five digits in the string.
 * So if a minion draws "3", their ID number will be "71113".
 * <p>
 * Help the Commander assign these IDs by writing a function solution(n) which takes in the starting index n of Lambda's string of all primes,
 * and returns the next five digits in the string. Commander Lambda has a lot of minions, so the value of n will always be between 0 and 10000.
 * <p>
 * -- Java cases --
 * Input:
 * Solution.solution(0)
 * Output:
 * 23571
 * <p>
 * Input:
 * Solution.solution(3)
 * Output:
 * 71113
 */
public class ReId {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomInt = r.nextInt(10000);
            if(solution_correct(randomInt).equals(solution(randomInt))){
                System.out.println("Correct Output for Input = " + randomInt);
            }else{
                System.out.println("Wrong Output for Input = " + randomInt);
            }
        }
    }

//    https://surajshetiya.github.io/Google-foobar/
    private static String solution_correct(int i) {
        LocalDateTime startTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder("2");
        long start = 3, index = 1, digits = 1, nextDig = 10;
        while (index < i + 5) {
            if (isPrime(start)) {
                index += digits;
                sb.append(start);
            }
            start += 2;
            if (start / nextDig != 0) {
                nextDig *= 10;
                digits++;
            }
        }
        return sb.substring(i, i + 5);
    }

    private static boolean isPrime(long num) {
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        long start = 3;
        while (start * start <= num) {
            if (num % start == 0) return false;
            start += 2;
        }
        return true;
    }

    public static String getPrime(int len) {
        StringBuilder rs = new StringBuilder();
        int i = 0;
        while (rs.length() < len) {
            for (int j = 2; j <= i; j++) {
                if (i == j) {
                    rs.append(i);
                }
                if (i % j == 0 || rs.length() >= 10007) {
                    break;
                }
            }
            i++;
        }
        return rs.toString();
    }

    private static String solution(int i) {
        return getPrime(i + 6).substring(i, i + 5);
    }
}
