// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigits_6
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        String map[]=new String[10];
        Arrays.fill(map,"");
        
        map[2]="abc";
        map[3]="def";
        map[4]="ghi";
        map[5]="jkl";
        map[6]="mno";
        map[7]="pqrs";
        map[8]="tuv";
        map[9]="wxyz";
        
        ArrayList<String> ans=new ArrayList<>();
        helper(a,N,0,"",ans,map);
        return ans;
    }
    static void helper(int a[],int N,int curr_index,String op,ArrayList<String> ans,String map[])
    {
        if(curr_index==N)
        {ans.add(op);op="";}
        else
        {
            String s=map[a[curr_index]];
            for(int i=0;i<s.length();i++)
            {
                helper(a,N,curr_index+1,op+s.charAt(i),ans,map);
            }
        }
    }
}


