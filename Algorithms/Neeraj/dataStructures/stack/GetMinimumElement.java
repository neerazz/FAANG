/*
Given N elements and the task is to Implement a Stack in which you can get minimum element in O(1) time.
First line of input denotes Q.
A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line contains Q queries seperated by space.
Example:
INPUT: 6
       1 2 1 3 2 3 1 1 3 
OUTPUT: 3 2 1
*/


import java.util.Scanner;
import java.util.Stack;

class GetMinimumElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution sol = new Solution();
        while (q > 0) {
            int qt = sc.nextInt();
            if (qt == 1) {
                int att = sc.nextInt();
                sol.push(att);
            } else if (qt == 2) {
                System.out.print(sol.pop() + " ");
            } else if (qt == 3) {
                System.out.print(sol.getMin() + " ");
            }
            q--;
        }
        System.out.println();
    }

    static class Solution {
        int minEle;
        Stack<Integer> s = new Stack<>();

        int getMin() {
            if (s.isEmpty()) return -1;
            return minEle;
        }

        int pop() {
            if (!s.isEmpty()) {
                int temp = s.pop();
                if (temp >= minEle) {
                    return temp;
                } else {
                    int tem = minEle;
                    minEle = minEle - temp;
                    return tem;
                }
            }
            return -1;
        }

        void push(int x) {
            if (s.isEmpty()) {
                s.push(x);
                minEle = x;
            } else {
                if (x >= minEle) {
                    s.push(x);
                } else {
                    int temp = x - minEle;
                    s.push(temp);
                    minEle = x;
                }
            }
        }
    }
}



