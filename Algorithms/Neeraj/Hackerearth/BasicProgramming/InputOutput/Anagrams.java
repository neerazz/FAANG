package BasicProgramming.InputOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/description/
Given two strings, a and b , that may or may not be of the same length, determine the minimum number of character deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
Input :
test cases,t
two strings a and b, for each test case
Output:
Desired O/p
Constraints :
string lengths<=10000
Note :
Anagram of a word is formed by rearranging the letters of the word.
For e.g. -> For the word RAM - MAR,ARM,AMR,RMA etc. are few anagrams.
SAMPLE INPUT
1
cde
abc
SAMPLE OUTPUT
4
 */
public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbers; i++) {
            System.out.println(findAnagramCunt(scanner.nextLine(), scanner.nextLine()));
        }
//        System.out.println(findAnagramCunt("cde", "abc"));
    }

    private static int findAnagramCunt(String first, String second) {
        int output = 0;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < first.length(); i++) {
            characters.add(first.charAt(i));
        }

        for (int i = 0; i < second.length(); i++) {
            char current = second.charAt(i);
            if (!characters.contains(current)) {
                output++;
            } else {
                characters.remove((Character) current);
            }
        }
        return output + characters.size();
    }
}
