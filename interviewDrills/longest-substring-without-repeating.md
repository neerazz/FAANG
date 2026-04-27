---
layout: default
title: "Longest Substring Without Repeating Characters"
parent: "Interview Drills"
nav_order: 2
---

# Longest Substring Without Repeating Characters

**Pattern:** sliding window + last-seen index map  
**Target time:** 20 minutes coding, 5 minutes explanation, 5 minutes tests

## Problem

Given a string `s`, return the length of the longest substring that contains no repeated characters.

Example:

```text
s = "abcabcbb"
answer = 3  // "abc"
```

## What to say in the interview

Start with the invariant:

- The current window from `left` to `right` must contain no duplicate characters.
- A map from character to last-seen index tells us whether the new character repeats inside the current window.
- If it does, move `left` to one position after the previous occurrence.
- Never move `left` backward. That is the bug that breaks inputs like `"abba"`.

## Common trap

Do not remove characters one-by-one unless the interviewer asks for the set-based version. The last-seen index map gives a cleaner `O(n)` solution because each duplicate tells you exactly where the next valid window starts.

## Edge cases to test

- empty string returns `0`;
- every character repeats, like `"bbbbb"`;
- repeated character appears before the current window, like `"abba"`;
- answer is a substring, not a subsequence, like `"pwwkew"` → `"wke"`.

## Runnable solution

Code: [`LongestSubstringWithoutRepeating.java`]({% link interviewDrills/LongestSubstringWithoutRepeating.java %})

Run it locally:

```bash
javac interviewDrills/LongestSubstringWithoutRepeating.java
java -cp interviewDrills LongestSubstringWithoutRepeating
```

Expected output:

```text
All LongestSubstringWithoutRepeating drill checks passed.
```
