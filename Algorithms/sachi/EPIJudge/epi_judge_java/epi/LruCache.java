package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {

    Map<Integer, Integer> isbnCache;

    LruCache(final int capacity) {
        isbnCache = new HashMap<>();
    }

    @EpiTest(testDataFile = "lru_cache.tsv")
    public static void runTest(List<Op> commands) throws TestFailure {
        if (commands.isEmpty() || !commands.get(0).code.equals("LruCache")) {
            throw new RuntimeException("Expected LruCache as first command");
        }
        LruCache cache = new LruCache(commands.get(0).arg1);
        for (Op op : commands.subList(1, commands.size())) {
            int result;
            switch (op.code) {
                case "lookup":
                    result = cache.lookup(op.arg1);
                    if (result != op.arg2) {
                        throw new TestFailure("Lookup: expected " + op.arg2 +
                                ", got " + result);
                    }
                    break;
                case "insert":
                    cache.insert(op.arg1, op.arg2);
                    break;
                case "erase":
                    result = cache.erase(op.arg1) ? 1 : 0;
                    if (result != op.arg2) {
                        throw new TestFailure("Erase: expected " + op.arg2 +
                                ", got " + result);
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected command " + op.code);
            }
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LruCache.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public Integer lookup(Integer key) {
        // TODO - you fill in here.
        return isbnCache.get(key);
    }

    public void insert(Integer key, Integer value) {
        // TODO - you fill in here.
        //evict and add
        isbnCache.put(key, value);
    }

    public Boolean erase(Object key) {
        // TODO - you fill in here.
        if (isbnCache.containsKey(key)) {
            isbnCache.remove(key);
            return true;
        }
        return false;
    }

    @EpiUserType(ctorParams = {String.class, int.class, int.class})
    public static class Op {
        String code;
        int arg1;
        int arg2;

        public Op(String code, int arg1, int arg2) {
            this.code = code;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }
    }
}
