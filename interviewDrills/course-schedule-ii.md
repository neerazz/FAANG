---
layout: default
title: "Course Schedule II"
parent: "Interview Drills"
nav_order: 5
---

# Course Schedule II

**Pattern:** topological sort with Kahn's algorithm (BFS over indegrees)
**Target time:** 25 minutes coding, 5 minutes explanation, 5 minutes tests

## Problem

You are given `numCourses` courses labeled `0` through `numCourses - 1` and
a list of `prerequisites` where each `[a, b]` means "to take course `a`
you must first take course `b`". Return any ordering in which all courses
can be taken. If no such ordering exists (the prerequisite graph has a
cycle), return an empty array. (LeetCode 210.)

## What to say in the interview

Lead with the *shape* of the problem. The interviewer is checking
whether you spot the DAG.

- The prerequisites form a directed graph: edge `b -> a` means "`b`
  must be taken before `a`". The question is "produce a topological
  order, or detect that none exists."
- Two standard approaches: **Kahn's algorithm** (BFS over indegree-zero
  nodes) and **DFS with a three-color visited array**. Both are O(V + E).
  Pick Kahn's for an interview — cycle detection collapses to "did I
  emit fewer than `numCourses` nodes?", which is one line and hard to
  get wrong. The DFS variant needs `unvisited / on-stack / done` state
  to detect back-edges, which is more code under time pressure.

The Kahn's recipe:

1. Build the adjacency list and an `indegree[]` array in one pass over
   the prerequisites.
2. Seed a queue with every course whose `indegree` is `0` — those have
   no blockers.
3. Pop a course, append it to the order, and for each outgoing edge
   `course -> next`, decrement `indegree[next]`. If it hits `0`, that
   course just became unblocked — enqueue it.
4. If the produced order has fewer than `numCourses` entries, the
   remaining nodes are stuck in a cycle. Return an empty array.

## Common traps

- **Reversing the edge direction.** Each prerequisite `[a, b]` means
  "`b` is required for `a`", so the edge is `b -> a`, not `a -> b`. Get
  this wrong and your topological order is the reverse of what the
  grader expects, *or* you produce a "valid" order through what is
  actually a cycle.
- **Treating duplicate prerequisites as a no-op.** `[[1,0],[1,0]]`
  legitimately increments `indegree[1]` twice. You must decrement it
  twice as you process course `0`, otherwise `1` never unblocks. The
  fix is to *not* deduplicate edges — let the indegree count match the
  number of edges in the adjacency list.
- **Detecting cycles with a visited set instead of a count.** A visited
  set cannot tell "I haven't reached this node yet" from "this node is
  inside a cycle". The clean signal is `taken < numCourses` after the
  queue drains.
- **Forgetting that disconnected components exist.** Courses with no
  prerequisites and no dependents still need to appear in the output.
  Seeding the queue with *every* indegree-zero node — not just node `0`
  — handles this for free.
- **Using recursion for the DFS variant on a deep graph.** With
  `numCourses` up to `2000` on LeetCode, an iterative BFS is safer
  than a recursive DFS that can overflow the JVM stack on a long
  prerequisite chain.

## Edge cases to test

- no prerequisites at all — every course is immediately ready;
- a single linear chain `0 -> 1 -> 2 -> 3` — the order is forced;
- a diamond `0 -> {1, 2} -> 3` — multiple valid orders, all must respect
  the partial order;
- a cycle (including a single self-loop `[[0, 0]]`) — return `[]`;
- duplicate prerequisites `[[1,0],[1,0],[1,0]]` — the algorithm must
  still terminate and produce a valid order;
- two disconnected chains — every node must appear in the output.

## Runnable solution

Code: [`CourseScheduleII.java`]({% link interviewDrills/CourseScheduleII.java %})

Run it locally:

```bash
javac interviewDrills/CourseScheduleII.java
java -cp interviewDrills CourseScheduleII
```

Expected output:

```text
All CourseScheduleII drill checks passed.
```
