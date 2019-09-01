package InterviewPreparation;

/*
Problem: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        System.out.println("Answer is: " + jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0}) + " should be 3.");
        System.out.println("Answer is: " + jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}) + " should be 4.");
        System.out.println("Answer is: " + jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}) + " should be 3.");
        System.out.println("Answer is: " + jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}) + " should be 3.");
    }

    static int jumpingOnClouds(int[] c) {
        int size = c.length;
        int pre = 0, curr, next, pointer = pre;
        int numberOfJumps = 0;
        while (pre + 1 < size) {
            curr = pre + 1;

            if (curr + 1 < size) {
                next = curr + 1;
            } else {
                numberOfJumps++;
                break;
            }

            if (c[next] == 0) {
                numberOfJumps++;
                pre = next;
            } else {
                numberOfJumps++;
                pre = curr;
            }
        }
        return numberOfJumps;
    }
}
