---
layout: default
title: "Interview Drills"
has_children: true
nav_order: 5
---

# Interview Drills

Short, runnable drills for candidates who want more than a problem list. Each drill includes the interviewer signal, the pattern to recognize, the pitfalls that cause misses, and a Java solution you can compile locally.

## Drill format

1. **Recognize the pattern** before coding.
2. **Say the trade-off** out loud: time, space, and why this structure fits.
3. **Code the happy path** first, then edge cases.
4. **Run the built-in examples** before moving on.

## Drills

| Drill | Pattern | Why it matters |
| --- | --- | --- |
| [Top K Frequent Words]({% link interviewDrills/top-k-frequent-words.md %}) | Hash map + bounded heap | Common screening shape for search, ranking, logs, and product analytics questions. |
| [Daily Temperatures]({% link interviewDrills/daily-temperatures.md %}) | Monotonic decreasing stack of indices | Standard "next greater element" framing — separates candidates who reach for `O(n^2)` from those who recognize the stack pattern. |
| [LRU Cache]({% link interviewDrills/lru-cache.md %}) | Hash map + doubly linked list with sentinels | The canonical "design a data structure" warmup — checks whether you compose two primitives for O(1) ops instead of grabbing a `LinkedHashMap` one-liner. |
| [Course Schedule II]({% link interviewDrills/course-schedule-ii.md %}) | Topological sort via Kahn's BFS over indegrees | Tests whether you spot the DAG and reach for an O(V + E) topological order with cycle detection that collapses to a single length check. |

## Practice rule

Do one drill at interview pace: 25 minutes to solve, 5 minutes to explain, 5 minutes to test. If you miss the edge case, repeat the same drill the next day instead of adding a new one.
