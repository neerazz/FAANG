/*
Gotham has been attacked by Joker . Bruce Wayne has deployed an automatic machine gun at each tower of Gotham.
All the towers in Gotham are in a straight line.
You are given no of towers 'n' followed by the height of 'n' towers.
For every tower(p), find the height of the closest tower (towards the right), greater than the height of the tower(p).
Now, the Print sum of all such heights (mod 1000000001).
Example:
INPUT:  n = 9
        112 133 161 311 122  512 1212 0 19212
OUTPUT: 41265
*/

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] element = line.trim().split("\\s+");
		int sizeOfArray = Integer.parseInt(element[0]);
		     
		int arr [] = new int[sizeOfArray];
		    
		line = br.readLine();
		String[] elements = line.trim().split("\\s+");
		for(int i = 0;i<sizeOfArray;i++){
		    arr[i] = Integer.parseInt(elements[i]);
		}
		Solution obj = new Solution();
		int ans = obj.save_gotham(arr, sizeOfArray);
		System.out.println(ans);
	}
}

class Solution{
    public static int save_gotham (int arr[], int n) 
    {     
        int ans = 0 ;
        for(int i = 0 ; i < arr.length ; i ++)
        {
            for(int j = i+1 ; j < arr.length ; j ++)
            {
                if(arr[i]<arr[j])
                {
                    ans += arr[j];
                    break;
                }
            }
        }        
        return ans;
    }
}
