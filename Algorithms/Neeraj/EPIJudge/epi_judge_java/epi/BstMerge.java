package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BstMerge {

    @EpiTest(testDataFile = "bst_merge.tsv")
    public static BstNode<Integer> mergeTwoBsts(BstNode<Integer> A,
                                                BstNode<Integer> B) {
        LinkedList<Integer> list1 = getList(A), list2 = getList(B);
        List<Integer> merge = new ArrayList<>();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.getFirst() <= list2.getFirst()) {
                merge.add(list1.removeFirst());
            } else {
                merge.add(list2.removeFirst());
            }
        }
        if (!list1.isEmpty()) merge.addAll(list1);
        if (!list2.isEmpty()) merge.addAll(list2);
        return createBst(merge);
    }

    private static BstNode<Integer> createBst(List<Integer> list) {
        if (list.isEmpty()) return null;
        if (list.size() == 1) return new BstNode<>(list.get(0));
        int mid = list.size() / 2;
        BstNode<Integer> bstNode = new BstNode<>(list.get(mid));
        bstNode.left = createBst(list.subList(0, mid));
        bstNode.right = createBst(list.subList(mid + 1, list.size()));
        return bstNode;
    }

    private static LinkedList<Integer> getList(BstNode<Integer> bst) {
        if (bst == null) return new LinkedList<>();
        LinkedList<Integer> list = getList(bst.getLeft());
        list.add(bst.data);
        list.addAll(getList(bst.right));
        return list;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "BstMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
