/*
Given a list of N strings. Find out if the list of strings is valid or not.
A list is said to be valid when number of duplicate strings do not exceed the number
of unique strings. Strings are not case-sensitive.
Example 1:
INPUT: list={"cd","cdd","cd","cdd"}
OUTPUT: Yes

Example 2:
INPUT: list={"pqr","PQr","Pqr"}
OUTPUT: No
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


//Driver code
class UniqueList
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input[] = read.readLine().trim().split("\\s+");
        ArrayList<String>list=new ArrayList<>();
        for(int i = 0; i < input.length; i++)
            list.add(input[i]);
        Solution ob = new Solution();
        System.out.println(ob.uniqueList(list));
    }
    static class Solution{
        public String uniqueList(ArrayList<String>list){
            HashSet<String> h= new HashSet<String>();
            for(String s:list)
            {
                h.add(s.toLowerCase());
            }

            int duplicates = list.size() - h.size();
            if(2*h.size()<list.size()){
                return "No";
            }
            return "Yes";
        }
    }
}