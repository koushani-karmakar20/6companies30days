// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Parenthesis_6{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ArrayList<String> al=new ArrayList<>();
        helper(al,"",0,0,n);
        return al;
        
    }
    void helper(ArrayList<String> al,String s,int o,int c,int n)
    {
        if(o==n&&c==n)
        {al.add(s);return;}
        if(o<n)
        helper(al,s+"(",o+1,c,n);
        if(c<o)
        helper(al,s+")",o,c+1,n);
    }
}