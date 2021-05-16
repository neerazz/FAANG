package weekly.weekly179;

import java.util.*;

class GenerateTheString {
    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        if (n % 2 == 0) {
            //Then even number of times.
            char[] chars = new char[n-1];
            Arrays.fill(chars,'a');
            sb.append(chars);
            sb.append('b');
            return sb.toString();
        }else{
            // Odd number of times.
            char[] chars = new char[n];
            Arrays.fill(chars,'a');
            sb.append(chars);
            return sb.toString();
        }
    }
}
