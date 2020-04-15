import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }

    public static  boolean isHappy(int n) {
        if(n == 1) return true;
        if(set.contains(n)) return false;
        set.add(n);
        int curr = n;
        n = 0;
        while(curr > 0){
            int temp  = curr%10;
            n += (temp*temp);
            curr = curr/10;
        }
        return isHappy(n);
    }
}
