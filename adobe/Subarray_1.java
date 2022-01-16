// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Subarray_1{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> al=new ArrayList<>();
        int sum=arr[0],start=0;
        for(int i=1;i<=arr.length;i++)
        {
            while(sum>s)
            {sum-=arr[start];
                start++;
            }
            if(sum==s)
            {
                al.add(start+1);
                al.add(i);
                return al;
            }
            if(i<n)
            sum+=arr[i];
        }
        al.add(-1);
        return al;
    }
}