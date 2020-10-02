import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created on:  Sep 30, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_interview/?interview_id=803484747071632
 * Answer a Query
 * Imagine a length-N array of booleans, initially all false. Over time, some values are set to true, and at various points in time you would like to find the location of the nearest true to the right of given indices.
 * You will receive Q queries, each of which has a type and a value. SET queries have type = 1 and GET queries have type = 2.
 * When you receive a SET query, the value of the query denotes an index in the array that is set to true. Note that these indices start at 1. When you receive a GET query, you must return the smallest index that contains a true value that is greater than or equal to the given index, or -1 if no such index exists.
 * Signature
 * int[] answerQueries(ArrayList<Query> queries, int N)
 * Input
 * A list of Q queries, formatted as [type, index] where type is either 1 or 2, and index is < N
 * 1 <= N <= 1,000,000,000
 * 1 <= Q <= 500,000
 * Output
 * Return an array containing the results of all GET queries. The result of queries[i] is the smallest index that contains a true value that is greater than or equal to i, or -1 if no index satisfies those conditions.
 * Example
 * N = 5
 * Q = 5
 * queries = [[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]
 * output = [-1, 2, -1, 2]
 * The initial state of the array is [false, false, false, false, false].
 * The first query is GET 3, but no values in the array are true, so the answer is -1.
 * The second query is SET 2, so the value at index 2 is set to true.
 * The new state of the array is [false, true, false, false, false].
 * The third query is GET 1, and the index of the true value nearest to 1 (to the right) is 2.
 * The fourth query is GET 3, but no values to the right of index 3 are true.
 * The fifth query is GET 2, and the value at index 2 is true.
 */
public class AnswerAQuery {
    public static void main(String[] args) {

    }

    int[] answerQueries(ArrayList<Query> queries, int N) {
        int len = queries.size(), idx = 0;
        int[] result = new int[len];
        TreeSet<Integer> set = new TreeSet<>();
        for (Query query : queries) {
            int cur = 0;
            if (query.type == 1) {
                set.add(cur = query.val);
            } else {
                Integer ceiling = set.ceiling(query.val);
                cur = ceiling == null ? -1 : ceiling;
            }
            result[idx++] = cur;
        }
        return result;
    }

    static class Query {
        int type;
        int val;
    }
}
