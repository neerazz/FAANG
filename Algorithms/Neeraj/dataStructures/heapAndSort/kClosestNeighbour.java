/*
Lucy lives in house number X. She has a list of N house numbers in the society. Distance between houses can be determined by studying the difference between house numbers. Help her find out K closest neighbors.
**If two houses are equidistant and Lucy has to pick only one, the house with the smaller house number is given preference.
Example:
INPUT:N = 5, X = 0, K = 4
      a[] = {-21, 21, 4, -12,20}
OUTPUT: -21 -12 4 20
*/

import java.io.*;
import java.util.*; 
import java.lang.*;

class Info
{
	int distance;
	int houseno;
	Info(int x,int y)
	{
		distance = x;
		houseno = y;
	}
}

class Compare implements Comparator<Info>
{ 
	public int compare (Info p1,Info p2)
	{
		if (p1.distance == p2.distance)
		{
			if (p1.houseno < p2.houseno)
				return +1;
			if (p1.houseno > p2.houseno)
				return -1;
			return 0;
		}
		else
		{
		   	if (p1.distance < p2.distance)
				return +1;
			if (p1.distance > p2.distance)
				return -1;
			return 0;
		}
	}
}
class Solution 
{ 
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	    ArrayList<Integer> result= new ArrayList<Integer>();
		PriorityQueue<Info> pq = new PriorityQueue<Info>(k, new Compare());

		for (int i = 0; i < k; i++)
		{
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i]);
			pq.add(obj);
		}

		for (int i = k; i < n; i++)
		{
			int diff = Math.abs(arr[i] - x);
			if (pq.peek().distance < diff)
				continue;

			if (diff == pq.peek().distance && pq.peek().houseno < arr[i])
				continue;

			pq.remove();
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i]);
			pq.add(obj);
		}
		while (0 < pq.size())
		{
			result.add(pq.peek().houseno);
			pq.remove();
		}
		Collections.sort(result);
		return result;
	}
}

// Driver Code
class kClosestNeighbour{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        {
        	arr[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);

        for (int i=0; i<ans.size(); i++) 
            System.out.print(ans.get(i)+" "); 
        System.out.println();
    } 
} 