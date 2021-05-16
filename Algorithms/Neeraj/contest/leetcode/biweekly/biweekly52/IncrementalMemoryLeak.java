package biweekly.biweekly52;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-52/problems/incremental-memory-leak/
 */

public class IncrementalMemoryLeak {

    public static void main(String[] args) {

    }

    public static int[] memLeak(int memory1, int memory2) {
        int[] memory = {memory1, memory2};
        int cpu = 1, time = 1;
        while (Math.max(memory[0], memory[1]) >= cpu) {
            if (memory[0] >= memory[1]) {
                memory[0] -= cpu;
            } else {
                memory[1] -= cpu;
            }
            time = ++cpu;
        }
        return new int[]{time, memory[0], memory[1]};
    }
}
