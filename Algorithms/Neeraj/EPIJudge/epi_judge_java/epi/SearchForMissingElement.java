package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.List;

public class SearchForMissingElement {
    @EpiUserType(ctorParams = {Integer.class, Integer.class})

    public static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            DuplicateAndMissing that = (DuplicateAndMissing) o;

            if (!duplicate.equals(that.duplicate)) {
                return false;
            }
            return missing.equals(that.missing);
        }

        @Override
        public int hashCode() {
            int result = duplicate.hashCode();
            result = 31 * result + missing.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "duplicate: " + duplicate + ", missing: " + missing;
        }
    }

    //    Sol : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
    @EpiTest(testDataFile = "find_missing_and_duplicate.tsv")
    public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
//        XOR all the elements and the index.
//        Assume x & y is missing and duplicate. Either of them can be missing or dublicate.
        int xor = 0, len = A.size(), x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            xor ^= i ^ A.get(i);
        }
//        XOR will now have (x ^ y)
//        Now find a point were the xor value is 1.
//        ~(xor-1) will have the binary value of xor's right most 1.
        int point = xor & ~(xor - 1);
        for (int num : A) {
//            Divide all elements into two.
            if ((num & point) != 0) {
//                One set will have all elements that have one at the point.
                x ^= num;
            } else {
//                The other will have all elements that have zero at that point.
                y ^= num;
            }
        }
//        Now divide all indexes into two elements similar to above.
        for (int i = 0; i < len; i++) {
            if ((i & point) != 0) x ^= i;
            else y ^= i;
        }
//        One last time loop through the array check if x is present in the list then x will be duplicate and y will be missing and vise-versa.
        return A.contains(x) ? new DuplicateAndMissing(x,y) : new DuplicateAndMissing(y,x);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SearchForMissingElement.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
