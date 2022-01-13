import java.io.*;
import java.util.*;

class MinSteps_14{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int D){
        // code here
       D=Math.abs(D);
       int ans=0,step=0;
       while(ans<D||(D-ans)%2!=0)
       {
           step++;
           ans+=step;
       }
       return step;
    }
   
}