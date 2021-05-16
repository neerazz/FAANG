package weekly.weekly215;

import java.util.*;

/**
 * Created on:  Nov 14, 2020
 * Questions:
 */

public class DesignAnOrderedStream {

    public static void main(String[] args) {

    }

    static class OrderedStream {
        String[] str;
        int ptr;

        public OrderedStream(int n) {
            str = new String[n];
            ptr = 0;
        }

        public List<String> insert(int id, String value) {
            str[id - 1] = value;
            List<String> result = new ArrayList<>();
            while (ptr < str.length && str[ptr] != null) {
                result.add(str[ptr++]);
            }
            return result;
        }
    }
}
