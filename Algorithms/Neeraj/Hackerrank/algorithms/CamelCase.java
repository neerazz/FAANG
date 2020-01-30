package algorithms;

public class CamelCase {
    public static void main(String[] args) {
        System.out.println(camelcase("saveChangesInTheEditor"));
    }

    static int camelcase(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int result =1;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))){
                result++;
            }
        }
        return result;
    }
}
