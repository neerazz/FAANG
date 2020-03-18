public class Decode {

    static int decodeVariations(String S) {
        // your code goes here
        //1262
        int[] sol = new int[S.length()];
        sol[0] = 1;
        for(int i=1; i<S.length(); i++){
            char c1 = S.charAt(i-1);  //6
            char c2 = S.charAt(i); //2
            int str = c1+c2;
            if(str <=26){
                sol[i] = sol[i-1] + 1;  //1 2 3
            }else{
                sol[i] = sol[i-1]; //1 2 3 3
            }
        }
        return sol[S.length()-1];

    }

    public static void main(String[] args) {
        decodeVariations("1262");
    }

}
