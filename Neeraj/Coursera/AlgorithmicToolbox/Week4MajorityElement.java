import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Task. The goal in this code problem is to check whether an input sequence contains a majority element.
Input Format. The first line contains an integer 𝑛, the next one contains a sequence of 𝑛 non-negative
integers 𝑎0, 𝑎1, . . . , 𝑎𝑛−1.
Constraints. 1 ≤ 𝑛 ≤ 105
; 0 ≤ 𝑎𝑖 ≤ 109
for all 0 ≤ 𝑖 < 𝑛.
Output Format. Output 1 if the sequence contains an element that appears strictly more than 𝑛/2 times,
and 0 otherwise.
Sample 1.
Input: (5 2 3 9 2 2)
5
2 3 9 2 2
Output:
1
2 is the majority element.
Sample 2.
Input: (4 1 2 3 4)
4
1 2 3 4
Output:
0
There is no majority element in this sequence.
Sample 3.
Input: (4 1 2 3 1)
4
1 2 3 1
Output:
0
This sequence also does not have a majority element (note that the element 1 appears twice and hence
is not a majority element).

What To Do:
As you might have already guessed, this problem can be solved by the divide-and-conquer algorithm in time
𝑂(𝑛 log 𝑛). Indeed, if a sequence of length 𝑛 contains a majority element, then the same element is also
a majority element for one of its halves. Thus, to solve this problem you first split a given sequence into
halves and make two recursive calls. Do you see how to combine the results of two recursive calls?
It is interesting to note that this problem can also be solved in 𝑂(𝑛) time by a more advanced (non-divide
and conquer) algorithm that just scans the given sequence twice.
 */
public class Week4MajorityElement {

    public static void main(String[] args) {
        int totalNumberOfVotes = FastScan.nextInt();
        int[] votes = new int[totalNumberOfVotes];
        for (int i = 0; i < totalNumberOfVotes; i++) {
            votes[i] = FastScan.nextInt();
        }
        System.out.println(findMajorityElement(totalNumberOfVotes, votes));
    }

    private static int findMajorityElement(int totalNumberOfVotes, int[] votes) {
        Map<Integer, Integer> votesCount = new HashMap<>();

        for (int i = 0; i < totalNumberOfVotes; i++) {
            int currentVote = votes[i];
            if (votesCount.containsKey(currentVote)) {
                votesCount.put(currentVote, votesCount.get(currentVote) + 1);
            } else {
                votesCount.put(currentVote, 1);
            }
        }
        return checkVotes(votesCount, totalNumberOfVotes);
    }

    private static int checkVotes(Map<Integer, Integer> votesCount, int totalNumberOfVotes) {
        int majorityVoteCount = totalNumberOfVotes / 2 + 1;
        int maximumVotes = votesCount.values().parallelStream().max(Comparator.comparing(Integer::valueOf)).get();
        if (maximumVotes >= majorityVoteCount) return 1;
        return 0;
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static double nextLong() {
            return Long.parseLong(next());
        }
    }
}
