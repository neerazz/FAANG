/*
Given a string s and an integer k, the task is to reduce the string by applying the following operation:
Choose a group of k consecutive identical characters and remove them.
The operation can be performed any number of times until it is no longer possible.
Example:
INPUT: k=2
       s="geeksforgeeks"
OUTPUT: gksforgks
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


class RestrictiveCandyCrush {

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int k = Integer.parseInt(sc.next());
        String s = sc.next();
        Solution T = new Solution();
        out.println(T.reduced_String(k, s));
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Solution {
        public static String reduced_String(int k, String s) {
            if (k == 1) {
                return "";
            }

            Stack<Node> stack = new Stack<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(new Node(ch, 1));
                } else {
                    Node prev = stack.peek();
                    if (prev.value == ch) {
                        stack.pop();
                        Node newNode = new Node(ch, prev.count + 1);
                        if (newNode.count < k) {
                            stack.push(newNode);
                        }
                    } else {
                        stack.push(new Node(ch, 1));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                char ch = cur.value;
                int count = cur.count;
                while (count-- > 0) {
                    sb.insert(0, ch);
                }
            }

            return sb.toString();

        }

        static class Node {
            char value;
            int count;

            public Node(char value, int count) {
                this.value = value;
                this.count = count;
            }
        }
    }
}

