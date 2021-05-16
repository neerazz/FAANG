package biweekly.biweekly43;

/**
 * Created on:  Jan 09, 2021
 * Questions:
 */

public class CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {

    }
    public int totalMoney(int n) {
        int total =0, val =1, cur = 1;
        while(cur <= n){
            for(int i=0;i<7 && cur <= n; i++){
                total += val+i;
                cur++;
            }
            val++;
        }
        return total;
    }
}
