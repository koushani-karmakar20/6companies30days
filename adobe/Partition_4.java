// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Partition_4{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int i=0,j=0;
        int total=0;
        for(int n:arr)
        total+=n;
        if(total%2!=0)
        return 0;
       return helper(arr,N,total)?1:0;
    }
    static boolean helper(int arr[],int n,int total)
    {int i=0,j=0;
         boolean dp[][]=new boolean[total/2+1][n+1];
        for (i = 0; i <= n; i++)
            dp[0][i] = true;
 
        // initialize leftmost column, except part[0][0], as
        // 0
        for (i = 1; i <= total/ 2; i++)
            dp[i][0] = false;
 
        // Fill the partition table in bottom up manner
        for (i = 1; i <= total/ 2; i++) {
            for (j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1])
                    dp[i][j]
                        = dp[i][j]
                          || dp[i - arr[j - 1]][j - 1];
            }
        }
        return dp[total/ 2][n];
    }
   
}