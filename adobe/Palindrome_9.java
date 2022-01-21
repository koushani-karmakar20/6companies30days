// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Palindrome_9
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{public static void reverse(char num[], int i,
                                          int j)
    {
        while (i < j) {
            char temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
    public String nextPalin(String N) 
    { 
        //complete the function here
        char num[]=N.toCharArray();
        int n=num.length;
        if (n <= 3) {
           // System.out.println("Not Possible");
            return "-1";
        }
        char temp;
        
        int mid = n / 2 - 1;
        int i, j;
     
       
        for (i = mid - 1; i >= 0; i--)
            if (num[i] < num[i + 1])
                break;
     
        
        if (i < 0) {
            //System.out.println("Not Possible");
            return "-1";
        }
     
        
        int smallest = i + 1;
        for (j = i + 2; j <= mid; j++)
            if (num[j] > num[i] &&
                num[j] <= num[smallest])
                smallest = j;
     
        // swap num[i] with num[smallest]
        temp = num[i];
        num[i] = num[smallest];
        num[smallest] = temp;
        
        temp = num[n - i - 1];
        num[n - i - 1] = num[n - smallest - 1];
        num[n - smallest - 1] = temp;
         
        // reverse digits in the range (i+1)
        // to mid
        reverse(num, i + 1, mid);
     
        
        if (n % 2 == 0)
            reverse(num, mid + 1, n - i - 2);
     
        
        else
            reverse(num, mid + 2, n - i - 2);
     
        
        String result=String.valueOf(num);
      
                                  return result;
    }
}
