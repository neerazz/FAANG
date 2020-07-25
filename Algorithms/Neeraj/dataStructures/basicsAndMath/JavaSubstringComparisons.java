

/*
Problem: https://www.hackerrank.com/challenges/java-string-compare/problem
 */
public class JavaSubstringComparisons {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3) + " \nAnswer should be [ava, wel]");
        System.out.println(getSmallestAndLargest(
                "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs", 30)
                + " \nAnswer should be \nASDFHDSFHsdlfhsdlfLDFHSDLFHsdl\n" + "sdlkfhsdlfhsLFDLSFHSDLFHsdkfhs");
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        int starting = 0, ending = k, length = s.length();

        while (ending <= length) {
            String current = s.substring(starting, ending);

            if (smallest.isEmpty() && largest.isEmpty()) {
                smallest = current;
                largest = current;
            } else {
                if (current.compareTo(smallest) < 0) {
                    smallest = current;
                }
                if (current.compareTo(largest) > 0) {
                    largest = current;
                }
            }
            starting++;
            ending++;
//            System.out.println(current);
        }
        return smallest + "\n" + largest;
    }
}
