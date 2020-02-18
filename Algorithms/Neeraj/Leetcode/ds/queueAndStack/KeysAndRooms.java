package ds.queueAndStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
Solution: There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
Initially, all the rooms start locked (except for room 0).
You can walk back and forth between rooms freely.
Return true if and only if you can enter every room.

Example 1:
Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:
Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:
1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.
 */
public class KeysAndRooms {
    public static void main(String[] args) {

        List<Integer> room1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(3));
        List<Integer> room4 = new ArrayList<>();
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        System.out.println("Answer is: " + canVisitAllRooms(rooms) + " should be [true].");
        System.out.println("================================");
        rooms = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(3, 0, 1)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(0))));
        System.out.println("Answer is: " + canVisitAllRooms(rooms) + " should be [false].");
        System.out.println("================================");
        rooms = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(1))));
        System.out.println("Answer is: " + canVisitAllRooms(rooms) + " should be [true].");
        System.out.println("================================");
        rooms = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(6, 7, 8)),
                new ArrayList<>(Arrays.asList(5, 4, 9)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(8)),
                new ArrayList<>(Arrays.asList(4)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(1, 9, 2, 3)),
                new ArrayList<>(Arrays.asList(7)),
                new ArrayList<>(Arrays.asList(6, 5)),
                new ArrayList<>(Arrays.asList(2, 3, 1))));
        System.out.println("Answer is: " + canVisitAllRooms(rooms) + " should be [true].");
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        stack.add(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei : rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }
        for (boolean v : seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }
}
