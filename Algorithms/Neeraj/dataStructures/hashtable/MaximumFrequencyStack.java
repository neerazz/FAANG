/*
    Created on:  Apr 15, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println("******************************");
        freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    static class FreqStack {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Stack<Integer>> frequencyGroup = new HashMap<>();
        int maxfreq = 0;

        public void push(int x) {
            int curFreq = frequencyMap.getOrDefault(x, 0) + 1;
            frequencyMap.put(x, curFreq);
            frequencyGroup.computeIfAbsent(curFreq, i -> new Stack<>()).add(x);
            frequencyGroup.putIfAbsent(curFreq, new Stack<>());
            frequencyGroup.get(curFreq).add(x);
            maxfreq = Math.max(maxfreq, curFreq);
        }

        public int pop() {
            Stack<Integer> stack = frequencyGroup.get(maxfreq);
            int value = stack.pop();
            frequencyMap.put(value, maxfreq - 1);
            if (stack.isEmpty()) maxfreq--;
            return value;
        }
    }

    static class FreqStack_Wrong {
        Map<Integer, Set<Integer>> map;
        TreeMap<Integer, Set<Integer>> freqencyMap;
        int max = 0;

        public FreqStack_Wrong() {
            map = new HashMap<>();
            freqencyMap = new TreeMap<>();
        }

        public void push(int x) {
//         Get the occurance count.
            map.putIfAbsent(x, new HashSet<>());
            int count = map.get(x).size();
            map.get(x).add(max);
            increaseFrequencyMap(count, x);
            max++;
        }

        public int pop() {
            int highestFreq = freqencyMap.lastKey();
//         Loop through the list and get the highest index element.
            int maxIndex = Integer.MIN_VALUE, value = 0;
            for (int maxFreVal : freqencyMap.get(highestFreq)) {
//             Loop through the index map to get maximum index element
                for (int idx : map.get(maxFreVal)) {
                    if (maxIndex < idx) {
                        maxIndex = idx;
                        value = maxFreVal;
                    }
                }
            }
            max--;
//         Remove that index from the index map.
            map.get(value).remove(maxIndex);
            reduceFrequencyMap(highestFreq, value);
            return value;
        }

        void increaseFrequencyMap(int count, int x) {
            if (count > 0) {
                if (freqencyMap.containsKey(count)) {
                    freqencyMap.get(count).remove(x);
                }
                freqencyMap.putIfAbsent(count + 1, new HashSet<>());
                freqencyMap.get(count + 1).add(x);
            } else {
                freqencyMap.putIfAbsent(1, new HashSet<>());
                freqencyMap.get(1).add(x);
            }
        }

        void reduceFrequencyMap(int count, int x) {
            if (count == 1) {
//             Then just remove that element from the frequency map
                freqencyMap.get(count).remove(x);
            } else {
                Set<Integer> integers = freqencyMap.get(count);
                if (integers.size() > 1) {
                    freqencyMap.get(count).remove(x);
                } else {
                    freqencyMap.remove(count);
                }
                freqencyMap.putIfAbsent(count - 1, new HashSet<>());
                freqencyMap.get(count - 1).add(x);
            }
        }
    }
}
