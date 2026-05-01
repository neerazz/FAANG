---
layout: default
title: "LRU Cache"
parent: "Interview Drills"
nav_order: 4
---

# LRU Cache

**Pattern:** hash map for O(1) lookup + doubly linked list for O(1) recency updates
**Target time:** 25 minutes coding, 5 minutes explanation, 5 minutes tests

## Problem

Design a data structure that supports two operations in O(1) average time:

- `get(key)` returns the value if the key is present, otherwise `-1`.
- `put(key, value)` inserts or updates the entry. When inserting causes the
  cache to exceed its fixed `capacity`, evict the least recently used entry.

Both `get` and `put` count as a "use" — they refresh the entry's recency.

## What to say in the interview

Lead with the structure, not the code. The interviewer is mostly checking
whether you reach for the right composite data structure.

- Why not a `TreeMap` keyed by last-access time? Updating a key on every
  access is `O(log n)`. The bar here is `O(1)`.
- Why not a single `LinkedHashMap` with `accessOrder=true`? It works, but
  most interviewers want to see that you can build the structure from
  primitives. Mention the one-liner so the interviewer knows you know it,
  then build it manually.
- The right answer is a **HashMap from key to list node** plus a
  **doubly linked list** ordered most-recently-used to least-recently-used.
  The map gives O(1) lookup. The list gives O(1) "move to front" and O(1)
  "drop the tail" because each node already knows its neighbors.

The invariant: the head of the list is the most recently used entry, the
tail is the least recently used. Every `get` and `put` either inserts a
node right after the head sentinel or unlinks it from its current spot
and reinserts it there. Every overflow drops the node right before the
tail sentinel and removes its key from the map.

Use **sentinel head and tail nodes**. They look like extra code, but they
remove every null check around list edits — `head.next` and `tail.prev`
are always valid. Without sentinels, half your bugs come from special
cases at list boundaries.

## Common traps

- **Forgetting to remove the evicted key from the map.** The list shrinks
  but the map keeps growing — the cache silently exceeds capacity and
  every "miss" still hits a stale node. Always do both: unlink from the
  list *and* remove from the map.
- **Updating a value but not refreshing recency.** A `put` on an existing
  key is also a "use". If you skip `moveToFront`, the entry can be
  evicted right after a fresh write — which violates LRU semantics and
  is the exact failure most graders test for.
- **Storing only the value in the map.** You then cannot find the list
  node from the key, so `get` becomes `O(n)` to locate it. Map keys must
  point at nodes, not values.
- **Single-node list edge case.** Moving the only real node to the front
  must still leave the list in a valid state. Sentinels make this work
  for free; without them, you have to special-case it.

## Edge cases to test

- standard LeetCode 146 trace: `put(1,1), put(2,2), get(1)=1, put(3,3)
  evicts 2, put(4,4) evicts 1, get(3)=3, get(4)=4`;
- `put` on an existing key updates the value *and* refreshes recency, so
  the other key becomes the LRU;
- repeated `get` on the same key does not change which entry is the LRU;
- `capacity = 1` evicts on every new key;
- non-positive capacity should be rejected at construction time — most
  graders do not test this, but interviewers respect explicit bounds.

## Runnable solution

Code: [`LRUCache.java`]({% link interviewDrills/LRUCache.java %})

Run it locally:

```bash
javac interviewDrills/LRUCache.java
java -cp interviewDrills LRUCache
```

Expected output:

```text
All LRUCache drill checks passed.
```
