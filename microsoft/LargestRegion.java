import java.util.*;
import java.lang.*;
import java.io.*;
class LargestRegion
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{int count=1;
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
       
        int ans=0;
        int r=grid.length;
        int c=grid[0].length;
         boolean vis[][]=new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {count=1;
                if(grid[i][j]==1&&!vis[i][j])
                {
                    dfs(grid,i,j,vis);
                    ans=Math.max(ans,count);}
            }
        }
        return ans;
    }
    public void dfs(int grid[][],int i,int j,boolean vis[][])
    {vis[i][j]=true;
        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
        for(int dir[]:dirs)
        {
            int nexti=i+dir[0];
            int nextj=j+dir[1];
            if(nexti>=0&&nextj>=0&&nexti<grid.length&&nextj<grid[0].length&&vis[nexti][nextj]==false&&grid[nexti][nextj]==1)
            
            {
                count++;
                dfs(grid,nexti,nextj,vis);}
            
            
        }
        //return 
        //return area;
    }
}