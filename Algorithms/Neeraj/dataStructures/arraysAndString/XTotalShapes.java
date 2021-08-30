/*
Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
***'X' shape consists of one or more adjacent X's (diagonals not included).
Example:
INPUT:  n=3 m=3
        grid = {{X,O,X},{O,X,O},{X,X,X}}
OUTPUT: 3
*/

import java.util.*;
import java.lang.*;
import java.io.*;
//Driver code
class XTotalShapes
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char[][] grid = new char[n][m];
        for(int i = 0; i < n; i++){
            String S = br.readLine().trim();
            for(int j = 0; j < m; j++){
                grid[i][j] = S.charAt(j);
            }
        }
        Solution obj = new Solution();
        int ans = obj.xShape(grid);
        System.out.println(ans);
    }
}

class Solution
{
    //Function to find the number of 'X' total shapes.
    public boolean val(char[][] grid,boolean[][] vis,int r,int c)
    {
        return (r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&!vis[r][c]&&grid[r][c]=='X');
    }
    public int xShape(char[][] grid)
    {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='X'&&!vis[i][j])
                {
                    dfs(grid,vis,i,j);
                    res+=1;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,boolean[][] vis,int i,int j)
    {
        int r[]={1,0,0,-1};
        int c[]={0,1,-1,0};
        vis[i][j]=true;
        for(int a=0;a<4;a++)
        {
            if(val(grid,vis,i+r[a],j+c[a]))
            dfs(grid,vis,i+r[a],j+c[a]);
        }
    }
}
