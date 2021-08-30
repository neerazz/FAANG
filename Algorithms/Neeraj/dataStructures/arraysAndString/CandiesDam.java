/*
Nehal wants to make a special space for candies on his bookshelf.Currently, it has N books of different heights and unit width. 
Help him select 2 books such that he can store maximum candies between them by removing all the other books from between the selected books.
The task is to find out the area between 2 books that can hold the maximum candies without changing the original position of selected books. 
Example:
INPUT: N =3
       height[]={1,3,4}
OUTPUT:1
*/

import java.io.*;
import java.util.*; 

class Solution 
{ 
	static int maxCandy(int height[], int n) 
	{ 
	    int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int current = (Math.min(height[i],height[j])* (j - i - 1));
                max = Math.max(max, current);
            }
        }
        return max;
	}
}

// Driver Code 
class CandiesDam{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; ++i)
        {
            height[i] = sc.nextInt();
        }

        Solution ob = new Solution();
        System.out.println(ob.maxCandy(height,n));
	} 
} 

