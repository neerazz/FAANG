---
layout: default
title: "Top K Frequent Words"
parent: "Interview Drills"
nav_order: 1
---

# Top K Frequent Words

**Pattern:** hash map + bounded min-heap  
**Target time:** 25 minutes coding, 5 minutes explanation, 5 minutes tests

## Problem

Given an array of words and an integer `k`, return the `k` most frequent words.

Ordering rules:

1. Higher frequency first.
2. For equal frequency, lexicographically smaller word first.

Example:

```text
words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
answer = ["i", "love"]
```

## What to say in the interview

Start with the brute-force shape, then cut it down:

- Counting is mandatory, so use a `HashMap<String, Integer>`.
- Sorting every unique word costs `O(u log u)`.
- If the interviewer only needs top `k`, a bounded heap keeps the candidate set at size `k` and costs `O(u log k)`.

## Comparator trap

The heap should remove the **worst** candidate first:

- lower frequency is worse;
- when frequencies tie, lexicographically larger is worse because the final answer wants smaller first.

That means the min-heap comparator is not the same as the final output order.

## Edge cases to test

- `k = 0` returns an empty list.
- `k` larger than the number of unique words returns every unique word in answer order.
- multiple words with the same frequency are sorted lexicographically.

## Runnable solution

Code: [`TopKFrequentWords.java`]({% link interviewDrills/TopKFrequentWords.java %})

Run it locally:

```bash
javac interviewDrills/TopKFrequentWords.java
java -cp interviewDrills TopKFrequentWords
```

Expected output:

```text
All TopKFrequentWords drill checks passed.
```
