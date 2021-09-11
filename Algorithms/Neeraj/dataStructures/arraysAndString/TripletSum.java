/*
Given an array arr of size n and an integer X.
Find if there's a triplet in the array which sums up to the given integer X.
Example:
INPUT: n = 6, X = 13
       arr[] = [1 4 45 6 10 8] 
OUTPUT: 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TripletSum
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    String inputLine[] = br.readLine().trim().split(" ");
	    int n = Integer.parseInt(inputLine[0]);
	    int X = Integer.parseInt(inputLine[1]);
	    int A[] = new int[n];
	    inputLine = br.readLine().trim().split(" ");
	    for(int i=0; i<n; i++){
	        A[i] = Integer.parseInt(inputLine[i]);
	    }
	    Solution ob=new Solution();
	    boolean ans = ob.find3Numbers(A, n, X);
	    System.out.println(ans?1:0);
	}
    static class Solution
    {
        public static boolean find3Numbers(int arr[], int n, int sum) {
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]>arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            for(int i=0;i<n-1;i++){
                int low = i+1;
                int high = n-1;
                int count = 0;
                while(low<high){
                    if(arr[low]+arr[high]+arr[i] == sum){
                        return true;
                    }
                    else if(arr[low]+arr[high]+arr[i] > sum){
                        high--;
                    }
                    else{
                        low++;
                    }
                }
            }
            return false;
        }
    }
}
