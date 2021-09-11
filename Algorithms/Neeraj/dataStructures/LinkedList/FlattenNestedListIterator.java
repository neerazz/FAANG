import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Nov 17, 2020
 * Questions: https://leetcode.com/problems/flatten-nested-list-iterator/
 */

public class FlattenNestedListIterator {

    public static void main(String[] args) {

    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {

        LinkedList<Integer> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>();
            processNestedList(nestedList);
        }

        private void processNestedList(List<NestedInteger> nestedList) {
            for (NestedInteger nested : nestedList) {
                if (nested.isInteger()) {
                    list.add(nested.getInteger());
                } else {
                    processNestedList(nested.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
