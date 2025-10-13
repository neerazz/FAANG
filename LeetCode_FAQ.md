# LeetCode FAQ

This document answers some frequently asked technical questions about the LeetCode platform, based on common user queries.

### Q: What are the environments for the programming languages?

**A:** LeetCode uses fairly recent versions of most popular languages. For Java, it's typically OpenJDK 11 or later. For C++, it's usually a recent version of GCC or Clang with C++17 or newer enabled. It's always a good practice to check the specific problem for any version notes, but you can generally rely on modern language features.

### Q: What is the difference between Time Limit Exceeded (TLE) and Timeout?

**A:**
*   **Time Limit Exceeded (TLE):** This is the most common error. It means your algorithm is too slow and did not complete within the time limit set for the problem (usually a few seconds). This indicates a need for a more efficient algorithm (e.g., moving from O(n^2) to O(n log n)).
*   **Timeout:** This is a less common, more general platform error that might not be related to your code's efficiency. It could be due to network issues or other platform-level problems. If you see this, it's worth resubmitting.

### Q: I encountered a "Wrong Answer" for a test case, but when I run my code with that same test case, it produces the correct output. Why?

**A:** This is a very common issue and is almost always caused by one of these things:
1.  **Static/Global Variables:** Variables that are declared outside of your main solution class or function retain their state across multiple test case runs within a single submission. You must re-initialize any global or static variables for each test case.
2.  **Modifying Input:** If you modify the input data structures in a way that is not reset, it can affect subsequent test cases.
3.  **Edge Cases:** You might be misinterpreting the test case. Double-check constraints and edge cases like empty arrays, zero values, or large numbers.

### Q: Am I allowed to print something to stdout (e.g., `System.out.println`)?

**A:** Yes. Printing to standard output is allowed and is a common way to debug your code. The output will appear in the "Stdout" panel of the test run result. It is ignored when your solution is judged for correctness.

### Q: How do I reset to the default code definition?

**A:** In the code editor, there is a "reset" icon (often a circular arrow). Clicking this will discard your current code and restore the original code stub for that problem.

### Q: Where do I find all of my submitted code?

**A:** You can find all of your past submissions by going to the "Submissions" tab on the problem page. This will show you a history of your accepted and rejected solutions for that specific problem.
