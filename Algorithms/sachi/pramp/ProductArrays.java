import java.util.Arrays;

public class ProductArrays {

    static int[] arrayOfArrayProducts(int[] arr) {
        // your code goes here
        //[8, 10, 2]
        //[1, 8, 80] -> Forward
        //[20 ,2 ,1] --> Backward Array
        //8
        //Base case
        if(arr == null || arr.length < 2) return new int[0];

        int[] f = new int[arr.length];
        int[] b = new int[arr.length];

        f[0] = 1;
        for(int i=1; i<arr.length; i++){
            f[i] = f[i-1] * arr[i-1];
        }

        b[arr.length-1] = 1;
        for(int i=arr.length-2; i>=0; i--){
            b[i] = b[i+1] * arr[i+1];
        }

        for(int i=0; i<arr.length; i++){
            arr[i] =  f[i] * b[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[]{8, 10, 2})));
    }

}
