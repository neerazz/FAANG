/*
Given a sorted deck of cards numbered 1 to N.
1) We pick up 1 card and put it on the back of the deck.
2) Now, we pick up another card, it turns out to be card number 1, we put it outside the deck.
3) Now we pick up 2 cards and put it on the back of the deck.
4) Now, we pick up another card and it turns out to be card numbered 2, we put it outside the deck. ...
We perform this step until the last card.
If such an arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N then output -1.
Example:
INPUT: 4
OUTPUT: 2 1 4 3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class CardRotation {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input_line[] = read.readLine().trim().split("\\s+");
        int N = Integer.parseInt(input_line[0]);
        Solution obj = new Solution();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = obj.rotation(N);
        for (int i : ans)
            System.out.print(i + " ");
        System.out.println();
    }

    static class Solution {

        ArrayList<Integer> rotation(int n) {
            int[] res = new int[n];

            int j = 0;
            for (int i = 1; i <= n; i++) {
                int count = -1;
                while (true) {
                    if (res[j % n] == 0) count++;
                    if (count == i) {
                        res[j % n] = i;
                        break;
                    }
                    j++;
                }
            }

            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(res[i]);
            }

            return ans;
        }
    }
}

