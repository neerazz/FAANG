---
layout: default
title: "Daily Temperatures"
parent: "Interview Drills"
nav_order: 3
---

# Daily Temperatures

**Pattern:** monotonic decreasing stack of indices (next greater element)  
**Target time:** 20 minutes coding, 5 minutes explanation, 5 minutes tests

## Problem

Given an integer array `temperatures` where `temperatures[i]` is the
temperature on day `i`, return an array `answer` such that `answer[i]` is
the number of days you must wait after day `i` to get a warmer
temperature. If no future day is warmer, `answer[i] = 0`.

Example:

```text
temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
answer       = [ 1,  1,  4,  2,  1,  1,  0,  0]
```

## What to say in the interview

Lead with the trade-off, not the code:

- Brute force is two nested loops, O(n^2). For each day, scan forward for
  the first warmer day. This will get you to a working answer but it tells
  the interviewer you missed the pattern.
- The pattern is **next greater element**: every position is waiting for
  the first strictly greater value to its right. That is a textbook
  monotonic-stack problem and runs in O(n).
- Push **indices**, not temperatures. The answer is a *distance*
  (`currentIndex - waitingIndex`), so you need the position, not the
  value. Look up the temperature through `temperatures[stack.peek()]`.

The invariant: the stack always holds indices whose warmer day has not
been found yet, with their temperatures strictly decreasing from bottom
to top. When today's temperature is strictly greater than the
temperature at the top, today is *the* warmer day for that index and the
answer is fixed forever.

## Common trap

- Storing temperatures on the stack instead of indices. You then cannot
  compute the gap and end up smuggling parallel arrays around.
- Using `>=` instead of `>`. Equal temperatures must stay on the stack:
  the question asks for *strictly* warmer, so a tie does not resolve
  anything.
- Reaching for a heap. A heap is `O(n log n)` and overkill — the
  monotonic-stack property gives you each index pushed and popped at
  most once, so the total work is `O(n)`.

## Edge cases to test

- empty input returns an empty array;
- single day, like `[99]`, returns `[0]`;
- strictly increasing input, like `[30, 40, 50, 60]`, returns
  `[1, 1, 1, 0]`;
- strictly decreasing input, like `[60, 50, 40, 30]`, returns all zeros;
- repeated values, like `[50, 50, 50, 50]`, returns all zeros because
  ties do not count.

## Runnable solution

Code: [`DailyTemperatures.java`]({% link interviewDrills/DailyTemperatures.java %})

Run it locally:

```bash
javac interviewDrills/DailyTemperatures.java
java -cp interviewDrills DailyTemperatures
```

Expected output:

```text
All DailyTemperatures drill checks passed.
```
