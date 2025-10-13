# Stacks

A stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle. This means the last element added to the stack will be the first one to be removed.

## Operations

*   **push:** Adds an element to the top of the stack.
*   **pop:** Removes the element from the top of the stack.
*   **peek / top:** Returns the top element of the stack without removing it.
*   **isEmpty:** Checks if the stack is empty.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Push** | O(1) | O(1) |
| **Pop** | O(1) | O(1) |
| **Peek** | O(1) | O(1) |
| **Search** | O(n) | O(1) |

## Problem Identification

Stacks are useful for problems that involve:
*   Reversing a sequence.
*   Matching parentheses or delimiters.
*   Backtracking algorithms (e.g., DFS).
*   Processing nested structures.
*   Problems where you need to keep track of a "most recent" state.

## Common Patterns and Templates

### Template 1: Basic Stack for Reversal/Matching

This template is used for simple LIFO operations, like checking for balanced parentheses.

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
```

**Example Problem:** [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
*(Solution file `ValidParentheses.java` is in this directory)*

### Template 2: Monotonic Stack

A monotonic stack (either increasing or decreasing) is used to find the next/previous greater/smaller element in an array.

```java
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
```

**Example Problem:** [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
*(Solution file `DailyTemperatures.java` is in this directory)*
