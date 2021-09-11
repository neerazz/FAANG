/*
Given an array A of size N.Find the Kth prefix of the array.
Kth prefix is defined as the prefix sum of (K-1)th prefix of an array.
Example 1:
Input: N=4  K=2
       Array= {1,1,1,1}
Output: 1 3 6 10

Example 2:
Input: N=1 K=100
       Array= {1}
Output: 1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class KPrefix {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		long M= 1000000007;     //since the values can become pretty large
		int n,k;
		
		n=sc.nextInt();
		k=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
		    a[i]=sc.nextInt();
		}
		for(int i=0;i<k;i++){
		    for(int j=n-1;j>=0;j--){
		        for(int z=j-1;z>=0;z--){
		            a[j]+=a[z];
		        }
		    }
		}
		for(int i=0;i<n;i++){
		    System.out.print((a[i]%M)+" "); //printing the modulo 
		}
	}
}