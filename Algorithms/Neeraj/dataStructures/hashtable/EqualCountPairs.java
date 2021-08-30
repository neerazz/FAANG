/*
For a given array A, find the number of pairs(i,j) such that
i<j and A[i]=A[j].
Example 1:
INPUT: A={1,2,2,1,1}
OUTPUT: 4
***Required pairs are (1,4),(1,5),(2,3),(4,5)

Example 2:
INPUT: A={1,2,3,5}
OUTPUT: 0
*/

import java.util.*;
import java.io.*;

class Solution{
    public long equalCount(int N, int[]A){
        long ans=0;
        HashMap<Integer,Long>mp=new HashMap<>();
        for(int i=0;i<N;i++)
            mp.put(A[i],mp.getOrDefault(A[i],0l)+1l);
        for(Map.Entry<Integer,Long>e:mp.entrySet())
        {
            long val=e.getValue();
            ans+=(val*(val-1))/2;
        }
        return ans;
    }
}

// Driver Code

class EqualCountPairs
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
        int N=Integer.parseInt(read.readLine());
        String input[] = read.readLine().trim().split("\\s+");
        int[]A=new int[N];
        for(int i = 0; i < N; i++)
            A[i]=Integer.parseInt(input[i]);
        Solution ob = new Solution();
        System.out.println(ob.equalCount(N, A));
    }
}