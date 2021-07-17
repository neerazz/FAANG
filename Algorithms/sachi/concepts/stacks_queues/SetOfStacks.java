package concepts.stacks_queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SetOfStacks {

    private List<Deque<Integer>> stacksList = new ArrayList<>();

    /*public void push(Integer x) {
        if (currentSize < MAX_SIZE) {
            if (!stacksList.isEmpty()) {
                stacksList.get(currentStack).push(x);
                currentSize++;
            } else {
                Deque<Integer> stack = new LinkedList<>();
                stack.push(x);
                stacksList.add(stack);
                currentSize++;
            }
        } else {
            Deque<Integer> stack = new LinkedList<>();
            stack.push(x);
            stacksList.add(stack);
            currentSize++;
            currentStack++;
        }
    }*/

    /*public Integer pop() {
        Integer val;
        if (stacksList.isEmpty()) {
            val = null;
        } else {
            val = stacksList.get(currentStack).pop();
            if (currentSize == 0) {
                currentStack--;
                currentSize = MAX_SIZE - 1;
            } else {
                currentSize--;
            }
        }
        return val;
    }*/

    //Test
    public static void main(String[] args) {
/*
        int testRuns = 1000;
        Deque<Integer> originalStack = new LinkedList<>();
        SetOfStacks setOfStacks = new SetOfStacks();
        for (int i = 0; i < testRuns; i++) {
            double random = Math.random();
            if (random > 0.2) {
                //Push
                int rand1 = (int) (Math.random() * 100);
                originalStack.push(rand1);
                setOfStacks.push(rand1);
            } else {
                //Pop
                if (originalStack.isEmpty()) continue;
                Integer orig = originalStack.pop();
                Integer dup = setOfStacks.pop();
                if (!orig.equals(dup)) {
                    System.out.printf("Expected %d but got %d", orig, dup);
                    break;
                }
            }
        }
*/
    }

}
