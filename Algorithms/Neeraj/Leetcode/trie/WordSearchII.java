package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1056/
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
Example:
Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Note:
All inputs are consist of lowercase letters a-z.
The values of words are distinct.
 */
public class WordSearchII {
    static int[][] dir_ = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(findWords(
                new char[][]{{'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}) + " should be [eat,oath]");
        System.out.println(findWords(
                new char[][]{{'a', 'b'}, {'c', 'd'}},
                new String[]{"cdba"}) + " should be [cdba]");
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (dfs(board, i, j, word, 0)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

    static boolean dfs(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[i].length) return false;
        if (board[i][j] != word.charAt(pos)) return false;
        char c = board[i][j];
        board[i][j] = '.';
        for (int[] d : dir_) {
            if (dfs(board, i + d[0], j + d[1], word, pos + 1)) {
                board[i][j] = c;
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }

    public static List<String> findWords_Naive(char[][] board, String[] words) {
        List<String> output = new ArrayList<>();
        int row = board.length;
        int column = row > 0 ? board[0].length : 0;
        if (words.length == 0 || column == 0) return output;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (findWords(board, word, row, column)) output.add(word);
        }
        return output;
    }

    public static boolean findWords(char[][] board, String words, int row, int column) {
        boolean foundWord = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (words.charAt(0) == board[i][j]) {
                    foundWord = findWords(board, words, i, j, row, column, 0, new HashSet<Integer>());
                }
                if (foundWord) return foundWord;
            }
        }
        return false;
    }

    private static boolean findWords(char[][] board, String words, int i, int j, int row, int column, int index, HashSet<Integer> integers) {
        int hashValue = i * row + j;
        if (i < 0 || i >= row || j < 0 || j >= column || index >= words.length()) return index >= words.length();
        if (index == words.length() - 1 && words.charAt(index) == board[i][j]) return true;
        if (integers.contains(hashValue)) return false;
        integers.add(hashValue);
        if (words.charAt(index) == board[i][j]) {
            return findWords(board, words, i + 1, j, row, column, index + 1, integers) ||
                    findWords(board, words, i - 1, j, row, column, index + 1, integers) ||
                    findWords(board, words, i, j + 1, row, column, index + 1, integers) ||
                    findWords(board, words, i, j - 1, row, column, index + 1, integers);
        }
        return false;
    }
}
